package io.contek.invoker.binancelinear.api.rest.market;

import io.contek.invoker.binancelinear.api.common._AggTrade;
import io.contek.invoker.binancelinear.api.rest.market.GetAggregatedTrades.Response;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.actor.ratelimit.TypedPermitRequest;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestParams;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static io.contek.invoker.binancelinear.api.ApiFactory.RateLimits.ONE_REST_REQUEST;

@NotThreadSafe
public final class GetAggregatedTrades extends MarketRestRequest<Response> {

  private String symbol;
  private long startTime;
  private long endTime;

  public GetAggregatedTrades setSymbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  /**
   *  	Timestamp in ms to get aggregate trades from INCLUSIVE.
   */
  public GetAggregatedTrades setStartTime(long startTime) {
    this.startTime = startTime;
    return this;
  }

  /**
   * Timestamp in ms to get aggregate trades until INCLUSIVE.
   */
  public GetAggregatedTrades setEndTime(long endTime) {
    this.endTime = endTime;
    return this;
  }

  GetAggregatedTrades(IActor actor, RestContext context) {
    super(actor, context);
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @Override
  protected String getEndpointPath() {
    return "/fapi/v1/aggTrades";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    Objects.requireNonNull(symbol);
    builder.add("symbol", symbol);

    if (startTime != 0)
      builder.add("startTime", startTime);

    if (endTime != 0)
      builder.add("endTime", endTime);

    builder.add("limit", 1000);

    return builder.build();
  }

  @Override
  protected List<TypedPermitRequest> getRequiredQuotas() {
      return ONE_REST_REQUEST;
  }

  public static final class Response extends ArrayList<_AggTrade> {}
}
