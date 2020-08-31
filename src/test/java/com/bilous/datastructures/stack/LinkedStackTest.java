package com.bilous.datastructures.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedStackTest {
    LinkedStack stackWithTwoElements = new LinkedStack();
    LinkedStack emptyStack = new LinkedStack();

    @Test
    public void testPushAndPop(){

        //when
        stackWithTwoElements.push(0);
        stackWithTwoElements.push(1);

        //then
        assertEquals(1, stackWithTwoElements.pop());
        assertEquals(0, stackWithTwoElements.pop());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPopOnEmptyStack() {
        emptyStack.pop();
    }

    @Test
    public void testPeek(){

        //when
        stackWithTwoElements.push(0);
        stackWithTwoElements.push(1);
        //then
        assertEquals(1, stackWithTwoElements.peek());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPeekOnEmptyStack(){
        emptyStack.peek();
    }

    @Test
    public void testSize(){

        //when
        stackWithTwoElements.push(0);
        stackWithTwoElements.push(1);
        //then
        assertEquals(2, stackWithTwoElements.size());
        assertEquals(0, emptyStack.size());
    }

    @Test
    public void testToString(){

       //when
        stackWithTwoElements.push(0);
        stackWithTwoElements.push(1);

        //then
        assertEquals("", emptyStack.toString());
        assertEquals("01", stackWithTwoElements.toString());
    }
}
