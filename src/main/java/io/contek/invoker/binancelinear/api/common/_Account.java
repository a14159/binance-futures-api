package io.contek.invoker.binancelinear.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;
import java.util.List;

@NotThreadSafe
public class _Account {

  public int feeTier;
  public boolean canTrade;
  public boolean canDeposit;
  public boolean canWithdraw;
  public long updateTime;
  public BigDecimal totalInitialMargin;
  public BigDecimal totalMaintMargin;
  public BigDecimal totalWalletBalance;
  public BigDecimal totalUnrealizedProfit;
  public BigDecimal totalMarginBalance;
  public BigDecimal totalPositionInitialMargin;
  public BigDecimal totalOpenOrderInitialMargin;
  public BigDecimal totalCrossWalletBalance;
  public BigDecimal totalCrossUnPnl;
  public BigDecimal availableBalance;
  public BigDecimal maxWithdrawAmount;
  public List<_AccountAsset> assets;
  public List<_AccountPosition> positions;
}
