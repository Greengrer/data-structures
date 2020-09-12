package com.bilous.datastructures.list;

import java.util.Iterator;

public class LinkedList<T> extends AbstractList<T>{

    private LinkedList.Node<T> head;
    private LinkedList.Node<T> tail;

    @Override
    public void add(T value, int index) {
        LinkedList.Node<T> newNode = new LinkedList.Node<>(value);
        validateIndexForAdd(index);
        if (size == 0) {
            head = tail = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        } else if (index == 0) {
            head.previous = newNode;
            newNode.next = head;
            head = newNode;
        } else {
            LinkedList.Node<T> current = getNode(index);
            newNode.previous = current.previous;
            newNode.next = current;
            current.previous = newNode;
            current = newNode.previous;
            current.next = newNode;
        }

        size++;
    }

    @Override
    public T remove(int index) {
        validateIndex(index);
        T removedElement;

        if (size == 1) {
            removedElement = head.value;
            head = null;
            tail = null;
        }else if (index == 0) {
            removedElement = head.value;
            head = head.next;
            head.previous = null;
        } else if (index == size - 1) {
            removedElement = tail.value;
            tail = tail.previous;
            tail.next = null;
        } else {
            LinkedList.Node<T> nodeToRemove = getNode(index);
            removedElement = nodeToRemove.value;
            nodeToRemove.previous.next = nodeToRemove.next;
            nodeToRemove.next.previous = nodeToRemove.previous;
        }

        size--;
        return removedElement;
    }


    @Override
    public T get(int index) {
        validateIndex(index);
        LinkedList.Node<T> current = getNode(index);
        return current.value;
    }

    @Override
    public T set(T value, int index) {
        validateIndex(index);
        LinkedList.Node<T> nodeToChange = getNode(index);
        T changedElement = nodeToChange.value;
        nodeToChange.value = value;
        return changedElement;
    }
/*
    @Override
    public void clear() {
        Node<T> currentFromHead = head;
        Node<T> currentFromTail = tail;

        for (int i = 0; i < size; i++) {
            currentFromHead = currentFromHead.next;
            currentFromHead.previous = null);
            currentFromTail = currentFromTail.previous;
            currentFromTail.next = null);
        }

        tail = head = null;
        size = 0;
    }
*/

    @Override
    public void clear() {
        LinkedList.Node<T> current = head;
        LinkedList.Node<T> next;

        for (int i = 0; i < size; i++) {
            next = current.next;
            current.next = null;
            current.previous = null;
            current.value = null;
            current = next;
        }

        tail = head = null;
        size = 0;
    }

    @Override
    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(T value) {
        LinkedList.Node<T> current = head;

        for (int i = 0; i < size; i++) {

            if (value.equals(current.value)) {
                return i;
            }

            current = current.next;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(T value) {
        LinkedList.Node<T> current = tail;

        for (int i = size - 1; i >= 0; i--) {

            if (value.equals(current.value)) {
                return i;
            }

            current = current.previous;
        }

        return -1;
    }

    private LinkedList.Node<T> getNode(int index) {
        LinkedList.Node<T> current;

        if (index < size / 2) {
            current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;

            for (int i = size - 1; i > index; i--) {
                current = current.previous;
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
            LinkedList.Node<T> current = head;

            for (int i = 0; i < size - 1; i++) {
                builder.append(current.value);
                builder.append(", ");
                current = current.next;
            }

            builder.append(tail.value);
            builder.append("]");
            return builder.toString();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedList<T>.LinkedListIterator();
    }

    private static class Node<T> {

        private T value;
        private Node<T> next;
        private Node<T> previous;

        public Node(T value) {
            this.value = value;
        }

    }

    private class LinkedListIterator implements Iterator<T>{

        private int step;
        private LinkedList.Node<T> current = head;

        @Override
        public boolean hasNext() {
            return step < size;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            step++;
            return value;
        }
    }

}
