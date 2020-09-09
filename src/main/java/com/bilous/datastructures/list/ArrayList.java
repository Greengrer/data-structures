package com.bilous.datastructures.list;

public class ArrayList extends AbstractList implements List {

    private static final int DEFAULT_INITIAL_CAPACITY = 2;
    private Object[] array;
    private int size;

 /*   Iterator iterator(){

    }*/

    public ArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public ArrayList(int initialCapacity) {
        array = new Object[initialCapacity];
    }

    @Override
    public void add(Object value, int index) {
        validateIndexForAdd(index);

        if (size == array.length) {
            Object[] newArray = new Object[((array.length * 3) / 2) + 1];

            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }

        if (size - index >= 0) System.arraycopy(array, index, array, index + 1, size - index);

        array[index] = value;
        size++;
    }

    @Override
    public Object remove(int index) {

        validateIndex(index);
        Object removedElement = array[index];

        if (size - index + 1 >= 0) System.arraycopy(array, index + 1, array, index + 1 - 1, size - index + 1);

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

    @Override
    public String toString() {

        if (isEmpty()) {
            return "[]";
        } else {
            StringBuilder builder = new StringBuilder();

            builder.append("[");

            for (int i = 0; i < size - 1; i++) {
                builder.append(array[i]);
                builder.append(", ");
            }

            builder.append(array[size - 1]);
            builder.append("]");
            return builder.toString();
        }
    }

}
