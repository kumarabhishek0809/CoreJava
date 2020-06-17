package core.enbd;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class MyTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void addition() {
        List<String> str = new ArrayList<>();
        str.add("Kumar");
        str.add("Raja");
        int kumar = Collections.binarySearch(str, "Tim");
        System.out.println(kumar);
        assertEquals(2, calculator.add(1, 1));
    }

    @RepeatedTest(10)
    public void additionRepeated(){
        assertTimeout(Duration.ofMillis(100) , () -> assertEquals(200000000, calculator.add(100000000, 100000000)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc","defc", "xyz"})
    void parametrizedTestCase(String arg){
        assertTrue(arg.length() == 3);
    }

    @ParameterizedTest
    @MethodSource("intRange")
    void parametrizedTestCaseMethod(int arg){
        assertTrue(arg > 10);
    }

    static IntStream intRange(){
        return IntStream.range(10,40);
    }


}
