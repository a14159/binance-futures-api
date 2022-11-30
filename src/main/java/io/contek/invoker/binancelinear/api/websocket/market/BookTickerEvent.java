package io.contek.invoker.binancelinear.api.websocket.market;

import io.contek.invoker.binancelinear.api.websocket.common.WebSocketEventData;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

@NotThreadSafe
public class BookTickerEvent extends WebSocketEventData {

  public long u; // order book updateId
  public long T; // transaction time
  public String s; // symbol
  public BigDecimal b; // best bid price
  public BigDecimal B; // best bid qty
  public BigDecimal a; // best ask price
  public BigDecimal A; // best ask qty
}
