package io.contek.invoker.binancelinear.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@NotThreadSafe
public class _FutureDetails {

    public String symbol;
    public BigDecimal markPrice;
    public BigDecimal indexPrice;
    public BigDecimal estimatedSettlePrice;
    public BigDecimal lastFundingRate;
    public long nextFundingTime;
    public BigDecimal interestRate;
    public long time;
}
