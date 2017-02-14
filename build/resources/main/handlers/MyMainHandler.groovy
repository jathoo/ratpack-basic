package handlers

import ratpack.groovy.handling.GroovyChainAction
import test.TestHomePageHandler
import test.TestJsonHandler

import static ratpack.groovy.Groovy.groovyTemplate

class MyMainHandler  extends GroovyChainAction {


    @Override
    void execute() throws Exception {

        //test  code
        get  "my-test",{
            render "the test"
        }

        get "my-blank-test", {
            render groovyTemplate("hello.html" , name: "myname")
        }

        // all new TestHomePageHandler()
        get "getMyHandler" , new FirstPageHandler()
        get "renderFromHandler" , new RenderFromHandler()
        path "testhandlebar", new TestHomePageHandler()
        path "testjsonhandlebar", new TestJsonHandler()

        prefix("prefixtest"){
            get("first/:id?"){
                def name = pathTokens.id ?: "world of ratpack"
                response.send "Hello $name"
            }
            get("second"){
                def queryName = request.queryParams.queryName
                response.send "Hello $queryName"
            }
        }

        //test code end


        get{
           render "/HomePage"
        }

        get "HomePage" , new  HomePageHandler()

        prefix("user"){
            all  new RegistrationHandler()
            path "registration", new RegistrationHandler()
        }

    }
}
