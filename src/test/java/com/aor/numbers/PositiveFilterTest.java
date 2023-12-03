package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PositiveFilterTest {

    PositiveFilter pf;
    private List<Integer> positives;
    private List<Integer> nonPositives;
    @BeforeEach
    void helper()
    {
        pf = new PositiveFilter();
        positives = Arrays.asList(1,2,3,4,5);
        nonPositives = Arrays.asList(-1,-2,-3,-4,-5);
    }
    @Test
    void positive() {
        for(Integer i : positives)
            Assertions.assertTrue(pf.accept(i));
    }

    @Test
    void notPositive(){
        for(Integer i : nonPositives)
            Assertions.assertFalse(pf.accept(i));
    }
}
