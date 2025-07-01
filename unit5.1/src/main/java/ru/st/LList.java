package ru.st;

import java.util.Iterator;

public class LList {
    private final Node first = new Node();
    private final Node last = new Node();

    public LList() {
        // Устанавливаем связи между фиктивными узлами
        first.next = last;
        last.prev = first;
    }

    private static class Node {
        Node prev;
        Object value;
        Node next;

        @Override
        public String toString() {
            return value != null ? value.toString() : "null";
        }
    }

    public void add(Object value) {
        Node newNode = new Node();
        newNode.value = value;

        Node prev = last.prev;
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = last;
        last.prev = newNode;
    }

    public Object get(int index) {
        if (index < 0) {
            return null;
        }

        Node currentNode = first.next;
        for (int i = 0; i < index; i++) {
            if (currentNode == last) {
                return null;
            }
            currentNode = currentNode.next;
        }

        return currentNode == last ? null : currentNode.value;
    }

    public Object getFirst() {
        return this.get(0);
    }

    public Object getLast() {
        return this.get(this.size() - 1);
    }

    /*
        итератор для size и printAll
    */
    public Iterable<Object> values() {
        return () -> new Iterator<>() {
            private Node current = first.next;

            public boolean hasNext() {
                return current != last;
            }

            public Object next() {
                Object val = current.value;
                current = current.next;
                return val;
            }
        };
    }

    public int size() {
        int count = 0;
        for (Object v : values()) {
            count++;
        }
        return count;
    }


    public void printAll() {
        for (Object v : values()) {
            System.out.println(v);
        }
    }
}
