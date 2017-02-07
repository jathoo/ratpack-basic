package config.db

import com.google.inject.AbstractModule
import com.google.inject.Singleton
import test.store.ITestStore
import test.store.TestStoreImpl

class PersistenceModule extends AbstractModule {

     @Override
    protected void configure() {
         bind(ITestStore).to(TestStoreImpl).in(Singleton)

    }
}
