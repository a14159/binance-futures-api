package io.contek.invoker.binancelinear.api.rest.user;

import io.contek.invoker.binancelinear.api.rest.common.RestUpdateResponse;
import io.contek.invoker.binancelinear.api.rest.user.PostMarginType.Response;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.actor.ratelimit.TypedPermitRequest;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.List;
import java.util.Objects;

import static io.contek.invoker.binancelinear.api.ApiFactory.RateLimits.ONE_REST_REQUEST;
import static io.contek.invoker.commons.rest.RestMethod.POST;

@NotThreadSafe
public final class PostMarginType extends UserRestRequest<Response> {

  private String symbol;
  private String marginType;

  PostMarginType(IActor actor, RestContext context) {
    super(actor, context);
  }

  public PostMarginType setSymbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public PostMarginType setMarginType(String marginType) {
    this.marginType = marginType;
    return this;
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @Override
  protected RestMethod getMethod() {
    return POST;
  }

  @Override
  protected String getEndpointPath() {
    return "/fapi/v1/marginType";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    Objects.requireNonNull(symbol);
    builder.add("symbol", symbol);

    Objects.requireNonNull(marginType);
    builder.add("marginType", marginType);

    builder.add("timestamp", getMillis());

    return builder.build();
  }

  @Override
  protected List<TypedPermitRequest> getRequiredQuotas() {
    return ONE_REST_REQUEST;
  }

  @NotThreadSafe
  public static final class Response extends RestUpdateResponse {}
}
