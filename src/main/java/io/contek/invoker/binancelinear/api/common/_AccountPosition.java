package io.contek.invoker.binancelinear.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

@NotThreadSafe
public class _AccountPosition {

  public String symbol;
  public BigDecimal initialMargin;
  public BigDecimal maintMargin;
  public BigDecimal unrealizedProfit;
  public BigDecimal positionInitialMargin;
  public BigDecimal openOrderInitialMargin;
  public BigDecimal leverage;
  public Boolean isolated;
  public BigDecimal entryPrice;
  public BigDecimal maxNotional;
  public BigDecimal bidNotional;
  public BigDecimal askNotional;
  public String positionSide;
  public BigDecimal positionAmt;
  public long updateTime;
}
