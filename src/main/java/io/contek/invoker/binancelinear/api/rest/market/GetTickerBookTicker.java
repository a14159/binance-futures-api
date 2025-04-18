package io.contek.invoker.binancelinear.api.rest.market;

import io.contek.invoker.binancelinear.api.common._BookTicker;
import io.contek.invoker.binancelinear.api.rest.market.GetTickerBookTicker.Response;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestParams;

import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;


@NotThreadSafe
public final class GetTickerBookTicker extends MarketRestRequest<Response> {

  private String symbol;

  GetTickerBookTicker(IActor actor, RestContext context) {
    super(actor, context);
  }

  public GetTickerBookTicker setSymbol(@Nullable String symbol) {
    this.symbol = symbol;
    return this;
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @Override
  protected String getEndpointPath() {
    return "/fapi/v1/ticker/bookTicker";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    if (symbol != null) {
      builder.add("symbol", symbol);
    }

    return builder.build();
  }

  @NotThreadSafe
  public static final class Response extends _BookTicker {}
}
