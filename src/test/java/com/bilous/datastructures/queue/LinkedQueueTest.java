package com.bilous.datastructures.queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedQueueTest {

    LinkedQueue emptyQueue = new LinkedQueue();
    LinkedQueue queueWithThreeElements = new LinkedQueue();

    @Test
    public void testEnqueueAndDequeue() {

        //when
        for (int i = 0; i < 3; i++) {
            queueWithThreeElements.enqueue(i);
        }
        //then
        assertEquals(0, queueWithThreeElements.dequeue());
        assertEquals(1, queueWithThreeElements.dequeue());
        assertEquals(2, queueWithThreeElements.dequeue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDequeueOnEmptyQueue() {
        emptyQueue.dequeue();
    }

    @Test
    public void testPeek() {

        //when
        for (int i = 0; i < 3; i++) {
            queueWithThreeElements.enqueue(i);
        }
        //then
        assertEquals(0, queueWithThreeElements.peek());
        assertEquals(0, queueWithThreeElements.peek());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPeekOnEmptyQueue(){
        emptyQueue.peek();
    }

    @Test
    public void testToString() {

        //when
        for (int i = 0; i < 3; i++) {
            queueWithThreeElements.enqueue(i);
        }
        //then
        assertEquals("210", queueWithThreeElements.toString());
        assertEquals("", emptyQueue.toString());
    }

    @Test
    public void testSize() {

        //when
        for (int i = 0; i < 3; i++) {
            queueWithThreeElements.enqueue(i);
        }
        //then
        assertEquals(3, queueWithThreeElements.size());
        assertEquals(0, emptyQueue.size());
    }
}
