package io.contek.invoker.binancelinear.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

@NotThreadSafe
public class _BookTicker {

  public String symbol;
  public BigDecimal bidPrice;
  public BigDecimal bidQty;
  public BigDecimal askPrice;
  public BigDecimal askQty;
  public long time;
}
