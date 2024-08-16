package io.contek.invoker.binancelinear.api.websocket.user;

import io.contek.invoker.binancelinear.api.websocket.common.WebSocketEventData;
import io.contek.invoker.binancelinear.api.websocket.user.constants.UserEventTypeKeys;

import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;
import java.math.BigDecimal;

@ThreadSafe
public final class OrderUpdateChannel extends UserWebSocketChannel<OrderUpdateChannel.Data> {

  OrderUpdateChannel() {
    super(Id.INSTANCE);
  }

  @Override
  public Class<Data> getMessageType() {
    return Data.class;
  }

  @Immutable
  public static final class Id extends UserWebSocketChannelId<Data> {

    private static final Id INSTANCE = new Id();

    private Id() {
      super(UserEventTypeKeys._ORDER_TRADE_UPDATE);
    }
  }

  @NotThreadSafe
  public static final class Data extends WebSocketEventData {

    public long T; // transaction time
    public Order o;
  }

  @NotThreadSafe
  public static final class Order {

    public String s; // symbol
    public String c; // client order id
    public String S; // side
    public String o; // order type
    public String f; // time in force
    public BigDecimal q; // original quantity;
    public BigDecimal p; // original price
    public BigDecimal ap; // average price
    public BigDecimal sp; // stop price
    public String x; // execution type
    public String X; // order status
    public String i; // order id
    public BigDecimal l; // order last filled quantity
    public BigDecimal z; // order filled accumulated quantity
    public BigDecimal L; // Last Filled Price
    public String N; // commission asset
    public BigDecimal n; // commission
    public Long T; // order trade time
    public String t; // trade id
    public BigDecimal b; // bids notional
    public BigDecimal a; // ask notional
    public Boolean m; // is the trade the maker side
    public Boolean R; // is this trade reduce only
    public String wt; // stop work price type
    public String ot; // original order type
    public String ps; // position side
    public Boolean cp; // if close all push with conditional order
    public BigDecimal AP; // activation price
    public BigDecimal cr; // callback rate
    public BigDecimal rp; // realized profit
    public long traceNano = System.nanoTime();
  }
}
