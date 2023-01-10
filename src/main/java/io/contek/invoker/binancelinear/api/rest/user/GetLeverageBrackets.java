package io.contek.invoker.binancelinear.api.rest.user;

import com.google.common.collect.ImmutableList;
import io.contek.invoker.binancelinear.api.common._LeverageBracket;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.actor.ratelimit.TypedPermitRequest;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;

import javax.annotation.concurrent.NotThreadSafe;

import java.util.List;

import static io.contek.invoker.binancelinear.api.ApiFactory.RateLimits.IP_REST_REQUEST_RULE;
import static io.contek.invoker.commons.rest.RestMethod.GET;

@NotThreadSafe
public final class GetLeverageBrackets extends UserRestRequest<GetLeverageBrackets.Response> {

  private static final ImmutableList<TypedPermitRequest> REQUIRED_QUOTA =
      ImmutableList.of(IP_REST_REQUEST_RULE.forPermits(1));

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

  @Override
  protected ImmutableList<TypedPermitRequest> getRequiredQuotas() {
    return REQUIRED_QUOTA;
  }

  @NotThreadSafe
  public static final class Response {
    public String symbol;
    public List<_LeverageBracket> brackets;
  }
}
