package test

import com.fasterxml.jackson.databind.ObjectMapper
import groovy.sql.Sql
import groovy.util.logging.Slf4j
import ratpack.exec.Blocking
import ratpack.exec.Promise

import javax.inject.Inject
import javax.sql.DataSource

@Slf4j
class JsonObjectMapper<T> {

    @Inject
    ObjectMapper objectMapper

    String mapObjectToJson(T object) {
        log.info("trying to cast")
        String jsonObject = objectMapper.writeValueAsString(object)
        log.info("${jsonObject} mapped to JSON")
        return jsonObject
    }

    T mapJsonToObject(String jsonString) {
        T t = objectMapper.readValue(jsonString, T.class)
        log.info("${t.toString()} mapped to object")
        return t
    }
}
