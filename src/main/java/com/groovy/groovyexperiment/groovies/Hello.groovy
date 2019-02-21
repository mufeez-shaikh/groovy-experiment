import com.groovy.groovyexperiment.rest.GroovyInterface
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

class Hello  implements GroovyInterface{

    @Override
    String printMessage(String message) {
        def jsonMessager = [:];

        println(jsonMessager.getClass())
        jsonMessager.address= "123 main street, dallas, texas";
        jsonMessager.fname = 'james';
        jsonMessager.lname = 'bond';

        return JsonOutput.toJson(jsonMessager);
    }
}