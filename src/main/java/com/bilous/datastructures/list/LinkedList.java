package com.bilous.datastructures.list;

public class LinkedList extends AbstractList implements List {

    private int size;
    private Node head;
    private Node tail;

    @Override
    public void add(Object value, int index) {
        Node newNode = new Node(value);
        validateIndexForAdd(index);
        if (size == 0) {
            head = tail = newNode;
        } else if (index == size) {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        } else if (index == 0) {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        } else {
            Node current = getNode(index);
            newNode.setPrevious(current.getPrevious());
            newNode.setNext(current);
            current.setPrevious(newNode);
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
            Node nodeToRemove = getNode(index);
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
        Node current = getNode(index);
        return current.getValue();
    }

    @Override
    public Object set(Object value, int index) {
        validateIndex(index);
        Node nodeToChange = getNode(index);
        Object changedElement = nodeToChange.getValue();
        nodeToChange.setValue(value);
        return changedElement;
    }
/*
    @Override
    public void clear() {
        Node currentFromHead = head;
        Node currentFromTail = tail;

        for (int i = 0; i < size; i++) {
            currentFromHead = currentFromHead.getNext();
            currentFromHead.setPrevious(null);
            currentFromTail = currentFromTail.getPrevious();
            currentFromTail.setNext(null);
        }

        tail = head = null;
        size = 0;
    }
*/

    @Override
    public void clear() {
        Node current = head;
        Node next;

        for (int i = 0; i < size; i++) {
            next = current.getNext();
            current.setNext(null);
            current.setPrevious(null);
            current.setValue(null);
            current = next;
        }

        tail = head = null;
        size = 0;
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

    private Node getNode(int index) {
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

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            Node current = head;

            for (int i = 0; i < size - 1; i++) {
                builder.append(current.getValue());
                builder.append(", ");
                current = current.getNext();
            }

            builder.append(tail.getValue());
            builder.append("]");
            return builder.toString();
        }
    }

}
