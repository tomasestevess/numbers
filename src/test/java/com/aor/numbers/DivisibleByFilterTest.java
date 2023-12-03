package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DivisibleByFilterTest {
    @Test
    void divisibleBy5()
    {
        DivisibleByFilter dbf = new DivisibleByFilter(5);
        List<Integer> divisible = Arrays.asList(5,10,15,20,25);
        List<Integer> notDivisible = Arrays.asList(1,2,3,4,6);

        for(Integer i : divisible)
            Assertions.assertTrue(dbf.accept(i));
        for(Integer i : notDivisible)
            Assertions.assertFalse(dbf.accept(i));
    }
}


