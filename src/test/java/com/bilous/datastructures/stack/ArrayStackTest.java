package com.bilous.datastructures.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayStackTest {

    private ArrayStack stackWithZeroElements = new ArrayStack();
    private ArrayStack stackWithThreeElements = new ArrayStack();

    @Test
    public void testPushAndPop() {
        //when
        for (int i = 0; i < 3; i++) {
            stackWithThreeElements.push(i);
        }

        //then
        assertEquals(3, stackWithThreeElements.getStack().length);
        assertEquals(2, stackWithThreeElements.peek());
        assertEquals(2, stackWithThreeElements.pop());
        assertEquals(1, stackWithThreeElements.pop());
        assertEquals(0, stackWithThreeElements.pop());
        assertEquals(null, stackWithThreeElements.pop());
    }

    @Test
    public void testPeek() {
        //when
        for (int i = 0; i < 3; i++) {
            stackWithThreeElements.push(i);
        }

        //then
        assertEquals(2, stackWithThreeElements.peek());
        assertEquals(2, stackWithThreeElements.peek());
        assertEquals(2, stackWithThreeElements.peek());
        assertEquals(null, stackWithZeroElements.peek());
    }

    @Test
    public void testSize() {
        //when
        for (int i = 0; i < 3; i++) {
            stackWithThreeElements.push(i);
        }
        //then
        assertEquals(3, stackWithThreeElements.size());
        assertEquals(0, stackWithZeroElements.size());

    }

}
