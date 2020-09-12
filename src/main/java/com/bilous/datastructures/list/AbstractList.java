package com.bilous.datastructures.list;

public abstract class AbstractList<T> implements List<T> {

    public int size;

    public abstract void add(T value, int index);

    public void add(T value) {
        add(value, size);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    protected void validateIndex(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of these bounds: from 0 to " + size + "(exclusive.)");
        }
    }

    protected void validateIndexForAdd(int index) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of these bounds: from 0 to " + size + "(inclusive.)");
        }
    }

}
