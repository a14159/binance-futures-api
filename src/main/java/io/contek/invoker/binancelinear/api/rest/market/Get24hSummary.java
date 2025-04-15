package io.contek.invoker.binancelinear.api.rest.market;

import io.contek.invoker.binancelinear.api.common._MiniTickerSummary;
import io.contek.invoker.binancelinear.api.rest.market.Get24hSummary.Response;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.actor.ratelimit.TypedPermitRequest;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestParams;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.List;
import java.util.Objects;

import static io.contek.invoker.binancelinear.api.ApiFactory.RateLimits.ONE_REST_REQUEST;

@NotThreadSafe
public final class Get24hSummary extends MarketRestRequest<Response> {

  private String symbol;

  public Get24hSummary setSymbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  Get24hSummary(IActor actor, RestContext context) {
    super(actor, context);
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @Override
  protected String getEndpointPath() {
    return "/fapi/v1/ticker/24hr";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    Objects.requireNonNull(symbol);
    builder.add("Symbol", symbol);

    return builder.build();
  }

  @Override
  protected List<TypedPermitRequest> getRequiredQuotas() {
      return ONE_REST_REQUEST;
  }

  public static final class Response extends _MiniTickerSummary {}
}
