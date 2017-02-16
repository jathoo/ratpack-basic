package test

import User.User
import groovy.util.logging.Slf4j
import ratpack.handling.Context
import ratpack.handling.InjectionHandler
import ratpack.jackson.Jackson
import test.service.TestHomeService

@Slf4j
class TestJsonHandler extends InjectionHandler {
    void handle(Context ctx, TestHomeService testHomeService) throws Exception {

        ctx.byContent {
            it.json {
                ctx.parse(Jackson.fromJson(User)).then { data ->
                    def alterUserName = testHomeService.alterEmail(data.userName)
                    log.info("[userid is : $data.userId] [user name is : $alterUserName])] ")
                }
            }

        }
    }
}
