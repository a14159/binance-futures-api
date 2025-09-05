package io.contek.invoker.binancelinear.api.websocket.market;

import io.contek.invoker.binancelinear.api.websocket.common.WebSocketEventData;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class AggTradeEvent extends WebSocketEventData {

  public String s; // Symbol
  public long a; // Aggregate trade ID
  public Double p; // Price
  public Double q; // Quantity
  public long f; // First trade ID
  public long l; // Last trade ID
  public long T; // Trade time
  public boolean m; // Is the buyer the market maker?
}
