package junittesting;

import org.junit.jupiter.api.*;

public class MyBeforeAfterTest {
    @BeforeAll // class level so make it as static
    static void beforeAll(){
        System.out.println("Before all");
    }
    @BeforeEach
    void beforeEach(){
        System.out.println("Before Each");
    }
    @Test
    void test1(){
        System.out.println("test 1");
    }
    @Test
    void test2(){
        System.out.println("test 2");
    }
    @Test
    void test3(){
        System.out.println("test 3");
    }
    @AfterEach
    void afterEach(){
        System.out.println("After each");
    }
    @AfterAll
    static  void  afterAll(){ // class level so make it as static
        System.out.println("After All");
    }
}
