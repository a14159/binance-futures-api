package io.contek.invoker.binancelinear.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;
import java.util.List;

@NotThreadSafe
public class _Leverage {
  public String symbol;
  public List<_LeverageBracket> brackets;
}
