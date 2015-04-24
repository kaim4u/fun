package org.fun.ds.impl;

import org.fun.ds.List;
/**
 *  Singly linked list ADT implementation.
 * 
 * @author Rakesh Kaim
 * @version 0.1
 */
public class LinkedList implements List {
	/**
	 * 	Represents the first element in this List.
	 */
	private Node first;
	/**
	 * 	Represents the last element in this List.
	 */
	private Node last;
	/**
	 * 	Represents the number of elements in this list 
	 * 	and size = 0, value
	 * 	indicate that this list is empty.
	 */
	private int size;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.fun.ds.List#add(int)
	 * 
	 * @since version 0.1
	 */
	@Deprecated public boolean add(final int data) {
		boolean isAdded = false;
		if (first == null) {								// list's empty
			last = first = new Node(data);					// create new node and make first and last point to it
			isAdded = true;									// update flag to true		
			++size;											// update size
		} else {											// list's not empty
			Node p = null;										
			for (p = first; p.next != null; p = p.next)		// traverse the list till last
				;
			last = p.next = new Node(data);					// create new node and make last point to it and update last
			isAdded = true;									// update flag to true
			++size;											// update size
		}
		return isAdded;										//return flag
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.fun.ds.List#add(int, int)
	 * 
	 * @since version 0.1
	 */
	public void add(final int index, final int data) {
		if (!isElementExist(index)) 						// index not exist, throw exception
			throw new IndexOutOfBoundsException
			("size = "
					+ size + ", index = " + index);
		if (first == last || index == 0)					// index point to first node
			 addFirst(data);								// add first, i.e before the current first
		else { 												// list size > 1, more than one element
			Node elementBeforeIndex 
				= getElement(index - 1);					// get reference of element just before the index element 
			elementBeforeIndex.next 
				= new Node(elementBeforeIndex.next, data);	// create new node pointing to current index node and make the
			++size;											// before index node pointing to this node and update size	
		}
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.fun.ds.List#addLast(int)
	 * 
	 * @since version 0.1
	 */
	public void addLast(final int data) {
		if (last != null)									// last exist
			last = last.next = new Node(data);				// create node and make last point to it and update last
		else												// last not exist
			last = first = new Node(data);					// create node and make last and first point to it.
		++size;												// update size
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.fun.ds.List#addFirst(int)
	 * 
	 * @since version 0.1
	 */
	public void addFirst(int data) {									
		if (first != null) {								// first exist	
			Node p = new Node(data);						// create node and make its next point to current first and update first
			p.next = first;
			first = p;
		} else												// first not exist
			last = first = new Node(data);					// create node and make first and last point to it
		++size;												// update size
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.fun.ds.List#getFirst()
	 * 
	 * @since version 0.1
	 */
	public int getFirst() {
		return first != null ? first.data : -1;				// return -1 if first not exist otherwise return first data
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.fun.ds.List#getLast()
	 * 
	 * @since version 0.1
	 */
	public int getLast() {
		return last != null ? last.data : -1;				// return -1 if last not exist otherwise return last data
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.fun.ds.List#get(int)
	 * 
	 * @since version 0.1
	 */
	public int get(final int index){
		if (!isElementExist(index))							// index not exist, throw exception
			throw new IndexOutOfBoundsException
			("Size of this list = " 					
					+ size + " and given Index = " + index);
		int i = 0;																		
		Node p = first;																	
		while (i++ < index) 								// traverse list till index, make ith node point to index node 
			p = p.next;
		return p.data;										// return index data
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.fun.ds.List#size()
	 */
	public int size() {
		return size; 										//return current size
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.fun.ds.List#remove(int)
	 */
	public boolean remove(int index) {
		if (isElementExist(index)) { 						// Index exist
			if (index == 0) 								// Index at position 0, pointing to first
				return removeFirst();						// first removed, return true 
			else if (index == size - 1) 					// Index positioned at the end
				return removeLast();						// last removed, return true
			else {											// Index position some where in middle
				Node elementBeforeIndex 
					= getElement(index - 1);            	// getting element just before the index 
				elementBeforeIndex.next 
					= elementBeforeIndex.next.next;     	// element after index = elementBeforeIndex.next.next
				--size;										// update size
				return true;								// Index element removed, return true
			}
		} else
			return false; 									// Index not exist, return false
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.fun.ds.List#removeFirst()
	 */
	public boolean removeFirst() {
		boolean isRemoved = false;
		if (isFirstExist()){ 								// first exist
			if (first == last) { 							// first and last point to same node, i.e list has only one node.  
				last = first = null; 						// nullify last and first
				--size; 									// updating size
				return isRemoved = true; 					// first removed
			} else { 										// first exist and list has more than one node.
				Node afterNext = first.next; 				// get reference of next to first
				first = null; 								// nullify first, to avoid dead store
				first = afterNext; 							// update first with new first
				--size; 									// update size
				return isRemoved = true; 					// first removed
			} 
		}else return isRemoved; 							// first not exist, list's empty
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.fun.ds.List#lastLast()
	 */
	public boolean removeLast() {
		if (isLastExist()){ 								// last exist
			if (last == first) { 							// list contain only one element 
				last = first = null;  						// nullify last and first node
				--size;          							// update size 
				return true; 								// last removed, return true
			} else { 
				Node p = first;
				while (last != p.next) 						// traverse the list just before the last
					p = p.next; 
				p.next = null;         						// nullify last node
				last = null;                                // nullify this last, to avoid dead store
				last = p;              						// updating last
				--size;                						// update size
				return true; 								// last removed, return true
			}
		}else return false; 								// last not exist,list's empty, return false
	}
	
	/* (non-Javadoc)
	 * @see org.fun.ds.List#contain(int)
	 */
	public int contain(int data) {
		int i = -2;											
		if(isListEmpty())									// list's empty, implies element not present
			return i;										// return -2, indicate list is empty
		else{												// list's not empty, start search element
			Node p = first;
			i=0;											// make index point to 0th element
			while(p != null){								// traverse this list till end
				if(p.data == data)							// check current element value with given value
					return i;								// element found, return ith index;
				else{
					p = p.next;								// element not found move to next element and increment index
					++i;
				}
			}
			i = -1;											// element not found and not return -1
		}
		return i;											// return ith index if element found else -1 	
	}
	
	/* (non-Javadoc)
	 * @see org.fun.ds.List#delete(int)
	 */
	public boolean delete(int data) {
		if(!isListEmpty()){									    // list's empty Check
			if(size == 1){									    // list contain one element
				if(first.data == data){							// element match found at first position
					first = last = null;						// delete first and update last and first to null
					--size;										// update size
					return true;								// return true element match found
				}else
					return false;								// return false element mismatch found
			}
			else{												// list's not empty and must contains at least one element 
				Node p = first;
				if(p.data == data){								// element match found at first position
					first = null;                               // make first point to null, to avoid dead store
					first = p.next;								// update first, make first point to node next to first
					--size;										// update size	
					return true;								// return true, match found at first position
				}
					
				while(p.next != null){							// traverse this list till just before last element 
					if(p.next.data == data){					// next to current element match found
						if(p.next.next == null){				// next to current element is last element
							last = null;
							p.next = null;						// make current point to null and update last
							last = p;							// update last
							--size;								// update size
							return true;						// return true, element found at last position
						}
						else {									// element found at next to current position
								p.next = p.next.next;			// make current node point to next to next
								--size;							// update size
								return true;					// return true, element match found somewhere in between last and first
						}
					}											
					p = p.next;									// jump to next node, No match found in current iteration 
				}
			}
		}
		return false;								           // return false, list is empty 
	}

	/* (non-Javadoc)
	 * @see org.fun.ds.List#reverse()
	 */
	@Deprecated public void reverse() {
		reverseRecursively(first);
		Node temp = last; 
		last = first;											// swap last and first
		first = temp;											
	}

	/* (non-Javadoc)
	 * @see org.fun.ds.List#rotate()
	 */
	@Override
	public void rotate() {
		reverseNonRecursively(first);
		Node temp = last; 
		last = first;											// swap last and first
		first = temp;
	}
	
	/**
	 * Reverse this list recursively
	 * @param the current node. 
	 */
	private void reverseNonRecursively(Node node) {
		Node movingNode = null;
		Node reverseList = null;
		while(node != null){
			movingNode = node.next;
			node.next = reverseList;
			reverseList = node;
			node = movingNode;
		}
	}
	
	/**
	 * Reverse this list recursively
	 * @param the current node. 
	 */
	private void reverseRecursively(Node node) {
		if(node == null) return;							   // list empty, return
		if(node.next == null) return;						   // base condition, reached last node, recursion end here 
		else reverseRecursively(node.next);					   // somewhere in between last and first, 
		node.next.next = node;		   						   // make node point to null should point to current node in each stack frame
		node.next = null;									   // make current node point to null, in this stack frame
	}
	
	/**
	 *  Returns element Node of index position provided index exist 
	 * 
	 * @param index
	 *            the position at which element to be access
	 * @return {@code Node} returns the element reference at index position.
	 */
	private Node getElement(final int index) {
		int i = 0;
		Node p = first;
		while (i++ < index) 									// traverse list till index, make ith node point to index node
			p = p.next;
		return p;												// Returns index node
	}

	/**
	 *  This method return true if index lies between 0 and size-1 otherwise
	 *  false provided list is not empty otherwise false
	 * 
	 * @param index
	 *            the element index to check
	 * @return if element exist at index return true otherwise false
	 */
	private boolean isElementExist(int index) {
		if(isListEmpty())
			return false;										// list is empty, return false  
		return index >= 0 && index < size;						// else return true if index lies between 0 and current size-1 else false 	
	}

	/**
	 *  Check whether this first exist or not
	 * 
	 * @return true if this first exist otherwise false
	 */
	private boolean isFirstExist() {
		return first != null; 									// check first exist ?
	}

	/**
	 *  Check whether this last exist or not
	 * 
	 * @return true if this last exist otherwise false
	 */
	private boolean isLastExist() {
		return last != null; 									// check last exist ?
	}
	
	/**
	 *  Check whether this list is empty
	 * 
	 * @return true if this list is empty otherwise false
	 */
	private boolean isListEmpty(){
		return size == 0;
	}
	
	/**
	 *  Inner class to represent a self reference Object called Node.
	 */
	private class Node {
		/**
		 *  the data value for this node.
		 */
		private int data;
		/**
		 *  the next node after this node.
		 */
		private Node next;

		/**
		 *  Use this constructor when appending or prepending node to this node.
		 * 
		 * @param data
		 *            the data value for this node
		 */
		Node(int data) {
			this.data = data;
		}

		/**
		 *  Use this constructor when adding node in between the list.
		 * 
		 * @param next
		 *            the next node after this node
		 * @param data
		 *            the data value for this node
		 */
		Node(Node next, int data) {
			this.data = data; 
			this.next = next; 
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		Node p = first;
		if(first == null)
			return sb.append("]").toString();
		int i =1;
		while (p != null) {
			if (p.next == null)
				sb.append((p.data)).append(" ] Size = " + size);
			else
				sb.append(p.data).append(", ");
			p = p.next;
			if((i++ % 25) == 0)
				sb.append("\n");
		}
		return sb.toString();
	}
	
	/* (non-Javadoc)
	 * @see org.fun.ds.List#showList()
	 */
	public  void showList() {
		System.out.print("[ ");
		Node p = first;
		if(first == null){
			System.out.println(" ] Size = " + size + ", List's Empty");
			return;
		}
		int i =1;
		while (p != null) {
			if (p.next == null){
				System.out.print(p.data);
				System.out.println(" ] Size = " + size);
			}
			else{
				System.out.print(p.data);
				System.out.print(", ");
			}
			p = p.next;
			if((i++ % 25) == 0)
				System.out.println();
		}
		return;
	}
}
