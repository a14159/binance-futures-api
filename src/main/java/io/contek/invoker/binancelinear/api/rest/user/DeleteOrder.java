package io.contek.invoker.binancelinear.api.rest.user;

import io.contek.invoker.binancelinear.api.common._Order;
import io.contek.invoker.binancelinear.api.rest.user.DeleteOrder.Response;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.actor.ratelimit.TypedPermitRequest;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.List;
import java.util.Objects;

import static io.contek.invoker.binancelinear.api.ApiFactory.RateLimits.ONE_REST_REQUEST;
import static io.contek.invoker.commons.rest.RestMethod.DELETE;

@NotThreadSafe
public final class DeleteOrder extends UserRestRequest<Response> {

  private String symbol;
  private Long orderId;
  private String origClientOrderId;

  DeleteOrder(IActor actor, RestContext context) {
    super(actor, context);
  }

  public DeleteOrder setSymbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public DeleteOrder setOrderId(Long orderId) {
    this.orderId = orderId;
    return this;
  }

  public DeleteOrder setOrigClientOrderId(String origClientOrderId) {
    this.origClientOrderId = origClientOrderId;
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
    return "/fapi/v1/order";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    Objects.requireNonNull(symbol);
    builder.add("symbol", symbol);

    if (orderId == null && origClientOrderId == null) {
      throw new IllegalArgumentException();
    }
    if (orderId != null) {
      builder.add("orderId", orderId);
    }
    if (origClientOrderId != null) {
      builder.add("origClientOrderId", origClientOrderId);
    }

    builder.add("timestamp", getMillis());

    return builder.build();
  }

  @Override
  protected List<TypedPermitRequest> getRequiredQuotas() {
    return ONE_REST_REQUEST;
  }

  @NotThreadSafe
  public static final class Response extends _Order {}
}
