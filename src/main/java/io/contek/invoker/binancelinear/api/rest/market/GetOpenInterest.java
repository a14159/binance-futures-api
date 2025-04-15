package io.contek.invoker.binancelinear.api.rest.market;

import io.contek.invoker.binancelinear.api.common._OpenInterest;
import io.contek.invoker.binancelinear.api.rest.market.GetOpenInterest.Response;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.actor.ratelimit.TypedPermitRequest;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestParams;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.List;
import java.util.Objects;

import static io.contek.invoker.binancelinear.api.ApiFactory.RateLimits.ONE_REST_REQUEST;

@NotThreadSafe
public final class GetOpenInterest extends MarketRestRequest<Response> {

  private String symbol;

  GetOpenInterest(IActor actor, RestContext context) {
    super(actor, context);
  }

  public GetOpenInterest setSymbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @Override
  protected String getEndpointPath() {
    return "/fapi/v1/openInterest";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    Objects.requireNonNull(symbol);
    builder.add("symbol", symbol);

    return builder.build();
  }

  @Override
  protected List<TypedPermitRequest> getRequiredQuotas() {
    return ONE_REST_REQUEST;
  }

  @NotThreadSafe
  public static final class Response extends _OpenInterest {}
}
