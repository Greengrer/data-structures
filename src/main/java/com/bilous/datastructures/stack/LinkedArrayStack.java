package com.bilous.datastructures.stack;

public class LinkedArrayStack implements Stack {

    private Node head = new Node();

    private int size;

    public void push (Object value) {
        if (size == 0){
            head.value = value;
        } else {
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = new Node();
            current = current.next;
            current.value = value;
        }
        size++;
    }

    public Object peek() {
        if (size == 0){
            return null;
        } else {
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            return current.value;
        }
    }

    public Object pop() {
        if (size == 0){
            return null;
        } else if (size == 1) {
            Object lastElement = head.value;
            head.value = null;
            size--;
            return lastElement;
        } else {
            Node current = head;
            while(current.next != null){
                if (current.next.next == null) {
                    break;
                }
                current = current.next;
            }
            Object lastElement = current.next.value;
            current.next = null;
            size--;
            return lastElement;
        }
    }

    public int size() {
        return size;
    }

    public String toString(){
        String string = new String();
        Node current = head;
        for (int i = 0; i < size; i++) {
            string += current.value.toString();
            current = current.next;
        }
        return string;
    }

}
