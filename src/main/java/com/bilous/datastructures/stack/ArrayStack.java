package com.bilous.datastructures.stack;

public class ArrayStack implements Stack{
    private Object [] stack = new Object [2];
    private int size = 0;

    public void push(Object value) {
        if (size == stack.length) {
            Object [] temp = new Object [(stack.length * 3) / 2];
            for (int i = 0; i < stack.length; i++) {
                temp[i] = stack[i];
            }
            stack = temp;
        }
        stack[size] = value;
        size++;
    }

    public Object pop(){
        if (size == 0) {
            return null;
        }
        Object lastElement = stack[size - 1];
        stack[size - 1] = null;
        size--;
        return lastElement;
    }

    public Object peek(){
        if (size == 0){
            return null;
        }
        return stack[size - 1];
    }

    public int size(){
       return size;
    }

    public Object [] getStack(){
        return stack;
    }
}
