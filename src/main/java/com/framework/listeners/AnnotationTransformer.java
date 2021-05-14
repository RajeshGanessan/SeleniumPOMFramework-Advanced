package com.framework.listeners;

import com.framework.utils.DataProviderUtils;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {


    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
            annotation.setRetryAnalyzer(RetryFailedTests.class);
            annotation.setDataProvider("getData");
            annotation.setDataProviderClass(DataProviderUtils.class);
    }
}
