package handlers

import ratpack.handling.Context
import ratpack.handling.Handler

import static ratpack.handlebars.Template.handlebarsTemplate

class RegistrationHandler implements Handler {

    @Override
    void handle(Context ctx) throws Exception {



        ctx.byMethod{
            it.get{
                ctx.render handlebarsTemplate('registrationpage.html')
            }
            it.post{
                ctx.render "post is working" + ctx.allPathTokens.eventId

            }
        }

    }
}
