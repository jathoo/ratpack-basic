package config

import module.MainModule
import ratpack.func.Action
import ratpack.groovy.template.TextTemplateModule
import ratpack.guice.BindingsSpec
import ratpack.handlebars.HandlebarsModule

class BindingsConfigurer implements Action<BindingsSpec> {

    void execute(BindingsSpec spec) throws Exception {
        spec
                .module(MainModule)
                .module(TextTemplateModule)
                .module(HandlebarsModule)
                .module(InjectionModule)
    }
}
