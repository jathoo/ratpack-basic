package config.db

import com.google.inject.AbstractModule
import com.google.inject.Provides
import com.google.inject.Singleton
import com.zaxxer.hikari.HikariConfig

class HikariConfigModule extends AbstractModule {

    static final int MAX_POOL_SIZE = 8

    protected void configure() {

    }

    @Provides
    @Singleton
    HikariConfig provideHikariConfig(DatabaseConfig config) {
        HikariConfig hc = new HikariConfig(jdbcUrl: config.jdbcUrl, username: config.dbUser, password: config.dbPassword,
                maximumPoolSize: MAX_POOL_SIZE, connectionTestQuery: "SELECT * FROM test_table")
         return hc
    }

}
