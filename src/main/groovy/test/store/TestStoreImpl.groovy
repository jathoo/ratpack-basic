package test.store

import Business.Business
import groovy.sql.Sql
import ratpack.exec.Promise
import test.JsonObjectMapper

import javax.inject.Inject


class TestStoreImpl extends JsonStore implements ITestStore<Business> {


    @Inject
    JsonObjectMapper jsonObjectMapper

    @Override
    Promise<String> save(Business business) {
            withDataSource { Sql sql ->
                sql.execute("INSERT INTO test_table (data) VALUES (cast (? AS JSONB))", jsonObjectMapper.mapObjectToJson(business))
             }.map{
                    "updated"
            }
    }
}
