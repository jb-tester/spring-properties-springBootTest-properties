package com.mytests.spring.springpropertiesspringboottestproperties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = { "sbtest.prop1=overriden_prop1", "sbtest.prop3=annotation_only.prop3" })
public class SpringBootTestPropertiesIntegrationTest {

    // property is set in application.properties and overridden in @SpringBootTest#properties
    @Value("${sbtest.prop1}") String prop1;
    // property is set in application.properties only
    @Value("${sbtest.prop2}") String prop2;
    // property is defined in @SpringBootTest#properties only
    @Value("${sbtest.prop3}") String prop3;


    @Test
    public void shouldSpringBootTestAnnotation_overridePropertyValues() {


        assertEquals("overriden_prop1", prop1);
        assertEquals("default_prop2", prop2);
        assertEquals("annotation_only.prop3", prop3);
    }
}