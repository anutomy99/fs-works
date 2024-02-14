package junittesting;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyAssertTest {
    List<String> todos = Arrays.asList("AWS","Azure","DevOps");
    @Test
    void run(){

        boolean test = todos.contains("AWS");
        boolean test1 = todos.contains("Azure");
//        assertEquals(true,test);
        assertTrue(test);
        assertTrue(test1);
        assertArrayEquals(new  int[]{1,2},new int[]{2,2});
        assertEquals(3,todos.size());
    }
}
