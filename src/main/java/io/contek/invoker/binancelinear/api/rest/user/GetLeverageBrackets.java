package io.contek.invoker.binancelinear.api.rest.user;

import io.contek.invoker.binancelinear.api.common._Leverage;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.ArrayList;

import static io.contek.invoker.commons.rest.RestMethod.GET;

@NotThreadSafe
public final class GetLeverageBrackets extends UserRestRequest<GetLeverageBrackets.Response> {

  private String symbol;

  GetLeverageBrackets(IActor actor, RestContext context) {
    super(actor, context);
  }

  public GetLeverageBrackets setSymbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  @Override
  protected RestMethod getMethod() {
    return GET;
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @Override
  protected String getEndpointPath() {
    return "/fapi/v1/leverageBracket";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    if (symbol != null)
      builder.add("symbol", symbol);

    builder.add("timestamp", getMillis());

    return builder.build();
  }

  @NotThreadSafe
  public static final class Response extends ArrayList<_Leverage> {}
}
