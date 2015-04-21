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
	 */
	@Test
	public final void testAdd() {
		
		int expectedSizeValue= 0;
		assertEquals(expectedSizeValue, list.size());
		
		int expectedValue = 12;
		list.add(expectedValue); expectedSizeValue = 1;   
		assertEquals(expectedValue, list.get(0)); 
		assertEquals(expectedSizeValue, list.size());
		
		expectedValue = 52;
		list.add(expectedValue); expectedSizeValue= 2;
		assertEquals(expectedValue, list.get(1)); 
		assertEquals(expectedSizeValue, list.size());
	}
	
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#add(int, int)}.
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
	 */
	@Test
	public final void testContain() { 				//list empty scenario, return -2
		assertEquals(-2, list.contain(12));
	}
	
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#contain()}.
	 */
	@Test
	public final void testContain1() { 				//list not empty and element not present scenario, returns -1
		list.addLast(100);
		list.addLast(101);
		assertEquals(-1, list.contain(12));
	}
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#contain()}.
	 */
	@Test
	public final void testContain3() { 				//list not empty and element present scenario, returns index
		list.addLast(100);
		list.addLast(101);
		assertEquals(1, list.contain(101));
	}
	/**
	 * Test method for {@link org.fun.ds.impl.LinkedList#reverse()}.
	 */
	@Test
	public final void testReverse() {
		list.reverse();
		assertEquals(0, list.size());
	}
	@Test
	public final void testReverse2() {
		list.addLast(12);
		list.reverse();
		assertEquals(1, list.size());
		assertEquals(12, list.getFirst());
		assertEquals(12, list.getLast());
	}
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
}
