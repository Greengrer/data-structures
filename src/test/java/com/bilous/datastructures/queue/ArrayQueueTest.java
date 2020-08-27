package com.bilous.datastructures.queue;

import com.bilous.datastructures.stack.ArrayStack;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayQueueTest {

    private ArrayQueue queueWithZeroElements = new ArrayQueue();
    private ArrayQueue queueWithThreeElements = new ArrayQueue();

    @Test
    public void testEnqueueAndDequeue(){

        //when
        for (int i = 0; i < 3; i++) {
            queueWithThreeElements.enqueue(i);
        }

        //then
        assertEquals(0, queueWithThreeElements.dequeue());
        assertEquals(1, queueWithThreeElements.dequeue());
        assertEquals(2, queueWithThreeElements.dequeue());
        assertEquals(null, queueWithThreeElements.dequeue());
        assertEquals(null, queueWithZeroElements.dequeue());
    }

    @Test
    public void testPeek(){

        //when
        for (int i = 0; i < 3; i++) {
            queueWithThreeElements.enqueue(i);
        }

        //then
        assertEquals(0, queueWithThreeElements.peek());
        assertEquals(0, queueWithThreeElements.peek());
        assertEquals(0, queueWithThreeElements.peek());
        assertEquals(null, queueWithZeroElements.peek());
    }

    @Test
    public void testSize(){

        //when
        for (int i = 0; i < 3; i++) {
            queueWithThreeElements.enqueue(i);
        }

        //then
        assertEquals(3, queueWithThreeElements.size());
        assertEquals(0, queueWithZeroElements.size());

    }
}
