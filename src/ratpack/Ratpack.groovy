import config.BindingsConfigurer
import handlers.MyMainHandler

import static ratpack.groovy.Groovy.ratpack

ratpack {


     bindings new BindingsConfigurer().&execute

        handlers {
    insert new MyMainHandler()
            /*get{
                render "Hello, World!"
            }
            path("foo"){
                byMethod{
                    get{
                        render "Hello,foo get"
                    }
                    post{
                        render "hello ,foo post"
                    }
                }
            }*/

    }
}
