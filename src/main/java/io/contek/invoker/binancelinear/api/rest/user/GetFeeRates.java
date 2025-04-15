package io.contek.invoker.binancelinear.api.rest.user;

import io.contek.invoker.binancelinear.api.common._FeeRates;
import io.contek.invoker.binancelinear.api.rest.user.GetFeeRates.Response;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.actor.ratelimit.TypedPermitRequest;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.List;
import java.util.Objects;

import static io.contek.invoker.binancelinear.api.ApiFactory.RateLimits.IP_REST_REQUEST_RULE;
import static io.contek.invoker.commons.rest.RestMethod.GET;

@NotThreadSafe
public final class GetFeeRates extends UserRestRequest<Response> {

  private static final List<TypedPermitRequest> REQUIRED_QUOTA =
      List.of(IP_REST_REQUEST_RULE.forPermits(20));

  private String symbol;

  GetFeeRates(IActor actor, RestContext context) {
    super(actor, context);
  }

  public GetFeeRates setSymbol(String symbol) {
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
    return "/fapi/v1/commissionRate";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    Objects.requireNonNull(symbol);
    builder.add("symbol", symbol);

    builder.add("timestamp", getMillis());

    return builder.build();
  }

  @Override
  protected List<TypedPermitRequest> getRequiredQuotas() {
    return REQUIRED_QUOTA;
  }

  @NotThreadSafe
  public static final class Response extends _FeeRates {}
}
