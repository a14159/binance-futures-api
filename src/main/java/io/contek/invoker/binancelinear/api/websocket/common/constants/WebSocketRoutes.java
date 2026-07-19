package io.contek.invoker.binancelinear.api.websocket.common.constants;

import javax.annotation.concurrent.Immutable;

@Immutable
public final class WebSocketRoutes {

  public static final String PUBLIC = "/public";

  public static final String MARKET = "/market";

  public static final String PRIVATE = "/private";

  private WebSocketRoutes() {}
}
