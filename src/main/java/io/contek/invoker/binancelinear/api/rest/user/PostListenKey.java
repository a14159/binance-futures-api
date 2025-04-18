package io.contek.invoker.binancelinear.api.rest.user;

import io.contek.invoker.binancelinear.api.rest.user.PostListenKey.Response;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;

import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;

import static io.contek.invoker.commons.rest.RestMethod.POST;

@ThreadSafe
public final class PostListenKey extends UserRestRequest<Response> {

  PostListenKey(IActor actor, RestContext context) {
    super(actor, context);
  }

  @Override
  protected RestMethod getMethod() {
    return POST;
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
