package io.contek.invoker.binancelinear.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

@NotThreadSafe
public class _FeeRates {

  public String symbol;
  public BigDecimal makerCommissionRate;
  public BigDecimal takerCommissionRate;
}
