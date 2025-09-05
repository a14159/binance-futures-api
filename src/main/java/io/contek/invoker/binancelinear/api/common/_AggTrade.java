package io.contek.invoker.binancelinear.api.common;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class _AggTrade {

    public long a; // aggregated trade id
    public Double p; // price
    public Double q; // qty
    public long f; // first trade id
    public long l; // last trade id
    public long T; // timestamp
    public boolean m; // Was the buyer the maker? (buy market)
}
