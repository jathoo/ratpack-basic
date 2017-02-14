package test

import ratpack.handling.Context
import ratpack.handling.InjectionHandler
import test.service.TestHomeService

import static ratpack.handlebars.Template.handlebarsTemplate

class TestJsonHandler  extends InjectionHandler{
    void handle(Context ctx, TestHomeService testHomeService) throws Exception {
        ctx.byContent{
            it.json{
                ctx.render handlebarsTemplate('test/Home-test.html', name: testHomeService.alterEmail("getting json response"))
            }.xml{
                ctx.render handlebarsTemplate('test/Home-test.html', name: testHomeService.alterEmail("getting xml response"))
            }
        }

    }
}
