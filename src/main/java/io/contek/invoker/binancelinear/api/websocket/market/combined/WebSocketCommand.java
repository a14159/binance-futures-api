package io.contek.invoker.binancelinear.api.websocket.market.combined;

import io.contek.invoker.commons.websocket.AnyWebSocketMessage;

import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
final class WebSocketCommand extends AnyWebSocketMessage {

  public String method;
  public String[] params;
  public Integer id;
}
