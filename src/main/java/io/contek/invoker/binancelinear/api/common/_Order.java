package io.contek.invoker.binancelinear.api.common;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class _Order {

  public String symbol;
  public String orderId;
  public String clientOrderId;
  public Double price;
  public Double avgPrice;
  public Double origQty;
  public Double executedQty;
  public String status;
  public String timeInForce;
  public String type;
  public boolean reduceOnly;
  public String side;
  public String positionSide;
  public Double stopPrice;
  public long updateTime;
  public String workingType;
  public long traceNano = System.nanoTime();
}
