import config.BindingsConfigurer
import handlers.MyMainHandler

import static ratpack.groovy.Groovy.ratpack

ratpack {


     bindings new BindingsConfigurer().&execute

        handlers {
    insert new MyMainHandler()
    }
}
