package io.contek.invoker.binancelinear.api.rest.user;

import io.contek.invoker.binancelinear.api.rest.user.PutListenKey.Response;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.Objects;

import static io.contek.invoker.commons.rest.RestMethod.PUT;

@NotThreadSafe
public final class PutListenKey extends UserRestRequest<Response> {

  PutListenKey(IActor actor, RestContext context) {
    super(actor, context);
  }

  /**
   * @deprecated USD-M Futures keepalive applies to the account's active listen key and no longer
   *     accepts a listenKey parameter.
   */
  @Deprecated
  public PutListenKey setListenKey(String listenKey) {
    Objects.requireNonNull(listenKey);
    return this;
  }

  @Override
  protected RestMethod getMethod() {
    return PUT;
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @Override
  protected String getEndpointPath() {
    return "/fapi/v1/listenKey";
  }

  @Override
  protected RestParams getParams() {
    return RestParams.empty();
  }

  @NotThreadSafe
  public static final class Response {

    public String listenKey;
  }
}
