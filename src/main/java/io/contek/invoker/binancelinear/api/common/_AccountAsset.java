package io.contek.invoker.binancelinear.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

@NotThreadSafe
public class _AccountAsset {

  public String asset;
  public BigDecimal walletBalance;
  public BigDecimal unrealizedProfit;
  public BigDecimal marginBalance;
  public BigDecimal maintMargin;
  public BigDecimal initialMargin;
  public BigDecimal positionInitialMargin;
  public BigDecimal openOrderInitialMargin;
  public BigDecimal crossWalletBalance;
  public BigDecimal crossUnPnl;
  public BigDecimal availableBalance;
  public BigDecimal maxWithdrawAmount;
  public boolean marginAvailable;
  public long updateTime;
}
