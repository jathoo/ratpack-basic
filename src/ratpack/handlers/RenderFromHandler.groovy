package handlers

import ratpack.handling.Context
import ratpack.handling.Handler

import static ratpack.groovy.Groovy.groovyTemplate

class RenderFromHandler implements Handler{


    @Override
    void handle(Context ctx) throws Exception {
        ctx.render(groovyTemplate("helloFromHandler.html" , name: "ModelData"))
   }
}
