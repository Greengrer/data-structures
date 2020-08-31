package com.bilous.datastructures.list;

public class ArrayList implements List{

    private Object [] list = new Object[2];
    private int size;

    @Override
    public void add(Object value) {
        if (size == list.length) {
            Object [] temp = new Object[(list.length * 3) / 2];
            for (int i = 0; i < size; i++) {
                temp[i] = list[i];
            }
            list = temp;
        }
        list[size] = value;
        size++;
    }

    @Override
    public void add(Object value, int index) {
        validateIndex(index, size + 1);
        if (size == list.length) {
            Object [] temp = new Object[(list.length * 3) / 2];
            for (int i = 0; i < index; i++) {
                temp[i] = list[i];
            }
            temp[index] = value;
            for (int i = index; i < size; i++) {
                temp[i + 1] = list[i];
            }
            list = temp;
        } else {
            for (int i = size; i > index; i--) {
                list[i] = list[i - 1];
            }
            list[index] = value;
        }
        size++;
    }

    @Override
    public Object remove(int index) {
        if (size == 0){
            throw new IllegalArgumentException("The list is empty.");
        }
        validateIndex(index, size);
        Object removedElement = list[index];
        for (int i = index + 1; i < size; i++) {
            list[i - 1] = list[i];
        }
        list[size - 1] = null;
        size--;
        return removedElement;
    }

    @Override
    public Object get(int index) {
        if (size == 0){
            throw new IllegalArgumentException("The list is empty.");
        }
        validateIndex(index, size);
        return list[index];
    }

    @Override
    public Object set(Object value, int index) {
        if (size == 0){
            throw new IllegalArgumentException("The list is empty.");
        }
        validateIndex(index, size);
        list[index] = value;
        return list[index];
    }

    @Override
    public void clear() {
        if (size == 0){
            throw new IllegalArgumentException("The list is empty.");
        }
        for (int i = 0; i < size; i++) {
            list[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(Object value) {
        if (size == 0){
            throw new IllegalArgumentException("The list is empty.");
        }
        for (int i = 0; i < size; i++) {
            if (value == list[i]){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        if (size == 0){
            throw new IllegalArgumentException("The list is empty.");
        }
        for (int i = 0; i < size; i++) {
            if (value == list[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        if (size == 0){
            throw new IllegalArgumentException("The list is empty.");
        }
        int lastIndexOf = -1;
        for (int i = 0; i < size; i++) {
            if (value == list[i]) {
                lastIndexOf = i;
            }
        }
        return lastIndexOf;
    }

    private void validateIndex(int index, int listSize) {
        if (index < 0 || index >= listSize) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of these bounds: from 0 to " + (size - 1));
        }
    }

    @Override
    public String toString(){
        if (isEmpty()) {
            return "[]";
        } else {
            String string = "[";
            for (int i = 0; i < size - 1; i++) {
                if (list[i] == null){
                    string += ", ";
                } else {
                    string += (list[i].toString() + ", ");
                }
            }
            if (list[size - 1] == null) {
                string += "]";
            } else {
                string += (list[size - 1] + "]");
            }
            return string;
        }
    }
}
