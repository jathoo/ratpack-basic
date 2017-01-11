package handlers

import ratpack.exec.Promise
import ratpack.form.Form
import ratpack.handling.Context
import ratpack.handling.Handler

import static ratpack.handlebars.Template.handlebarsTemplate


class TestHomePageHandler implements Handler{


    @Override
    void handle(Context ctx) throws Exception {

        ctx.byMethod{
            it.get{
                ctx.render handlebarsTemplate('Home-test.html', name: "Yathu")

            }
            it.post{

                String email = ""
                ctx.parse(Form).then { Form receiptForm ->
                    email = receiptForm.get("email")
                    //ctx.render "posted value    " + email
                    ctx.render handlebarsTemplate('Home-test.html', name: email)
                }

            }

            }
        }
    }

