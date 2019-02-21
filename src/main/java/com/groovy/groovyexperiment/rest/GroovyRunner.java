package com.groovy.groovyexperiment.rest;

import groovy.lang.GroovyClassLoader;

import java.io.File;
import java.io.IOException;

public class GroovyRunner {
    public static void main(String[] args) {
        GroovyClassLoader gcl = new GroovyClassLoader();
        try {
            Class gclass = gcl.parseClass(new File("/absolute-file-path/src/main/java/com/groovy/groovyexperiment/groovies/Hello.groovy"));
            Object obj= gclass.newInstance();
            GroovyInterface gInt = (GroovyInterface) obj;
            gInt.printMessage("hello world");
        } catch (IOException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
