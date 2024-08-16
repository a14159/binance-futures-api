package io.contek.invoker.binancelinear.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

@NotThreadSafe
public class _UserTrade {

  public boolean buyer;
  public BigDecimal commission;
  public String commissionAsset;
  public String id;
  public boolean maker;
  public String orderId;
  public BigDecimal price;
  public BigDecimal qty;
  public BigDecimal quoteQty;
  public BigDecimal realizedPnl;
  public String side;
  public String positionSide;
  public String symbol;
  public long time;
  public long traceNano = System.nanoTime();
}
