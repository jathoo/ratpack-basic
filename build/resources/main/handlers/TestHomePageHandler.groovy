package handlers

import Services.TestHomeService
import ratpack.form.Form
import ratpack.handling.Context
import ratpack.handling.InjectionHandler

import static ratpack.handlebars.Template.handlebarsTemplate

class TestHomePageHandler extends InjectionHandler {


    void handle(Context ctx, TestHomeService testHomeService) throws Exception {

        ctx.byMethod {
            it.get {
                ctx.render handlebarsTemplate('Home-test.html', name: "Yathu")

            }
            it.post {

                String email = ""
                String newEmail = ""
                ctx.parse(Form).then { Form testForm ->
                    email = testForm.get("email")
                    newEmail =  testHomeService.alterEmail(email)
                    println newEmail
                    ctx.render handlebarsTemplate('Home-test.html', name:newEmail)
                }
            }

        }
    }
}

