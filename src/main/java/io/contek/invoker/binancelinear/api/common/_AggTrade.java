package io.contek.invoker.binancelinear.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

@NotThreadSafe
public class _AggTrade {

    public long a; // aggregated trade id
    public BigDecimal p; // price
    public BigDecimal q; // qty
    public long f; // first trade id
    public long l; // last trade id
    public long T; // timestamp
    public boolean m; // Was the buyer the maker? (buy market)
}
