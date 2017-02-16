package config

import config.db.HikariConfigModule
import config.db.PersistenceModule
import groovy.util.logging.Slf4j
import module.MainModule
import ratpack.func.Action
import ratpack.groovy.template.TextTemplateModule
import ratpack.guice.BindingsSpec
import ratpack.handlebars.HandlebarsModule
import ratpack.hikari.HikariModule
import ratpack.jackson.JacksonModule


@Slf4j
class BindingsConfigurer implements Action<BindingsSpec> {

    void execute(BindingsSpec spec) throws Exception {
        spec
                .module(MainModule)
                .module(TextTemplateModule)
                .module(HandlebarsModule)
                .module(InjectionModule)
                .module(HikariModule)
                .module(HikariConfigModule)
                .module(PersistenceModule)

    }
}
