package io.github.joykrishan.array_module;

import org.junit.Test;
import org.junit.Assert;

public class ArrayTest {

    @Test
    public void insertMethodShouldInsertANumber() {
        Array arr = new Array(1);
        int num = 5;
        int[] expected = {num};
        arr.insert(5);
        Assert.assertArrayEquals(expected, arr.getItems());
    }

    @Test
    public void insertMethodShouldGrowArrayAndInsert(){
        Array arr = new Array(0);
        int num1 = 5;
        int num2 = 4;
        int[] expected = {5, 4, 4, 4};
        arr.insert(num1);
        arr.insert(num2);
        arr.insert(num2);
        arr.insert(num2);
        Assert.assertArrayEquals(expected, arr.getItems());
    }

    @Test
    public void indexOfMethodShouldReturnAnIndexIfItemFound(){
        Array arr = new Array(3);
        arr.insert(2);
        arr.insert(3);
        arr.insert(10);
        int expectedIdx = 2;
        Assert.assertEquals(expectedIdx, arr.indexOf(10));
    }


}