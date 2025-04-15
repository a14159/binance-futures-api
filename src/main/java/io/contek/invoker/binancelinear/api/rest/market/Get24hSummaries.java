package io.contek.invoker.binancelinear.api.rest.market;

import io.contek.invoker.binancelinear.api.common._MiniTickerSummary;
import io.contek.invoker.binancelinear.api.rest.market.Get24hSummaries.Response;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.actor.ratelimit.TypedPermitRequest;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestParams;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.ArrayList;
import java.util.List;

import static io.contek.invoker.binancelinear.api.ApiFactory.RateLimits.IP_REST_REQUEST_RULE;

@NotThreadSafe
public final class Get24hSummaries extends MarketRestRequest<Response> {

  private static final List<TypedPermitRequest> REQUIRED_QUOTA =
      List.of(IP_REST_REQUEST_RULE.forPermits(40));


  Get24hSummaries(IActor actor, RestContext context) {
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

    return builder.build();
  }

  @Override
  protected List<TypedPermitRequest> getRequiredQuotas() {
      return REQUIRED_QUOTA;
  }

  public static final class Response extends ArrayList<_MiniTickerSummary> {}
}
