package io.contek.invoker.binancelinear.api.rest.user;

import io.contek.invoker.binancelinear.api.common._Order;
import io.contek.invoker.binancelinear.api.common.constants.OrderTypeKeys;
import io.contek.invoker.binancelinear.api.rest.user.PostOrder.Response;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;

import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;
import java.util.Objects;

import static io.contek.invoker.commons.rest.RestMethod.POST;

@NotThreadSafe
public final class PostOrder extends UserRestRequest<Response> {

  private String symbol;
  private String side;
  private String positionSide;
  private String type;
  private String timeInForce;
  private BigDecimal quantity;
  private boolean reduceOnly = false;
  private BigDecimal price;
  private String newClientOrderId;
  private BigDecimal stopPrice;
  private boolean closePosition = false;
  private BigDecimal activationPrice;
  private BigDecimal callbackRate;
  private String workingType;
  private boolean priceProtect = false;

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

  public PostOrder setReduceOnly(boolean reduceOnly) {
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

  public PostOrder setClosePosition(boolean closePosition) {
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

  public PostOrder setPriceProtect(boolean priceProtect) {
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

    Objects.requireNonNull(symbol);
    builder.add("symbol", symbol);

    Objects.requireNonNull(side);
    builder.add("side", side);

    Objects.requireNonNull(type);
    builder.add("type", type);

    if (quantity != null) {
      builder.add("quantity", quantity.toPlainString());
    }

    if (reduceOnly) { // default false, cannot be sent in Hedge Mode; cannot be sent with closePosition=true
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
      if (type.equals(OrderTypeKeys._LIMIT))
        builder.add("timeInForce", "GTC"); // seems to be mandatory for LOs
    }

    if (newClientOrderId != null) {
      builder.add("newClientOrderId", newClientOrderId);
    }

    if (stopPrice != null) {
      builder.add("stopPrice", stopPrice.toPlainString());
    }

    if (closePosition) { // default false, used with STOP_MARKET or TAKE_PROFIT_MARKET
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

    if (priceProtect) { // default false, used with STOP/STOP_MARKET or TAKE_PROFIT/TAKE_PROFIT_MARKET orders.
      builder.add("priceProtect", priceProtect);
    }

    builder.add("newOrderRespType", "ACK");

    builder.add("timestamp", getMillis());

    return builder.build();
  }

  @NotThreadSafe
  public static final class Response extends _Order {}
}
