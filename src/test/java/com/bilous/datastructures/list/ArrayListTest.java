package com.bilous.datastructures.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {
    ArrayList emptyList = new ArrayList();
    ArrayList listWithThreeElements = new ArrayList();

    @Test
    public void testAddAndGet() {

        //when
        for (int i = 0; i < 3; i++) {
            listWithThreeElements.add(i);
        }
        //then
        for (int i = 0; i < 3; i++) {
            assertEquals(i, listWithThreeElements.get(i));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetByIndexOutOfBounds() {

        for (int i = 0; i < 3; i++) {
            listWithThreeElements.add(i);
        }
        listWithThreeElements.get(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetOnEmptyList() {
        emptyList.get(0);
    }

    @Test
    public void testSet() {

        //when
        for (int i = 0; i < 3; i++) {
            listWithThreeElements.add(i);
            listWithThreeElements.set(2 - i, i);
        }
        //then
        for (int i = 0; i < 3; i++) {
            assertEquals(2 - i, listWithThreeElements.get(i));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetByIndexOutOfBounds() {

        for (int i = 0; i < 3; i++) {
            listWithThreeElements.add(i);
        }
        listWithThreeElements.set(null, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetOnEmptyList() {
        emptyList.set(null, 0);
    }

    @Test
    public void testSize() {
       //when
        for (int i = 0; i < 3; i++) {
            listWithThreeElements.add(i);
        }
        //then
        assertEquals(3, listWithThreeElements.size());
        assertEquals(0, emptyList.size());
    }

    @Test
    public void testIsEmpty() {
        //when
        for (int i = 0; i < 3; i++) {
            listWithThreeElements.add(i);
        }
        //then
        assertFalse(listWithThreeElements.isEmpty());
        assertTrue(emptyList.isEmpty());
    }

    @Test
    public void testAddByIndex() {

        //when
        for (int i = 0; i < 2; i++) {
            listWithThreeElements.add(i);
        }
        listWithThreeElements.add(2, 1);
        //then
        assertEquals(0, listWithThreeElements.get(0));
        assertEquals(2, listWithThreeElements.get(1));
        assertEquals(1, listWithThreeElements.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddByIndexOutOfBoundsPlusOne(){

        //when
        for (int i = 0; i < 2; i++) {
            listWithThreeElements.add(i);
        }
        listWithThreeElements.add(null, 3);
    }

    @Test
    public void testRemove() {

        //when
        for (int i = 0; i < 3; i++) {
            listWithThreeElements.add(i);
        }
        listWithThreeElements.remove(1);
        //then
        assertEquals(2, listWithThreeElements.size());
        assertEquals(2, listWithThreeElements.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOnIndexOutOfBounds() {
        for (int i = 0; i < 3; i++) {
            listWithThreeElements.add(i);
        }
        listWithThreeElements.remove(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveOnEmptyList() {
        emptyList.remove(0);
    }

    @Test
    public void testClear() {

        //when
        for (int i = 0; i < 3; i++) {
            listWithThreeElements.add(i);
        }
        listWithThreeElements.clear();
        //then
        assertEquals(0, listWithThreeElements.size());
        assertTrue(listWithThreeElements.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClearOnEmptyList() {
        emptyList.clear();
    }

    @Test
    public void testContains() {

        //when
        for (int i = 0; i < 3; i++) {
            listWithThreeElements.add(i);
        }
        //then
        assertTrue(listWithThreeElements.contains(1));
        assertFalse(listWithThreeElements.contains(-1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContainsOnEmptyList() {
        emptyList.contains(null);
    }

    @Test
    public void testIndexOf() {

        //when
        for (int i = 0; i < 3; i++) {
            listWithThreeElements.add((i + 1) % 2);
        }
        //then
        assertEquals(0, listWithThreeElements.indexOf(1));
        assertEquals(1, listWithThreeElements.indexOf(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIndexOfOnEmptyList() {
        emptyList.indexOf(null);
    }

    @Test
    public void testLastIndexOf() {

        //when
        for (int i = 0; i < 3; i++) {
            listWithThreeElements.add((i + 1) % 2);
        }
        //then
        assertEquals(2, listWithThreeElements.lastIndexOf(1));
        assertEquals(1, listWithThreeElements.lastIndexOf(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLastIndexOfOnEmptyList() {
        emptyList.lastIndexOf(null);
    }

    @Test
    public void testToString() {

        //when
        for (int i = 0; i < 3; i++) {
            listWithThreeElements.add(i);
        }
        //then
        assertEquals("[0, 1, 2]", listWithThreeElements.toString());
        assertEquals("[]", emptyList.toString());

    }
}
