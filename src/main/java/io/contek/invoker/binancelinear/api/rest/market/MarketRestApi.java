package io.contek.invoker.binancelinear.api.rest.market;

import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class MarketRestApi {

  private final IActor actor;
  private final RestContext context;

  public MarketRestApi(IActor actor, RestContext context) {
    this.actor = actor;
    this.context = context;
  }

  public Get24hSummary get24hSummary() {
    return new Get24hSummary(actor, context);
  }

  public GetAggregatedTrades getAggregatedTrades() {
    return new GetAggregatedTrades(actor, context);
  }

  public Get24hSummaries get24hSummaries() {
    return new Get24hSummaries(actor, context);
  }

  public GetDepth getDepth() {
    return new GetDepth(actor, context);
  }

  public GetExchangeInfo getExchangeInfo() {
    return new GetExchangeInfo(actor, context);
  }

  public GetMarkPrice getMarkPrice() {
    return new GetMarkPrice(actor, context);
  }

  public GetGlobalLongShortAccountRatio getGlobalLongShortAccountRatio() {
    return new GetGlobalLongShortAccountRatio(actor, context);
  }

  public GetKlines getKlines() {
    return new GetKlines(actor, context);
  }

  public GetOpenInterest getOpenInterest() {
    return new GetOpenInterest(actor, context);
  }

  public GetTickerBookTicker getTickerBookTicker() {
    return new GetTickerBookTicker(actor, context);
  }

  public GetTopLongShortAccountRatio getTopLongShortAccountRatio() {
    return new GetTopLongShortAccountRatio(actor, context);
  }

  public GetTopLongShortPositionRatio getTopLongShortPositionRatio() {
    return new GetTopLongShortPositionRatio(actor, context);
  }
}
