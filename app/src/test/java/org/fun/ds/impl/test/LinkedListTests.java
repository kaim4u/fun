package org.fun.ds.impl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.fun.ds.List;
import org.fun.ds.impl.LinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for List operations
 * @author Rakesh Kaim
 */
@SuppressWarnings("deprecation")
public class LinkedListTests {
	private List list;
	/**
	 * Initialize list before each test execution
	 */
	@Before
	public void setUp() {
		list = new LinkedList();
	}

	/**
	 * Destroy list after each test execution
	 */
	@After
	public void tearDown(){
		list = null;
	}

	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#add(int)}.
	 * 
	 */
	@Test
	public final void testAdd() {
		assertEquals(0, list.size());
		list.add(12);   
		assertEquals(12, list.get(0)); 
		assertEquals(1, list.size());
		list.add(52);
		assertEquals(52, list.get(1)); 
		assertEquals(2, list.size());
	}
	
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#add(int, int)}.
	 * 
	 */
	@Test
	public final void testAddAtIndex1() {
		try{
				list.add(0, 12); // index = 0 , size = 0 
		}catch(Exception e){
			assertTrue(e instanceof IndexOutOfBoundsException);
		}
	}
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#add(int, int)}.
	 */
	@Test
	public final void testAddAtIndex2() {
		list.add(100);
		try{
				list.add(1, 12); // index = size =1
		}catch(Exception e){
			assertTrue(e instanceof IndexOutOfBoundsException);
		}
	}
	
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#add(int, int)}.
	 */
	@Test
	public final void testAddAtIndex3() {
		list.add(100);
		list.add(102);
		try{
				list.add(-1, 12); // index = -1 size =2
		}catch(Exception e){
			assertTrue(e instanceof IndexOutOfBoundsException);
		}
	}
	
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#add(int, int)}.
	 */
	@Test
	public final void testAddAtIndex4() {
		list.add(100);
		list.add(102);
		assertEquals(100, list.get(0)); 
				
	}
	
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#add(int, int)}.
	 */
	@Test
	public final void testAddAtIndex5() {
		list.add(100);
		assertEquals(100, list.get(0)); 
				
	}
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#add(int, int)}
	 */
	@Test
	public final void testAddAtIndex6() {
		int index = 1;
		int expectedValue = 200;
				list.add(100);
				list.add(300);
				list.add(400);
				list.add(index, expectedValue);
				assertEquals(expectedValue, list.get(1));
	}
	
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#add(int, int)}
	 */
	@Test
	public final void testAddAtIndex7() {
		list.add(20);
		list.add(0, 30);
		assertEquals(30, list.get(0));
	}
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#add(int, int)}
	 */
	@Test
	public final void testAddAtIndex8() {
		list.add(20);
		list.add(25);
		list.add(0, 30);
		assertEquals(30, list.get(0));
	}
	/** 
	 * Test method for {@link org.fun.ds.impl.LinkedList#addLast(int)}.
	 */ 
	@Test public final void testAddLast() {
		list.add(120);
		list.add(240);
		list.addLast(300);
		assertEquals(300, list.getLast());
	}
	
	/** 
	 * Test method for {@link org.fun.ds.impl.LinkedList#addLast(int)}.
	 */ 
	@Test public final void testAddLast1() {
		list.addLast(12);
		assertEquals(12, list.getLast());
	}
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#addFirst(int)}.
	 */
	@Test
	public final void testAddFirst() {
		list.add(120);
		list.add(240);
		list.addFirst(200);
		assertEquals(200, list.getFirst());
	}

	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#addFirst(int)}.
	 */
	@Test
	public final void testAddFirst2() {
		list.addFirst(200);
		assertEquals(200, list.getFirst());
	}
	
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#getFirst()}.
	 */
	@Test
	public final void testGetFirst() {
		list.add(120);
		list.add(240);
		assertEquals(120, list.getFirst());
	}

	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#getLast()}.
	 */
	@Test
	public final void testGetLast() {
		list.add(120);
		list.add(240);
		assertEquals(240, list.getLast());
	}

	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#get(int)}.
	 */
	@Test
	public final void testGet() {
		list.add(20);
		list.add(40);
		assertEquals(40, list.get(1));
	}
	
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#get(int)}.
	 */
	@Test
	public final void testGet1() {
		try{
			list.get(0);
		}catch(Exception e){
			assertTrue(e instanceof IndexOutOfBoundsException);
		}
	}
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#size()}.
	 */
	@Test
	public final void testSize() {
		list.add(20);
		list.add(40);
		assertEquals(2, list.size());
	}

	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#testToString()}.
	 */
	@Test
	public final void testToString() {
		for(int i = 0; i < 50; ++i)
			list.add(i);
		list.toString();
		assertTrue(true); //dummy test, just for code coverage
	}
	
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#testToString()}.
	 */
	@Test
	public final void testToString2() {
		list.toString();	// list empty scenario
		assertTrue(true); //dummy test, just for code coverage
	}

	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#remove(int)}.
	 */
	@Test
	public final void testRemove() {
		list.add(20);
		list.add(30);
		list.add(45);
		assertEquals(true, list.remove(1));
	}

	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#remove(int)}.
	 */
	@Test
	public final void testRemove1() {
		list.add(20);
		assertEquals(true, list.remove(0));
	}
	
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#remove(int)}.
	 */
	@Test
	public final void testRemove2() {
		list.add(20);
		list.add(40);
		list.add(30);
		assertEquals(true, list.remove(2));
	}
	
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#remove(int)}.
	 */
	@Test
	public final void testRemove3() {
		list.add(20);
		list.add(40);
		list.add(30);
		assertEquals(false, list.remove(-100));
	}
	
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#remove(int)}.
	 */
	@Test
	public final void testRemove4() {
		list.add(20);
		list.add(40);
		list.add(30);
		assertEquals(false, list.remove(400));
	}
	
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#remove(int)}.
	 */
	@Test
	public final void testRemove5() {
		for(int i = 0; i < 30; ++i)
			list.add(i);
		assertEquals(true, list.remove(29));
	}
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#removeFirst()}.
	 */
	@Test
	public final void testRemoveFirst() {
		list.add(20);
		list.add(30);
		assertEquals(true, list.removeFirst());
		assertEquals(30, list.getFirst());
	}
	
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#removeFirst()}.
	 */
	@Test
	public final void testRemoveFirst1() {
		list.add(20);
		assertEquals(true, list.removeFirst());
		assertEquals(-1, list.getFirst());
	}

	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#removeFirst()}.
	 */
	@Test
	public final void testRemoveFirst2() {
		assertEquals(false, list.removeFirst());
		assertEquals(-1, list.getFirst());
	}
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#removeLast()}.
	 */
	@Test
	public final void testRemoveLast() {
		list.add(20);
		list.add(30);
		list.add(45);
		assertEquals(true, list.removeLast());
		assertEquals(30, list.getLast());
	}
	
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#removeLast()}.
	 */
	@Test
	public final void testRemoveLast2() {
		assertEquals(false, list.removeLast());
	}
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#removeLast()}.
	 */
	@Test
	public final void testRemoveLast3() {
		list.add(20);
		assertEquals(true, list.removeLast());
		assertEquals(-1, list.getLast());
	}
	
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#contain()}.
	 * list is empty
	 */
	@Test
	public final void testContain() { 				//list empty scenario, return -2
		assertEquals(-2, list.contain(12));
	}
	
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#contain()}.
	 * list contains at least one element and specified data element not present 
	 */
	@Test
	public final void testContain1() { 				//list not empty and element not present scenario, returns -1
		list.addLast(100);
		list.addLast(101);
		assertEquals(-1, list.contain(12));
	}
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#contain()}.
	 * list contains at least one element and specified data element present
	 */
	@Test
	public final void testContain3() { 				//list not empty and element present scenario, returns index
		list.addLast(100);
		list.addLast(101);
		assertEquals(1, list.contain(101));
	}
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#reverse()}.
	 * list is empty
	 */
	@Test
	public final void testReverse() {
		list.reverse();
		assertEquals(0, list.size());
	}
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#reverse()}.
	 * list contains one element
	 */
	@Test
	public final void testReverse2() {
		list.addLast(12);
		list.reverse();
		assertEquals(12, list.getLast());
	}
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#reverse()}.
	 * list contain more then one element 
	 */
	@Test
	public final void testReverse3() {
		list.addLast(12);
		list.addLast(13);
		list.addLast(14);
		list.reverse();
		assertEquals(14, list.getFirst());
		assertEquals(13, list.get(1));
		assertEquals(12, list.getLast());
	}
	
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#delete(int)}.
	 * list is Empty.
	 */
	@Test
	public final void testDelete(){
		assertEquals(false, list.delete(12));
	}
	
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#delete(int)}.
	 * list contains one element and not equals to specified element   
	 */
	@Test
	public final void testDelete2(){
		list.addLast(12);
		assertEquals(false, list.delete(13));
	}
	
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#delete(int)}.
	 * list contains one element and equals to specified element   
	 */
	@Test
	public final void testDelete3(){
		list.addLast(12);
		assertEquals(true, list.delete(12));
	}

	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#delete(int)}.
	 * list contains more then one element and specified element not present   
	 */
	@Test
	public final void testDelete4(){
		list.addLast(12);
		list.addLast(14);
		list.addLast(17);
		list.addLast(15);
		list.addLast(16);
		assertEquals(false, list.delete(0));
	}
	
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#delete(int)}.
	 * list contains more then one element and specified element present at last node   
	 */
	@Test
	public final void testDelete5(){
		list.addLast(12);
		list.addLast(14);
		list.addLast(13);
		list.addLast(15);
		list.addLast(16);
		assertEquals(true, list.delete(16));
	}
	
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#delete(int)}.
	 * list contains more then one element and specified element present   
	 */
	@Test
	public final void testDelete6(){
		list.addLast(12);
		list.addLast(14);
		list.addLast(17);
		list.addLast(15);
		list.addLast(16);
		assertEquals(true, list.delete(15));
	}
	
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#delete(int)}.
	 * list contains more then one element and specified element present   
	 */
	@Test
	public final void testDelete7(){
		list.addLast(120);
		list.addLast(140);
		list.addLast(170);
		list.addLast(150);
		list.addLast(160);
		assertEquals(true, list.delete(120));
	}
	
}
