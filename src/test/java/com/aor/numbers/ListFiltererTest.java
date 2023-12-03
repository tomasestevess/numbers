package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class ListFiltererTest {

    @Test
    void filter()
    {
        GenericListFilter filter = Mockito.mock(GenericListFilter.class);
        Mockito.when(filter.accept(1)).thenReturn(true);
        Mockito.when(filter.accept(2)).thenReturn(false);
        Mockito.when(filter.accept(3)).thenReturn(false);
        Mockito.when(filter.accept(4)).thenReturn(false);
        Mockito.when(filter.accept(5)).thenReturn(false);
        Mockito.when(filter.accept(6)).thenReturn(false);
        Mockito.when(filter.accept(7)).thenReturn(true);

        ListFilterer lf = new ListFilterer(filter);
        Assertions.assertEquals(Arrays.asList(1,7), lf.filter(Arrays.asList(1,2,3,4,5,6,7)));
    }
}
