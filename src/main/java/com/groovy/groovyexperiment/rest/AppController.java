package com.groovy.groovyexperiment.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/groovy")
public class AppController {

    @GetMapping("/monitor")
    public String monitor(){
        return "{\"message\": \"service is up \"}";
    }
}
