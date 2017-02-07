package test.service

import Business.Business
import User.User
import com.google.inject.Singleton
import groovy.util.logging.Slf4j
import test.store.ITestStore

import javax.inject.Inject

@Singleton
@Slf4j
class  TestHomeService {

    //Constructor Inject of dependencies
/*    //Store interface

    UserAccountStore userAccountStore

    @Inject
    public TestHomeService(UserAccountStore blah) {

    }*/
    private ITestStore iTestStore
    private Business business
    private User user

    @Inject
    TestHomeService(ITestStore iTestStore,Business business,User user){
        this.iTestStore = iTestStore
        this.business = business
        this.user = user
    }

    String alterEmail(String email){

      //  println( email + "changed")

        user.userId = "user1"
        user.userName = email

        println("user id    " + user.userName)

        business.businessId = "1"
        business.businessUser = user
        println("business user id    " + business.businessUser.userName)

        log.info(iTestStore.save(business).operation().toString())
        email + "changed"


    }

    //hikari module set up
    //set up db access in project

    //create db script

    //create store interface
    //create store implementation using jsonb





}
