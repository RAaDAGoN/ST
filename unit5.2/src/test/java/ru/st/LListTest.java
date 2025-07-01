package ru.st;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LListTest {

    @Test(description = "Тестирование List<String>")
    public void testString() {
        myList<String> list1 = new LList<>();

        list1.add("d1");
        list1.add("d2");
        list1.add("d3");

        Assert.assertEquals(list1.get(0), "d1");
        Assert.assertEquals(list1.get(1), "d2");
        Assert.assertEquals(list1.get(2), "d3");
    }

    @Test(description = "Тестирование list<Integer>")
    public void testInteger(){
        myList<Integer> list = new LList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        Assert.assertEquals(list.get(0), 1);
        Assert.assertEquals(list.get(1), 2);
        Assert.assertEquals(list.get(2), 3);
    }
}