package io.contek.invoker.binancelinear.api.rest.user;

import io.contek.invoker.binancelinear.api.rest.RestRequest;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.rest.RestContext;

import javax.annotation.concurrent.NotThreadSafe;
import java.time.Clock;


@NotThreadSafe
abstract class UserRestRequest<T> extends RestRequest<T> {

  private final Clock clock;

  UserRestRequest(IActor actor, RestContext context) {
    super(actor, context);
    clock = actor.getClock();
    if (actor.getCredential().isAnonymous()) {
      throw new IllegalArgumentException();
    }
  }

  long getMillis() {
    return clock.millis();
  }
}
