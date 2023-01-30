package io.contek.invoker.binancelinear.api.rest.user;

import com.google.common.collect.ImmutableList;
import io.contek.invoker.binancelinear.api.common._Order;
import io.contek.invoker.binancelinear.api.rest.user.PostOrder.Response;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.actor.ratelimit.TypedPermitRequest;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;

import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkNotNull;
import static io.contek.invoker.binancelinear.api.ApiFactory.RateLimits.*;
import static io.contek.invoker.commons.rest.RestMethod.POST;

@NotThreadSafe
public final class PostOrder extends UserRestRequest<Response> {

  private static final ImmutableList<TypedPermitRequest> REQUIRED_QUOTA =
      ImmutableList.of(
          IP_REST_REQUEST_RULE.forPermits(1),
          API_KEY_REST_ORDER_RULE_ONE_MINUTE.forPermits(1),
          API_KEY_REST_ORDER_RULE_TEN_SECONDS.forPermits(1));

  private String symbol;
  private String side;
  private String positionSide;
  private String type;
  private String timeInForce;
  private BigDecimal quantity;
  private Boolean reduceOnly = false;
  private BigDecimal price;
  private String newClientOrderId;
  private BigDecimal stopPrice;
  private boolean closePosition = false;
  private BigDecimal activationPrice;
  private BigDecimal callbackRate;
  private String workingType;
  private boolean priceProtect;

  PostOrder(IActor actor, RestContext context) {
    super(actor, context);
  }

  public PostOrder setSymbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public PostOrder setSide(String side) {
    this.side = side;
    return this;
  }

  public PostOrder setPositionSide(@Nullable String positionSide) {
    this.positionSide = positionSide;
    return this;
  }

  public PostOrder setType(String type) {
    this.type = type;
    return this;
  }

  public PostOrder setTimeInForce(@Nullable String timeInForce) {
    this.timeInForce = timeInForce;
    return this;
  }

  public PostOrder setQuantity(@Nullable BigDecimal quantity) {
    this.quantity = quantity;
    return this;
  }

  public PostOrder setReduceOnly(@Nullable Boolean reduceOnly) {
    this.reduceOnly = reduceOnly;
    return this;
  }

  public PostOrder setPrice(@Nullable BigDecimal price) {
    this.price = price;
    return this;
  }

  public PostOrder setNewClientOrderId(@Nullable String newClientOrderId) {
    this.newClientOrderId = newClientOrderId;
    return this;
  }

  public PostOrder setStopPrice(@Nullable BigDecimal stopPrice) {
    this.stopPrice = stopPrice;
    return this;
  }

  public PostOrder setClosePosition(@Nullable Boolean closePosition) {
    this.closePosition = closePosition;
    return this;
  }

  public PostOrder setActivationPrice(@Nullable BigDecimal activationPrice) {
    this.activationPrice = activationPrice;
    return this;
  }

  public PostOrder setCallbackRate(@Nullable BigDecimal callbackRate) {
    this.callbackRate = callbackRate;
    return this;
  }

  public PostOrder setWorkingType(@Nullable String workingType) {
    this.workingType = workingType;
    return this;
  }

  public PostOrder setPriceProtect(@Nullable Boolean priceProtect) {
    this.priceProtect = priceProtect;
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
    return "/fapi/v1/order";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    checkNotNull(symbol);
    builder.add("symbol", symbol);

    checkNotNull(side);
    builder.add("side", side);

    checkNotNull(type);
    builder.add("type", type);

    if (quantity != null) {
      builder.add("quantity", quantity.toPlainString());
    }

    if (reduceOnly != null) {
      builder.add("reduceOnly", reduceOnly);
    }

    if (price != null) {
      builder.add("price", price.toPlainString());
    }

    if (positionSide != null) {
      builder.add("positionSide", positionSide);
    }

    if (timeInForce != null) {
      builder.add("timeInForce", timeInForce);
    } else {
      builder.add("timeInForce", "GTC"); // seems to be mandatory
    }

    if (newClientOrderId != null) {
      builder.add("newClientOrderId", newClientOrderId);
    }

    if (stopPrice != null) {
      builder.add("stopPrice", stopPrice.toPlainString());
    }

    if (closePosition) {
      builder.add("closePosition", closePosition);
    }

    if (activationPrice != null) {
      builder.add("activationPrice", activationPrice.toPlainString());
    }

    if (callbackRate != null) {
      builder.add("callbackRate", callbackRate.toPlainString());
    }

    if (workingType != null) {
      builder.add("workingType", workingType);
    }

    if (priceProtect) {
      builder.add("priceProtect", priceProtect);
    }

    builder.add("newOrderRespType", "ACK");

    builder.add("timestamp", getMillis());

    return builder.build();
  }

  @Override
  protected ImmutableList<TypedPermitRequest> getRequiredQuotas() {
    return REQUIRED_QUOTA;
  }

  @NotThreadSafe
  public static final class Response extends _Order {}
}
