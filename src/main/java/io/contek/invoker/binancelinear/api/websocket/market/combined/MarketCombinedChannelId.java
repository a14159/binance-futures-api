package io.contek.invoker.binancelinear.api.websocket.market.combined;

import io.contek.invoker.commons.websocket.BaseWebSocketChannelId;

import javax.annotation.concurrent.Immutable;

@Immutable
abstract class MarketCombinedChannelId<Message extends WebSocketStreamMessage<?>>
    extends BaseWebSocketChannelId<Message> {

  private final String[] requestParams;

  protected MarketCombinedChannelId(String streamName) {
    super(streamName);
    requestParams = new String[] {streamName};
  }

  final String[] getRequestParams() {
    return requestParams;
  }

  @Override
  public final boolean accepts(Message message) {
    return getValue().equals(message.stream);
  }
}
