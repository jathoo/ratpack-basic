package config

import com.google.inject.AbstractModule
import groovy.json.JsonSlurper
import test.service.TestHomeService

class InjectionModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(TestHomeService)
        bind(JsonSlurper)
    }
}
