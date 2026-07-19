package io.contek.invoker.binancelinear.api.websocket.market.combined;

import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.websocket.AnyWebSocketMessage;
import io.contek.invoker.commons.websocket.BaseWebSocketApi;
import io.contek.invoker.commons.websocket.IWebSocketAuthenticator;
import io.contek.invoker.commons.websocket.IWebSocketLiveKeeper;
import io.contek.invoker.commons.websocket.WebSocketCall;
import io.contek.invoker.commons.websocket.WebSocketContext;
import io.contek.invoker.commons.websocket.WebSocketRuntimeException;
import io.contek.invoker.security.ICredential;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
final class MarketCombinedEndpoint extends BaseWebSocketApi {

  private final WebSocketContext context;
  private final String route;

  MarketCombinedEndpoint(IActor actor, WebSocketContext context, String route) {
    super(
        actor,
        MarketCombinedMessageParser.getInstance(),
        IWebSocketAuthenticator.noOp(),
        IWebSocketLiveKeeper.noOp());
    this.context = context;
    this.route = route;
  }

  @Override
  protected WebSocketCall createCall(ICredential credential) {
    return WebSocketCall.fromUrl(context.getBaseUrl() + route + "/stream");
  }

  @Override
  protected void checkErrorMessage(AnyWebSocketMessage message) throws WebSocketRuntimeException {
    MarketCombinedWebSocketApi.checkError(message);
  }
}
