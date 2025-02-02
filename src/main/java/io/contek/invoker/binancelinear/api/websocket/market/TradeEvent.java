package io.contek.invoker.binancelinear.api.websocket.market;

import io.contek.invoker.binancelinear.api.websocket.common.WebSocketEventData;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class TradeEvent extends WebSocketEventData {

  public String s; // Symbol
  public Long t; // Trade ID
  public Double p; // Price
  public Double q; // Quantity
  public Long T; // Trade time
  public Boolean m; // Is the buyer the market maker?
  public long traceNano = System.nanoTime();
}
