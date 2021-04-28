package com.netcracker.sources;

import java.util.Iterator;

class Node<E> {
    E element;
    Node<E> nextNode;

    Node() {
    }

    Node(E element) {
        this.element = element;
    }

    Node(E element, Node<E> nextNode) {
        this(element);
        this.nextNode = nextNode;
    }
}

public class MyLinkedList<E> implements ILinkedList<E> {
    private Node<E> head, tail;
    private int size = 0;


    MyLinkedList() {
    }

    MyLinkedList(MyLinkedList<E> another) {
        this.size = another.size;
        this.head = null;
        Node<E> inputNode = another.head;
        Node<E> curNode, prevNode = null;
        while (inputNode != null) {
            curNode = new Node<>(inputNode.element, null);

            if (this.head == null) {
                this.head = curNode;
                prevNode = curNode;
            } else {
                prevNode.nextNode = curNode;
                prevNode = prevNode.nextNode;
            }

            inputNode = inputNode.nextNode;
        }
        this.tail = prevNode;
    }

    public void pushHead(E element) {
        Node<E> node = new Node<>(element, head);
        if (head == null) {
            tail = node;
        }
        head = node;
        size++;
    }


    @Override
    public void add(E element) {
        Node<E> node = new Node<>(element, null);
        if (tail == null) {
            tail = node;
            head = node;
        } else {
            tail.nextNode = node;
            tail = tail.nextNode;
        }
        size++;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Invalid list index");
        }

        if (index == 0) {
            this.pushHead(element);
            return;
        }


        Node<E> currNode = head;
        for (int i = 0; i != index - 1; i++) {
            currNode = currNode.nextNode;
        }

        Node<E> nextNode = currNode.nextNode;
        currNode.nextNode = new Node<>(element, nextNode);
        size++;
    }

    @Override
    public void clear() {
        if (this.head == null) {
            return;
        }

        Node<E> currNode = head;
        while (currNode != null) {
            Node<E> nextNode = currNode.nextNode;
            currNode.element = null;
            currNode.nextNode = null;
            currNode = nextNode;
        }

        head = tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Invalid list index");
        }

        Node<E> currNode = head;
        for (int i = 0; i != index; i++) {
            currNode = currNode.nextNode;
        }
        return currNode.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> currNode = head;
        int i = 0;
        while (currNode != null && currNode.element != element) {
            currNode = currNode.nextNode;
            i++;
        }

        return (currNode == null) ? i : -1;
    }

    public E popHead() {
        if (head == null) {
            throw new NullPointerException("List is empty");
        }

        Node<E> oldHead = head;
        if (head == tail) {
            tail = null;
        }
        head = head.nextNode;

        oldHead.nextNode = null;
        size--;
        return oldHead.element;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Invalid list index");
        }

        if (index == 0) {
            return this.popHead();
        }

        Node<E> currNode = head;
        for (int i = 0; i != index - 1; i++) {
            currNode = currNode.nextNode;
        }

        Node<E> prevNode = currNode;
        currNode = currNode.nextNode;
        prevNode.nextNode = currNode.nextNode;
        if (tail == currNode) {
            tail = prevNode;
        }

        currNode.nextNode = null;
        size--;
        return currNode.element;
    }

    @Override
    public void set(int index, E element) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Invalid list index");
        }

        Node<E> currNode = head;
        for (int i = 0; i != index; i++) {
            currNode = currNode.nextNode;
        }

        currNode.element = element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E[] toArray() {
        // a kak
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
