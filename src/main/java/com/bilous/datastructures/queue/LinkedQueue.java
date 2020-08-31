package com.bilous.datastructures.queue;

public class LinkedQueue implements Queue{

    private Node head;
    private Node tail;
    int size;

    @Override
    public void enqueue(Object value) {
        if (size == 0) {
            head = new Node();
            head.value = value;
            tail = head;
        } else {
            Node newElement = new Node();
            newElement.value = value;
            tail.previous = newElement;
            tail = newElement;
        }
        size++;
    }

    @Override
    public Object dequeue() {
        if (size == 0) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        Object firstElement = head.value;
        head = head.previous;
        size--;
        return firstElement;
    }

    @Override
    public Object peek() {
        if (size == 0) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return head.value;
    }

    @Override
    public int size() {
        return size;
    }

    public String toString() {
        String string = new String();
        Node current = head;
        while (current != null) {
            string = current.value.toString() + string;
            current = current.previous;
        }
        return string;
    }
}
