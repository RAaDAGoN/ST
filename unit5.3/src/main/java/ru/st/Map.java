package ru.st;

import java.util.HashMap;

public class Map {
    public static <K, V> java.util.Map<V, K> swap(java.util.Map<K, V> map){
        java.util.Map<V, K> s = new HashMap<>();
        for (java.util.Map.Entry<K, V> entry : map.entrySet()){
            s.put(entry.getValue(), entry.getKey());
        }

        return s;
    }
}
