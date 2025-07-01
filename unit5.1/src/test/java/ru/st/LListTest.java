package ru.st;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class LListTest {
    private final int INT_OBJECT = 10;
    private final double DOUBLE_OBJECT = 5.5;
    private final String STRING_OBJECT = "Hello world";

    @Test
    public void testAdd() {
        LList list = new LList();
        list.add(INT_OBJECT);
        list.add(DOUBLE_OBJECT);
        list.add(STRING_OBJECT);

        Assert.assertEquals(list.get(0), 10);
        Assert.assertEquals(list.get(1), 5.5);
        Assert.assertEquals(list.getLast(), "Hello world");
    }
}