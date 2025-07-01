package ru.st;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LList list = new LList();

        list.add(Integer.valueOf(1));
        list.add(Integer.valueOf(2));
        list.add(Integer.valueOf(3));
        list.add(Integer.valueOf(4));
        list.add("dsad");

        list.printAll();

        System.out.println(list.getLast());


    }
}