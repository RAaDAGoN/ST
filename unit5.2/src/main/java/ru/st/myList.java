package ru.st;

public interface myList<E> {
    public int size();
    public void add(E value);
    public E get(int index);
    public void printAll();

    default E getFirst(){
        return this.get(0);
    }

    default E getLast(){
        return this.get(this.size() -1);
    }
}
