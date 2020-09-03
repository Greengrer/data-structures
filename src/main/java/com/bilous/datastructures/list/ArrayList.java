package com.bilous.datastructures.list;

public class ArrayList implements List{

    private static final int DEFAULT_INITIAL_CAPACITY = 2;
    private Object [] array;
    private int size;

    public ArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }
    public ArrayList(int initialCapacity) {
        array = new Object [initialCapacity];
    }



    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public void add(Object value, int index) {
        validateIndexForAdd(index);

        if (size == array.length) {
            Object [] newArray = new Object[(array.length * 3) / 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
             array = newArray;
        }

        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = value;
        size++;
    }

    @Override
    public Object remove(int index) {

        validateIndex(index);
        Object removedElement = array[index];

        for (int i = index + 1; i < size; i++) {
            array[i - 1] = array[i];
        }

        array[size - 1] = null;
        size--;
        return removedElement;
    }

    @Override
    public Object get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        validateIndex(index);
        Object changedElement = array[index];
        array[index] = value;
        return changedElement;
    }

    @Override
    public void clear() {

        for (int i = 0; i < size; i++) {
            array[i] = null;
        }

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

        for (int i = 0; i < size; i++) {
            if (value.equals(array[i])) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {

        for (int i = size - 1; i >= 0; i--) {
            if (value.equals(array[i])) {
                return i;
            }
        }

        return -1;
    }

    private void validateIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of these bounds: from 0 to " + size + "(inclusive.)");
        }
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
            String string = "[";

            for (int i = 0; i < size - 1; i++) {
                    string += (array[i] + ", ");
            }

            string += (array[size - 1] + "]");
            return string;
        }
    }
}
