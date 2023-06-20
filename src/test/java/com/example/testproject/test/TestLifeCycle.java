package com.example.testproject.test;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestLifeCycle {

    @BeforeAll
    void BeforeAll() {
        System.out.println("## BeforeAll Annotation 호출 ##");
        System.out.println();
    }

    @AfterAll
    void AfterAll() {
        System.out.println("## AftereAll Annotation 호출 ##");
        System.out.println();
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("## BeforeEach Annotation 호출 ##");
        System.out.println();
    }

    @AfterEach
    void afterEach() {
        System.out.println("## AfterEach Annotation 호출 ##");
        System.out.println();
    }

    @Test
    void test1() {
        System.out.println("## test1 시작 ##");
        System.out.println();
    }

    @Test
    @DisplayName("Test Case 2!!!")
    void test2() {
        System.out.println("## test2 시 ##");
        System.out.println();
    }

    @Test
    @Disabled
    void test3() {
        System.out.println("## test3 시 ##");
        System.out.println();
    }
}
