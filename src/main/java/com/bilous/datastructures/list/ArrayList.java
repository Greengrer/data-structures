package com.bilous.datastructures.list;

import java.util.Iterator;

public class ArrayList<T> extends AbstractList<T>{

    private static final int DEFAULT_INITIAL_CAPACITY = 2;
    private T[] array;



    public ArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public ArrayList(int initialCapacity) {
        array = (T[]) new Object[initialCapacity];
    }

    @Override
    public void add(T value, int index) {
        validateIndexForAdd(index);

        if (size == array.length) {
            Object[] newArray =  new Object[((array.length * 3) / 2) + 1];

            System.arraycopy(array, 0, newArray, 0, size);
            array = (T[]) newArray;
        }

        if (size - index >= 0) System.arraycopy(array, index, array, index + 1, size - index);

        array[index] = value;
        size++;
    }

    @Override
    public  T remove(int index) {

        validateIndex(index);
        T removedElement = array[index];

        if (size - index > 0) System.arraycopy(array, index + 1, array, index,  size - index - 1);

        array[size - 1] = null;
        size--;
        return removedElement;
    }

    @Override
    public T get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public T set(T value, int index) {
        validateIndex(index);
        T changedElement = array[index];
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
    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(T value) {

        for (int i = 0; i < size; i++) {

            if (value.equals(array[i])) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(T value) {

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

    public Iterator<T> iterator(){
        return new ArrayListIterator();
    }

    class ArrayListIterator implements Iterator<T>{

        private int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            return array[index++];
        }
    }

}
