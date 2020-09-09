package com.bilous.datastructures.list;

public abstract class AbstractList{

    private int size;

    abstract void add(Object value, int index);

    public void add(Object value) { add(value, size);}

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void validateIndex(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of these bounds: from 0 to " + size + "(exclusive.)");
        }
    }

    public void validateIndexForAdd(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of these bounds: from 0 to " + size + "(inclusive.)");
        }
    }

}
