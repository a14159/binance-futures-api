package io.contek.invoker.binancelinear.api.common;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class _AccountPosition {

  public String symbol;
  public Double initialMargin;
  public Double maintMargin;
  public Double unrealizedProfit;
  public Double positionInitialMargin;
  public Double openOrderInitialMargin;
  public Double leverage;
  public Boolean isolated;
  public Double entryPrice;
  public Double maxNotional;
  public Double bidNotional;
  public Double askNotional;
  public String positionSide;
  public Double positionAmt;
  public long updateTime;
}
