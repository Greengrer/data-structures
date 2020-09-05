package com.bilous.datastructures.list;

import java.util.Objects;

public class LinkedList implements List {

    private int size;
    private Node head;
    private Node tail;

    @Override
    public void add(Object value) {
        Node newNode = new Node(value);

        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }

        size++;
    }
    @Override
    public void add(Object value, int index) {

        if (index == size) {
            add(value);
        }

        validateIndex(index);
        Node newNode = new Node(value);
        Node current = getNodeByIndex(index);
        newNode.setPrevious(current.getPrevious());
        newNode.setNext(current);
        current.setPrevious(newNode);

        if (newNode.getPrevious() != null) {
            current = newNode.getPrevious();
            current.setNext(newNode);
        }

        size++;
    }

    @Override
    public Object remove(int index) {
        validateIndex(index);
        Object removedElement;

        if (size == 1) {
            removedElement = head.getValue();
            head = null;
            tail = null;
            size--;
            return removedElement;
        }
        
        if (index == 0) {
            removedElement = head.getValue();
            head = head.getNext();
            head.setPrevious(null);
        } else if (index == size - 1) {
            removedElement = tail.getValue();
            tail = tail.getPrevious();
            tail.setNext(null);
        } else {
            Node nodeToRemove = getNodeByIndex(index);
            removedElement = nodeToRemove.getValue();
            Node connector = nodeToRemove.getPrevious();
            connector.setNext(nodeToRemove.getNext());
            connector = connector.getNext();
            connector.setPrevious(nodeToRemove.getPrevious());
        }

            size--;
            return removedElement;
    }
    

    @Override
    public Object get(int index) {
        validateIndex(index);
        Node current = getNodeByIndex(index);
        return current.getValue();
    }

    @Override
    public Object set(Object value, int index) {
        validateIndex(index);
        Node nodeToChange = getNodeByIndex(index);
        Object changedElement = nodeToChange.getValue();
        nodeToChange.setValue(value);
        return changedElement;
    }

    @Override
    public void clear() {
        tail = head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(Object value) {
        Node current = head;

        for (int i = 0; i < size; i++) {

            if (value.equals(current.getValue())) {
                return i;
            }

            current = current.getNext();
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        Node current = tail;

        for (int i = size - 1; i >= 0; i--) {

            if (value.equals(current.getValue())) {
                return i;
            }

            current = current.getPrevious();
        }

        return -1;
    }

    private void validateIndex(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of these bounds: from 0 to " + size + "(exclusive.)");
        }
    }

    @Override
    public String toString(){

        if (isEmpty()) {
            return "[]";
        } else {
            String result = "[";
            Node current = head;

            for (int i = 0; i < size - 1; i++) {
                result += (current.getValue() + ", ");
                current = current.getNext();
            }

            result += (tail.getValue() + "]");
            return result;
        }
    }
    
    private Node getNodeByIndex(int index) {
        Node current;

        if (index < size / 2) {
            current = head;

            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        } else {
            current = tail;

            for (int i = size - 1; i > index; i--) {
                current = current.getPrevious();
            }
        }

        return current;
    }
}
    
