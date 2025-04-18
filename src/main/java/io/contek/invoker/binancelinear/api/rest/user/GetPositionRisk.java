package io.contek.invoker.binancelinear.api.rest.user;

import io.contek.invoker.binancelinear.api.common._PositionRisk;
import io.contek.invoker.binancelinear.api.rest.user.GetPositionRisk.Response;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.ArrayList;

import static io.contek.invoker.commons.rest.RestMethod.GET;

@NotThreadSafe
public final class GetPositionRisk extends UserRestRequest<Response> {

  private String symbol;

  GetPositionRisk(IActor actor, RestContext context) {
    super(actor, context);
  }

  public GetPositionRisk setSymbol(String symbol) {
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
    return "/fapi/v2/positionRisk";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    if (symbol != null) {
      builder.add("symbol", symbol);
    }

    builder.add("timestamp", getMillis());

    return builder.build();
  }

  @NotThreadSafe
  public static final class Response extends ArrayList<_PositionRisk> {}
}
