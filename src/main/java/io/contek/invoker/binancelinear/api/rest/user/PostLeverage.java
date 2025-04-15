package io.contek.invoker.binancelinear.api.rest.user;

import io.contek.invoker.binancelinear.api.common._InitialLeverageInfo;
import io.contek.invoker.binancelinear.api.rest.user.PostLeverage.Response;
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
public final class PostLeverage extends UserRestRequest<Response> {

  private String symbol;
  private Integer leverage;

  PostLeverage(IActor actor, RestContext context) {
    super(actor, context);
  }

  public PostLeverage setSymbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public PostLeverage setLeverage(Integer leverage) {
    this.leverage = leverage;
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
    return "/fapi/v1/leverage";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    Objects.requireNonNull(symbol);
    builder.add("symbol", symbol);

    Objects.requireNonNull(leverage);
    builder.add("leverage", leverage);

    builder.add("timestamp", getMillis());

    return builder.build();
  }

  @Override
  protected List<TypedPermitRequest> getRequiredQuotas() {
    return ONE_REST_REQUEST;
  }

  @NotThreadSafe
  public static final class Response extends _InitialLeverageInfo {}
}
