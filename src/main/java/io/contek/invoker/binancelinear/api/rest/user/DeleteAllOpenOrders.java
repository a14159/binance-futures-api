package io.contek.invoker.binancelinear.api.rest.user;

import io.contek.invoker.binancelinear.api.rest.common.RestUpdateResponse;
import io.contek.invoker.binancelinear.api.rest.user.DeleteAllOpenOrders.Response;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.Objects;

import static io.contek.invoker.commons.rest.RestMethod.DELETE;

@NotThreadSafe
public final class DeleteAllOpenOrders extends UserRestRequest<Response> {

  private String symbol;

  DeleteAllOpenOrders(IActor actor, RestContext context) {
    super(actor, context);
  }

  public DeleteAllOpenOrders setSymbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @Override
  protected RestMethod getMethod() {
    return DELETE;
  }

  @Override
  protected String getEndpointPath() {
    return "/fapi/v1/allOpenOrders";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    Objects.requireNonNull(symbol);
    builder.add("symbol", symbol);

    builder.add("timestamp", getMillis());

    return builder.build();
  }

  @NotThreadSafe
  public static final class Response extends RestUpdateResponse {}
}
