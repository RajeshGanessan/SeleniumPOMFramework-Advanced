package com.framework;

import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Annotations {


    @Test(description = "Checking description using the testNG annotations")
    public void testAnnotation(Method m){
        System.out.println(m.getAnnotation(Test.class).description());
    }
}
