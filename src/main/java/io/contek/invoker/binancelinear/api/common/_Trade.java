package io.contek.invoker.binancelinear.api.common;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class _Trade {

  public String id;
  public Double price;
  public Double qty;
  public Long time;
  public Boolean isBuyerMaker;
  public Boolean isBestMatch;
  public long traceNano = System.nanoTime();
}
