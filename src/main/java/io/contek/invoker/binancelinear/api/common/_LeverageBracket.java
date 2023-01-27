package io.contek.invoker.binancelinear.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

@NotThreadSafe
public class _LeverageBracket {

  public int bracket;
  public int initialLeverage;
  public long notionalCap;
  public long notionalFloor;
  public BigDecimal maintMarginRatio;
  public BigDecimal cum;
}
