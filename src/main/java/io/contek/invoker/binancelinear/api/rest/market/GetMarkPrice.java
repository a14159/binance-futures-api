package io.contek.invoker.binancelinear.api.rest.market;

import io.contek.invoker.binancelinear.api.common._FutureDetails;
import io.contek.invoker.binancelinear.api.rest.market.GetMarkPrice.Response;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestParams;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.Objects;


@NotThreadSafe
public final class GetMarkPrice extends MarketRestRequest<Response> {

  private String symbol;

  GetMarkPrice(IActor actor, RestContext context) {
    super(actor, context);
  }

  public GetMarkPrice setSymbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @Override
  protected String getEndpointPath() {
    return "/fapi/v1/premiumIndex";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    Objects.requireNonNull(symbol);
    builder.add("symbol", symbol);

    return builder.build();
  }

  @NotThreadSafe
  public static final class Response extends _FutureDetails {}
}
