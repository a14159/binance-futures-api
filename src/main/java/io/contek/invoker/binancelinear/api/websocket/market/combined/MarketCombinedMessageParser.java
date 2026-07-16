package io.contek.invoker.binancelinear.api.websocket.market.combined;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import io.contek.invoker.binancelinear.api.websocket.market.BookTickerEvent;
import io.contek.invoker.commons.websocket.AnyWebSocketMessage;
import io.contek.invoker.commons.websocket.IWebSocketComponent;
import io.contek.invoker.commons.websocket.WebSocketTextMessageParser;

import javax.annotation.concurrent.Immutable;

import static io.contek.invoker.binancelinear.api.websocket.common.constants.WebSocketChannelKeys.*;

@Immutable
final class MarketCombinedMessageParser extends WebSocketTextMessageParser {

  static MarketCombinedMessageParser getInstance() {
    return MarketCombinedMessageParser.InstanceHolder.INSTANCE;
  }

  @Override
  public void register(IWebSocketComponent component) {}

  @Override
  protected AnyWebSocketMessage fromText(String text) {
    JSONObject json = JSON.parseObject(text);
    if (json.containsKey("id") || json.containsKey("code")) {
      return toRequestConfirmation(json);
    }
    if (json.containsKey("stream")) {
      return toStreamData(json);
    }
    return toBookTicker(json);
  }

  private AnyWebSocketMessage toRequestConfirmation(JSONObject obj) {
    return obj.toJavaObject(WebSocketCommandConfirmation.class);
  }

  private AnyWebSocketMessage toStreamData(JSONObject obj) {
    String stream = obj.getString("stream");
    int typeOffset = stream.indexOf('@') + 1;
    if (typeOffset == 0 || typeOffset == stream.length()) {
      throw new IllegalArgumentException(stream);
    }
    if (hasType(stream, typeOffset, _bookTicker)) {
      return obj.toJavaObject(BookTickerChannel.Message.class);
    }
    if (hasType(stream, typeOffset, _trade)) {
      return obj.toJavaObject(TradeChannel.Message.class);
    }
    if (hasType(stream, typeOffset, _aggTrade)) {
      return obj.toJavaObject(AggTradeChannel.Message.class);
    }
    if (hasType(stream, typeOffset, _depth)) {
      return obj.toJavaObject(DepthDiffChannel.Message.class);
    }
    if (hasType(stream, typeOffset, _depth5)
        || hasType(stream, typeOffset, _depth10)
        || hasType(stream, typeOffset, _depth20)) {
      return obj.toJavaObject(DepthPartialChannel.Message.class);
    }
    if (hasType(stream, typeOffset, _forceOrder)) {
      return obj.toJavaObject(ForceOrderChannel.Message.class);
    }
    throw new IllegalStateException(stream);
  }

  private static boolean hasType(String stream, int typeOffset, String type) {
    int typeEnd = typeOffset + type.length();
    return typeEnd <= stream.length()
        && stream.regionMatches(typeOffset, type, 0, type.length())
        && (typeEnd == stream.length() || stream.charAt(typeEnd) == '@');
  }

  private AnyWebSocketMessage toBookTicker(JSONObject obj) {
    return obj.toJavaObject(BookTickerEvent.class);
  }

  private MarketCombinedMessageParser() {}

  @Immutable
  private static class InstanceHolder {

    private static final MarketCombinedMessageParser INSTANCE = new MarketCombinedMessageParser();

    private InstanceHolder() {}
  }
}
