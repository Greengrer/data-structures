package com.bilous.datastructures.list;

import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;

import static org.junit.Assert.*;

public abstract class AbstractListTest {

    List<Object> emptyList;
    List<Object> listWithThreeElements;
    List<Object> ListWithOneElement;

    @Before
    public void before() {
        emptyList = getList();
        listWithThreeElements = getList();
        ListWithOneElement = getList();

        for (int i = 0; i < 3; i++) {
            listWithThreeElements.add(i);
        }

        ListWithOneElement.add(1);
    }

    abstract List<Object> getList();


    @Test
    public void testAddAndGet() {

        for (int i = 0; i < 3; i++) {
            assertEquals(i, listWithThreeElements.get(i));
        }

        assertEquals(1, ListWithOneElement.get(0));
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
        assertEquals(0, listWithThreeElements.set(3, 0));
        assertEquals(1, listWithThreeElements.set(4, 1));
        assertEquals(2, listWithThreeElements.set(5, 2));
        assertEquals(1, ListWithOneElement.set(2, 0));
        //then
        assertEquals(3, listWithThreeElements.get(0));
        assertEquals(4, listWithThreeElements.get(1));
        assertEquals(5, listWithThreeElements.get(2));
        assertEquals(2, ListWithOneElement.get(0));
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
        assertEquals(1, ListWithOneElement.size());
        assertEquals(0, emptyList.size());
    }

    @Test
    public void testIsEmpty() {
        //then
        assertFalse(listWithThreeElements.isEmpty());
        assertFalse(ListWithOneElement.isEmpty());
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
        ListWithOneElement.clear();
        //then
        assertEquals(0, listWithThreeElements.size());
        assertEquals(0, ListWithOneElement.size());
        assertTrue(listWithThreeElements.isEmpty());
        assertTrue(ListWithOneElement.isEmpty());
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
        assertTrue(ListWithOneElement.contains(1));
        assertFalse(ListWithOneElement.contains(-1));
    }

    @Test
    public void testIndexOf() {
        listWithThreeElements.set(1, 2);
        //then
        assertEquals(0, listWithThreeElements.indexOf(0));
        assertEquals(1, listWithThreeElements.indexOf(1));
        assertEquals(0, ListWithOneElement.indexOf(1));
    }

    @Test
    public void testLastIndexOf() {
        //when
        listWithThreeElements.set(0, 2);
        assertEquals(2, listWithThreeElements.lastIndexOf(0));
        assertEquals(1, listWithThreeElements.lastIndexOf(1));
        assertEquals(0, ListWithOneElement.lastIndexOf(1));
    }

    @Test
    public void testToString() {
        assertEquals("[0, 1, 2]", listWithThreeElements.toString());
        assertEquals("[1]", ListWithOneElement.toString());
        assertEquals("[]", emptyList.toString());

    }

    @Test
    public void testManualConstructorVulnerability() {
        listWithThreeElements = new ArrayList<>(3);
        assertEquals(0, listWithThreeElements.size());
    }

    @Test
    public void testDefaultConstructorVulnerability() {
        listWithThreeElements = new ArrayList<>();
        assertEquals(0, listWithThreeElements.size());
    }

    @Test
    public void testIteratorOnList(){
        Iterator<Object> iterator = listWithThreeElements.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(0, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertFalse(iterator.hasNext());

    }

    @Test
    public void testIteratorOnEmptyList(){
        Iterator<Object> iterator = emptyList.iterator();
        assertFalse(iterator.hasNext());
    }

//    @Test
  //  public void testIteratorRemoveOnEmptyList(){
    //    Iterator<Object> iterator = emptyList.iterator();

    //}

   // @Test
    //public void testIteratorRemoveOnEmptyList(){
      //  Iterator<Object> iterator = emptyList.iterator();

    //}


}
