package test.store

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.sql.Sql
import groovy.util.logging.Slf4j
import ratpack.exec.Blocking
import ratpack.exec.Promise

import javax.inject.Inject
import javax.sql.DataSource
@Slf4j
class JsonStore {

    @Inject DataSource dataSource
    @Inject ObjectMapper objectMapper

    public <T> Promise<T> withDataSource(Closure<T> c) {
        assert dataSource, "DataSource appears to be null"
        Sql sql = new Sql(dataSource.getConnection())
        Blocking.get {
            try {
                c.call(sql)
            } catch (Exception e) {
                log.error(e.message)
                throw e
            } finally {
                sql.close()
            }
        }
    }
}
