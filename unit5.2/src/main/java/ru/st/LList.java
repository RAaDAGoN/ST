package ru.st;

public class LList<E> implements myList<E> {
    private Node first = new Node();
    private Node last = new Node();

    public LList(){
        first.next = last;
        last.prev = first;
    }

    public class Node{
        private Node prev;
        private E value;
        private Node next;
    }

    @Override
    public int size() {
        int size = 0;
        Node currentNode = first.next;
        while (currentNode != null && currentNode != last){
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }

    @Override
    public void add(E value) {
        Node root = new Node();
        root.value = value;

        Node lastNode = last.prev;
        lastNode.next = root;
        root.prev = lastNode;
        root.next = last;
        last.prev = root;
    }

    @Override
    public E get(int index) {
        if (index < 0){
            return null;
        }
        Node current = first.next;
        for (int i = 0; i < index; i++) {
            if (current == null || current == last){
                return null;
            }
            current = current.next;
        }

        return (current == null || current == last) ? null : current.value;
    }

    @Override
    public void printAll(){
        Node currentNode = first.next;
        while ((currentNode != null) && (currentNode != last)){
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
        }
    }
}
