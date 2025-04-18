package io.contek.invoker.binancelinear.api.rest.market;

import io.contek.invoker.binancelinear.api.common._LongShortRatio;
import io.contek.invoker.binancelinear.api.rest.market.GetGlobalLongShortAccountRatio.Response;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestParams;

import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import java.util.ArrayList;
import java.util.Objects;

@NotThreadSafe
public final class GetGlobalLongShortAccountRatio extends MarketRestRequest<Response> {

  private String symbol;
  private String period;
  private Long startTime;
  private Long endTime;
  private Integer limit;

  GetGlobalLongShortAccountRatio(IActor actor, RestContext context) {
    super(actor, context);
  }

  public GetGlobalLongShortAccountRatio setSymbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public GetGlobalLongShortAccountRatio setPeriod(String period) {
    this.period = period;
    return this;
  }

  public GetGlobalLongShortAccountRatio setStartTime(@Nullable Long startTime) {
    this.startTime = startTime;
    return this;
  }

  public GetGlobalLongShortAccountRatio setEndTime(@Nullable Long endTime) {
    this.endTime = endTime;
    return this;
  }

  public GetGlobalLongShortAccountRatio setLimit(@Nullable Integer limit) {
    this.limit = limit;
    return this;
  }

  @Override
  protected String getEndpointPath() {
    return "/futures/data/globalLongShortAccountRatio";
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    Objects.requireNonNull(symbol);
    builder.add("symbol", symbol);
    Objects.requireNonNull(period);
    builder.add("period", period);
    if (startTime != null) {
      builder.add("startTime", startTime);
    }
    if (endTime != null) {
      builder.add("endTime", endTime);
    }
    if (limit != null) {
      builder.add("limit", limit);
    }

    return builder.build();
  }

  @NotThreadSafe
  public static final class Response extends ArrayList<_LongShortRatio> {}
}
