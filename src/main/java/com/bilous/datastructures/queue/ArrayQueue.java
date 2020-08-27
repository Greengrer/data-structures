package com.bilous.datastructures.queue;

public class ArrayQueue implements Queue{
   private Object [] queue = new Object [2];
   private int size;

    public void enqueue(Object value){
        if (size == queue.length) {
            Object [] temp = new Object [(queue.length * 3) / 2];
            for (int i = 0; i < queue.length; i++) {
                temp[i] = queue[i];
            }
            queue = temp;
        }
        queue[size] = value;
        size++;
    }

    public Object dequeue(){
        Object element = queue[0];
        Object [] temp = new Object [queue.length];
        for(int i = 0; i < size - 1; i++){
            temp[i]= queue[i + 1];
        }
        queue[0] = null;
        queue = temp;
        size--;
        return element;
    }

    public Object peek(){
        return queue[0];
    }

    public int size(){
        return (size);
    }

    public Object [] getQueue(){
        return queue;
    }

}
