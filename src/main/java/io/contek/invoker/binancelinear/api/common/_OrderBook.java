package io.contek.invoker.binancelinear.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.List;

@NotThreadSafe
public class _OrderBook {

    public Long lastUpdateId;
    public Long E;
    public Long T;

    public List<_OrderBookLevel> bids;
    public List<_OrderBookLevel> asks;
}
