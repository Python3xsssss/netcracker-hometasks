package com.netcracker.sources;

public interface ILinkedList<E> extends Iterable<E> {
    void add(E element);
    void add(int index, E element);
    void clear();
    E get(int index);
    int indexOf(E element);
    E remove(int index);
    void set(int index, E element);
    int size();
    <T> T[] toArray(T[] a);
    String toString();
}