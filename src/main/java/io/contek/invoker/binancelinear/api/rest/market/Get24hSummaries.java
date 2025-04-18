package io.contek.invoker.binancelinear.api.rest.market;

import io.contek.invoker.binancelinear.api.common._MiniTickerSummary;
import io.contek.invoker.binancelinear.api.rest.market.Get24hSummaries.Response;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestParams;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.ArrayList;


@NotThreadSafe
public final class Get24hSummaries extends MarketRestRequest<Response> {

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

  public static final class Response extends ArrayList<_MiniTickerSummary> {}
}
