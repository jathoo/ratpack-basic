package handlers

import ratpack.handling.Context
import ratpack.handling.Handler

class FirstPageHandler implements Handler{


    @Override
    void handle(Context ctx) throws Exception {
        ctx.getResponse().send("send to normal(not an injection Handler)")


    }
}
