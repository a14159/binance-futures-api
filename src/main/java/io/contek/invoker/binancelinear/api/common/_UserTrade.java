package io.contek.invoker.binancelinear.api.common;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class _UserTrade {

  public boolean buyer;
  public Double commission;
  public String commissionAsset;
  public String id;
  public boolean maker;
  public String orderId;
  public Double price;
  public Double qty;
  public Double quoteQty;
  public Double realizedPnl;
  public String side;
  public String positionSide;
  public String symbol;
  public long time;
  public long traceNano = System.nanoTime();
}
