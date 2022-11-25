package io.contek.invoker.binancelinear.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

@NotThreadSafe
public class _MiniTickerSummary {

    public String symbol;
    public BigDecimal priceChange;
    public BigDecimal priceChangePercent;
    public BigDecimal weightedAvgPrice;
    public BigDecimal lastPrice;
    public BigDecimal lastQty;
    public BigDecimal openPrice;
    public BigDecimal highPrice;
    public BigDecimal lowPrice;
    public BigDecimal volume;
    public BigDecimal quoteVolume;
    public long openTime;
    public long closeTime;
    public long firstId;
    public long lastId;
    public long count;
}
