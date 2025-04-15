package io.contek.invoker.binancelinear.api.rest.market;

import io.contek.invoker.binancelinear.api.common._MarketDetails;
import io.contek.invoker.binancelinear.api.rest.market.GetExchangeInfo.Response;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.actor.ratelimit.TypedPermitRequest;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestParams;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.List;

import static io.contek.invoker.binancelinear.api.ApiFactory.RateLimits.ONE_REST_REQUEST;

@NotThreadSafe
public final class GetExchangeInfo extends MarketRestRequest<Response> {

  GetExchangeInfo(IActor actor, RestContext context) {
    super(actor, context);
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @Override
  protected String getEndpointPath() {
    return "/fapi/v1/exchangeInfo";
  }

  @Override
  protected RestParams getParams() {
    return RestParams.empty();
  }

  @Override
  protected List<TypedPermitRequest> getRequiredQuotas() {
    return ONE_REST_REQUEST;
  }

  @NotThreadSafe
  public static final class Response {

    public List<_MarketAssetDetails> assets;
    public List<_MarketDetails> symbols;
  }

  @NotThreadSafe
  public static final class _MarketAssetDetails {

    public String asset;
    public Boolean marginAvailable;
    public Double autoAssetExchange;
  }
}
