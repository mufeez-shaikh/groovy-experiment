package com.groovy.groovyexperiment.rest;

import groovy.lang.GroovyClassLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/groovy")
public class AppController {

    @GetMapping("/monitor")
    public String monitor(){
        return "{\"message\": \"service is up \"}";
    }

    @GetMapping("/getGroovyMessage")
    public String getGroovyMessage(){
        GroovyClassLoader gcl = new GroovyClassLoader();
        try {
            Class gclass = gcl.parseClass(new File("/absolute/filepath/Hello.groovy"));
            Object obj= gclass.newInstance();
            GroovyInterface gInt = (GroovyInterface) obj;
            return gInt.printMessage("hello world");
        } catch (IOException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return "error";
        }
    }
}
