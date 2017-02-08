package test.store

import ratpack.exec.Promise

interface ITestStore<T> {
    //Promise<List<?>> fetchAll()
    Promise<String> save(T t)
    //Promise<?> fetch(String id)
    //Operation delete(String id)
}
