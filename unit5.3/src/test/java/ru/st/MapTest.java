package ru.st;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;


public class MapTest {

    @Test
    public void testSwap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1(один)");
        map.put(2, "2(два)");
        map.put(3, "3(три)");

        Map<String, Integer> swaped = ru.st.Map.swap(map);

        /*
        Ключи и значения поменялись местами:
            '1 -> 1(один)' -> '1(один) -> 1'
            '2 -> 2(два)' -> '2(два) -> 2'
            '3 -> 3(три)' -> '3(три) -> 3'
         */
        Assert.assertEquals(swaped.get("1(один)"), 1);
        Assert.assertEquals(swaped.get("2(два)"), 2);
        Assert.assertEquals(swaped.get("3(три)"), 3);
        // проверка на количество элементов в мапе
        Assert.assertEquals(swaped.size(), 3);
    }
}