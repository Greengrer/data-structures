package com.bilous.datastructures.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedArrayStackTest {

    @Test
    public void testPushAndPop(){

        //prepare
        LinkedArrayStack linkedStackTwoElements = new LinkedArrayStack();

        //when
        linkedStackTwoElements.push(0);
        linkedStackTwoElements.push(1);

        //then
        assertEquals(1, linkedStackTwoElements.pop());
        assertEquals(0, linkedStackTwoElements.pop());
        assertEquals(null, linkedStackTwoElements.pop());
    }

    @Test
    public void testPeek(){

        //prepare
        LinkedArrayStack linkedStackOneElement = new LinkedArrayStack();
        LinkedArrayStack linkedStackZeroElements = new LinkedArrayStack();

        //when
        linkedStackOneElement.push(0);

        //then
        assertEquals(0, linkedStackOneElement.peek());
        assertEquals(null, linkedStackZeroElements.peek());
    }

    @Test
    public void testSize(){

        //prepare
        LinkedArrayStack linkedStackOneElement = new LinkedArrayStack();
        LinkedArrayStack linkedStackZeroElements = new LinkedArrayStack();

        //when
        linkedStackOneElement.push(0);

        //then

        assertEquals(0, linkedStackZeroElements.size());
        assertEquals(1, linkedStackOneElement.size());
    }

    @Test
    public void testToString(){

        //prepare
        LinkedArrayStack linkedStackTwoElements = new LinkedArrayStack();
        LinkedArrayStack linkedStackZeroElements = new LinkedArrayStack();

        //when
        linkedStackTwoElements.push(0);
        linkedStackTwoElements.push(1);

        //then
        assertEquals("", linkedStackZeroElements.toString());
        assertEquals("01", linkedStackTwoElements.toString());
    }
}
