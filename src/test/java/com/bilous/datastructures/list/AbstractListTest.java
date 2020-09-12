package com.bilous.datastructures.list;

import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;

import static org.junit.Assert.*;

public abstract class AbstractListTest {

    List emptyIntegerList;
    List integerListWithThreeElements;
    List integerListWithOneElement;

    @Before
    public void before() {
        emptyIntegerList = getIntegerList();
        integerListWithThreeElements = getIntegerList();
        integerListWithOneElement = getIntegerList();

        for (int i = 0; i < 3; i++) {
            integerListWithThreeElements.add(i);
        }

        integerListWithOneElement.add(1);
    }

    abstract List<?> getIntegerList();


    @Test
    public void testAddAndGet() {

        for (int i = 0; i < 3; i++) {
            assertEquals(i, integerListWithThreeElements.get(i));
        }

        assertEquals(1, integerListWithOneElement.get(0));
    }

    @Test
    public void testGetByIndexHigherThanBothBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> emptyIntegerList.get(1));
    }

    @Test
    public void testGetByIndexLowerThanBothBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> emptyIntegerList.get(-1));
    }

    @Test
    public void testSet() {
        //when
        assertEquals(0, integerListWithThreeElements.set(3, 0));
        assertEquals(1, integerListWithThreeElements.set(4, 1));
        assertEquals(2, integerListWithThreeElements.set(5, 2));
        assertEquals(1, integerListWithOneElement.set(2, 0));
        //then
        assertEquals(3, integerListWithThreeElements.get(0));
        assertEquals(4, integerListWithThreeElements.get(1));
        assertEquals(5, integerListWithThreeElements.get(2));
        assertEquals(2, integerListWithOneElement.get(0));
    }

    @Test
    public void testSetByIndexHigherThanBothBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> emptyIntegerList.set(null, 1));
    }

    @Test
    public void testSetByIndexLowerThanBothBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> emptyIntegerList.set(null, 1));
    }

    @Test
    public void testSize() {
        //then
        assertEquals(3, integerListWithThreeElements.size());
        assertEquals(1, integerListWithOneElement.size());
        assertEquals(0, emptyIntegerList.size());
    }

    @Test
    public void testIsEmpty() {
        //then
        assertFalse(integerListWithThreeElements.isEmpty());
        assertFalse(integerListWithOneElement.isEmpty());
        assertTrue(emptyIntegerList.isEmpty());
    }

    @Test
    public void testAddByIndex() {

        //when
        for (int i = 0; i < 2; i++) {
            integerListWithThreeElements.add(i);
        }

        integerListWithThreeElements.add(2, 1);
        //then
        assertEquals(0, integerListWithThreeElements.get(0));
        assertEquals(2, integerListWithThreeElements.get(1));
        assertEquals(1, integerListWithThreeElements.get(2));
    }

    @Test
    public void testAddByIndexOutOfBoundsPlusOne(){
        assertThrows(IndexOutOfBoundsException.class, () -> integerListWithThreeElements.add(null, 4));

    }

    @Test
    public void testRemove() {
        integerListWithThreeElements.remove(1);
        //then
        assertEquals(2, integerListWithThreeElements.size());
        assertEquals(2, integerListWithThreeElements.get(1));
    }

    @Test
    public void testRemoveOnIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> integerListWithThreeElements.remove(3));

    }

    @Test
    public void testRemoveOnintegeremptyIntegerList() {
        assertThrows(IndexOutOfBoundsException.class, () -> emptyIntegerList.remove(0));
    }

    @Test
    public void testClear() {

        //when
        integerListWithThreeElements.clear();
        integerListWithOneElement.clear();
        //then
        assertEquals(0, integerListWithThreeElements.size());
        assertEquals(0, integerListWithOneElement.size());
        assertTrue(integerListWithThreeElements.isEmpty());
        assertTrue(integerListWithOneElement.isEmpty());
    }

    @Test
    public void testContains() {
        //then
        assertTrue(integerListWithThreeElements.contains(1));
        assertFalse(integerListWithThreeElements.contains(-1));
    }

    @Test
    public void testContainsOnintegerListWithOneElement() {
        //then
        assertTrue(integerListWithOneElement.contains(1));
        assertFalse(integerListWithOneElement.contains(-1));
    }

    @Test
    public void testIndexOf() {
        integerListWithThreeElements.set(1, 2);
        //then
        assertEquals(0, integerListWithThreeElements.indexOf(0));
        assertEquals(1, integerListWithThreeElements.indexOf(1));
        assertEquals(0, integerListWithOneElement.indexOf(1));
    }

    @Test
    public void testLastIndexOf() {
        //when
        integerListWithThreeElements.set(0, 2);
        assertEquals(2, integerListWithThreeElements.lastIndexOf(0));
        assertEquals(1, integerListWithThreeElements.lastIndexOf(1));
        assertEquals(0, integerListWithOneElement.lastIndexOf(1));
    }

    @Test
    public void testToString() {
        assertEquals("[0, 1, 2]", integerListWithThreeElements.toString());
        assertEquals("[1]", integerListWithOneElement.toString());
        assertEquals("[]", emptyIntegerList.toString());

    }

    @Test
    public void testManualConstructorVulnerability() {
        integerListWithThreeElements = new ArrayList<>(3);
        assertEquals(0, integerListWithThreeElements.size());
    }

    @Test
    public void testDefaultConstructorVulnerability() {
        integerListWithThreeElements = new ArrayList<>();
        assertEquals(0, integerListWithThreeElements.size());
    }

    @Test
    public void testIteratorOnIntegerList(){
        Iterator<Integer> iterator = integerListWithThreeElements.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(0, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertFalse(iterator.hasNext());

    }

    @Test
    public void testIteratorOnEmptyIntegerList(){
        Iterator<Integer> iterator = emptyIntegerList.iterator();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void test

}
