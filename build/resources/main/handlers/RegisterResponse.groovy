package handlers

import ratpack.handling.Context
import ratpack.handling.Handler

class RegisterResponse implements Handler {


    @Override
    void handle(Context ctx) throws Exception {
        ctx.getResponse().send("foo");

    }
}
