package io.contek.invoker.binancelinear.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.List;
import java.util.Map;

@NotThreadSafe
public class _MarketDetails {

    public String symbol;
    public String pair;
    public String contractType; // "PERPETUAL"
    public long deliveryDate;
    public long onboardDate;
    public String status; // "TRADING"
    public String maintMarginPercent;
    public String requiredMarginPercent;
    public String baseAsset;
    public String quoteAsset;
    public String marginAsset;
    public int pricePrecision;
    public int quantityPrecision;
    public int baseAssetPrecision; // base precision
    public int quotePrecision; // quote precision
    public String underlyingType;
    public List<String> underlyingSubType;
    public int settlePlan;
    public String triggerProtect;

    public List<Map<String, String>> filters;
}
