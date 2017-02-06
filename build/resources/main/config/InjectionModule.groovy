package config

import test.TestHomeService
import com.google.inject.AbstractModule

class InjectionModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(TestHomeService)
    }
}
