package com.bilous.datastructures.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractListTest {

    List emptyList;
    List listWithThreeElements;
    List listWithOneElement;

    @Before
    public void before() {
        emptyList = getList();
        listWithThreeElements = getList();
        for (int i = 0; i < 3; i++) {
            listWithThreeElements.add(i);
        }
        listWithOneElement = getList();
        listWithOneElement.add(1);
    }

    abstract List getList();

    @Test
    public void testAddAndGet() {
        for (int i = 0; i < 3; i++) {
            assertEquals(i, listWithThreeElements.get(i));
        }
        assertEquals(1, listWithOneElement.get(0));
    }

    @Test
    public void testGetByIndexHigherThanBothBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.get(1));
    }

    @Test
    public void testGetByIndexLowerThanBothBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.get(-1));
    }

    @Test
    public void testSet() {
        //when
        assertEquals(0, listWithThreeElements.set("A", 0));
        assertEquals(1, listWithThreeElements.set("B", 1));
        assertEquals(2, listWithThreeElements.set("C", 2));
        assertEquals(1, listWithOneElement.set("D", 0));
        //then
        assertEquals("A", listWithThreeElements.get(0));
        assertEquals("B", listWithThreeElements.get(1));
        assertEquals("C", listWithThreeElements.get(2));
        assertEquals("D", listWithOneElement.get(0));
    }

    @Test
    public void testSetByIndexHigherThanBothBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.set(null, 1));
    }

    @Test
    public void testSetByIndexLowerThanBothBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.set(null, 1));
    }

    @Test
    public void testSize() {
        //then
        assertEquals(3, listWithThreeElements.size());
        assertEquals(1, listWithOneElement.size());
        assertEquals(0, emptyList.size());
    }

    @Test
    public void testIsEmpty() {
        //then
        assertFalse(listWithThreeElements.isEmpty());
        assertFalse(listWithOneElement.isEmpty());
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

    @Test
    public void testAddByIndexOutOfBoundsPlusOne(){
        assertThrows(IndexOutOfBoundsException.class, () -> listWithThreeElements.add(null, 4));

    }

    @Test
    public void testRemove() {
        listWithThreeElements.remove(1);
        //then
        assertEquals(2, listWithThreeElements.size());
        assertEquals(2, listWithThreeElements.get(1));
    }

    @Test
    public void testRemoveOnIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> listWithThreeElements.remove(3));

    }

    @Test
    public void testRemoveOnEmptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.remove(0));
    }

    @Test
    public void testClear() {

        //when
        listWithThreeElements.clear();
        listWithOneElement.clear();
        //then
        assertEquals(0, listWithThreeElements.size());
        assertEquals(0, listWithOneElement.size());
        assertTrue(listWithThreeElements.isEmpty());
        assertTrue(listWithOneElement.isEmpty());
    }

    @Test
    public void testContains() {
        //then
        assertTrue(listWithThreeElements.contains(1));
        assertFalse(listWithThreeElements.contains(-1));
    }

    @Test
    public void testContainsOnListWithOneElement() {
        //then
        assertTrue(listWithOneElement.contains(1));
        assertFalse(listWithOneElement.contains(-1));
    }

    @Test
    public void testIndexOf() {
        listWithThreeElements.set(1, 2);
        //then
        assertEquals(0, listWithThreeElements.indexOf(0));
        assertEquals(1, listWithThreeElements.indexOf(1));
        assertEquals(0, listWithOneElement.indexOf(1));
    }

    @Test
    public void testLastIndexOf() {
        //when
        listWithThreeElements.set(0, 2);
        assertEquals(2, listWithThreeElements.lastIndexOf(0));
        assertEquals(1, listWithThreeElements.lastIndexOf(1));
        assertEquals(0, listWithOneElement.lastIndexOf(1));
    }

    @Test
    public void testToString() {
        assertEquals("[0, 1, 2]", listWithThreeElements.toString());
        assertEquals("[1]", listWithOneElement.toString());
        assertEquals("[]", emptyList.toString());

    }

    @Test
    public void testManualConstructorVulnerability() {
        listWithThreeElements = new ArrayList(3);
        assertEquals(0, listWithThreeElements.size());
    }

    @Test
    public void testDefaultConstructorVulnerability() {
        listWithThreeElements = new ArrayList();
        assertEquals(0, listWithThreeElements.size());
    }

}
