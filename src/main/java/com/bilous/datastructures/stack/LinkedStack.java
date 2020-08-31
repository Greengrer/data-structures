package com.bilous.datastructures.stack;

public class LinkedStack implements Stack {

    private Node tail;
    private int size;

    public void push (Object value) {
        if (size == 0){
            tail = new Node();
            tail.value = value;
        } else {
            Node current = tail;
            while(current.previous != null){
                current = current.previous;
            }
            tail = new Node();
            tail.previous = current;
            tail.value = value;
        }
        size++;
    }

    public Object peek() {
        if (size == 0){
            throw new IllegalArgumentException("Stack is empty.");
        } else {
           return tail.value;
        }
    }

    public Object pop() {
        if (size == 0){
            throw new IllegalArgumentException("Stack is empty.");
        } else {
            Object lastElement = tail.value;
            tail = tail.previous;
            size--;
            return lastElement;
        }
    }

    public int size() {
        return size;
    }

    public String toString(){
        if (size == 0) {
            return "";
        }
        String string = new String();
        Node current = tail;
        while(current != null){
            string = current.value.toString() + string;
            current = current.previous;
        }
        return string;
    }

}
