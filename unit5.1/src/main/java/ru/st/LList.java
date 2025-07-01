package ru.st;

public class LList {
    private Node first = new Node();
    private Node last = new Node();

    public static class Node {
        private Node prev;
        private Object value;
        private Node next;
    }

    public int size(){
        int size = 0;
        Node currentNode = first.next;
        while ((currentNode != null) && (currentNode != last)){
            size++;
            currentNode = currentNode.next;
        }

        return size;
    }

    public void add(Object value){
        Node root = new Node();
        root.value = value;
        if (last.prev == null){
            last.prev = root;
            first.next = root;
        } else {
            root.prev = last.prev;
            last.prev = root;
            root.prev.next = root;
        }
    }

    public Object get(int index){
        if (index < 0){
            return null;
        }

        Node current = first.next;
        for (int i = 0; i < index; i++) {
            if (current == last) {
                return null;
            }
            current = current.next;
        }
        return current == last ? null : current.value;
    }

    public Object getFirst(){
        return this.get(0);
    }

    public Object getLast(){
        return this.get(this.size() - 1);
    }


    public void printAll(){
        Node currentNode = first.next;
        while ((currentNode != null) && (currentNode != last)){
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
        }
    }
}
