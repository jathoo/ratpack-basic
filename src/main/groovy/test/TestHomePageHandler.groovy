package test

import test.service.TestHomeService
import ratpack.form.Form
import ratpack.handling.Context
import ratpack.handling.InjectionHandler
import test.store.TestStoreImpl

import static ratpack.handlebars.Template.handlebarsTemplate

class TestHomePageHandler extends InjectionHandler {


    void handle(Context ctx, TestHomeService testHomeService) throws Exception {

        ctx.byMethod {
            it.get {
                ctx.render handlebarsTemplate('test/Home-test.html', name: "Yathu")

            }
            it.post {
                ctx.parse(Form).then { Form testForm ->
                    String email = testForm.get("email")

                    /*
                          String email = ""
                          String newEmail = ""
                          newEmail =  testHomeService.alterEmail(email)
                          println newEmail
                          ctx.render handlebarsTemplate('test/Home-test.html', name:newEmail)*/

                    testHomeService.callSave(email).onError {
                        ctx.render handlebarsTemplate('test/Home-test.html', name: "something went wrong")
                    }.then {
                        ctx.render handlebarsTemplate('test/Home-test.html', name: "its on db")
                    }
                }
            }
        }
    }
}

