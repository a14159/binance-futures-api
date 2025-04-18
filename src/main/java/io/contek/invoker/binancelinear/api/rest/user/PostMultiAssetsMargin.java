package io.contek.invoker.binancelinear.api.rest.user;

import io.contek.invoker.binancelinear.api.rest.common.RestUpdateResponse;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;

import javax.annotation.concurrent.NotThreadSafe;

import static io.contek.invoker.commons.rest.RestMethod.POST;

@NotThreadSafe
public final class PostMultiAssetsMargin extends UserRestRequest<PostMultiAssetsMargin.Response> {

  private Boolean multiAssetsMargin;

  PostMultiAssetsMargin(IActor actor, RestContext context) {
    super(actor, context);
  }

  public PostMultiAssetsMargin setMultiAssetsMargin(Boolean multiAssetsMargin) {
    this.multiAssetsMargin = multiAssetsMargin;
    return this;
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
    return "/fapi/v1/multiAssetsMargin";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();
    builder.add("multiAssetsMargin", Boolean.toString(multiAssetsMargin));
    builder.add("timestamp", getMillis());

    return builder.build();
  }

  @NotThreadSafe
  public static final class Response extends RestUpdateResponse {}
}
