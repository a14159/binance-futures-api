package io.contek.invoker.binancelinear.api.common;

import javax.annotation.concurrent.NotThreadSafe;
import java.math.BigDecimal;

@NotThreadSafe
public class _Order {

  public String symbol;
  public long orderId;
  public String clientOrderId;
  public BigDecimal price;
  public BigDecimal avgPrice;
  public BigDecimal origQty;
  public BigDecimal executedQty;
  public String status;
  public String timeInForce;
  public String type;
  public boolean reduceOnly;
  public String side;
  public String positionSide;
  public BigDecimal stopPrice;
  public long updateTime;
  public String workingType;
}
