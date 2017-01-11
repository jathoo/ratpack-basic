package module

import com.google.inject.AbstractModule
import com.google.inject.multibindings.Multibinder
import handlers.MyMainHandler
import ratpack.handling.Handler
import ratpack.handling.HandlerDecorator
import ratpack.handling.Handlers
import ratpack.registry.Registry


class MainModule extends AbstractModule {

    protected void configure() {

                Multibinder
                .newSetBinder(binder(), HandlerDecorator)
                .addBinding()
                .toInstance({ Registry registry, Handler rest ->
            Handlers.chain(rest, Handlers.chain(registry, new MyMainHandler()))
        } as HandlerDecorator)
    }
}
