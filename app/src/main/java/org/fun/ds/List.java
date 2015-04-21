package org.fun.ds;

/**
 * Interface to describe singly-linked list operations.
 * 
 * @author Rakesh Kaim
 * @version 0.1
 */
public interface List {
	/**
	 * Appends the specified element to the end of this list. and returns true
	 * if elements added successfully otherwise false
	 * 
	 * @deprecated Replaced by {@link #addLast(int )}
	 * 
	 * @param data
	 *            the element value.
	 * @return boolean the add operation status to be return.
	 */
	boolean add(final int data);

	/**
	 * Inserts the specified element at the specified position in this list.
	 * 
	 * @param index
	 *            the position at which element to be add.
	 * @param data
	 *            the element value
	 * @throws {@code IndexOutOfBoundsException} if index element does not exist
	 */
	void add(final int index, final int data) throws IndexOutOfBoundsException;

	/**
	 * Inserts the specified element at the beginning of this list.
	 * 
	 * @param data
	 *            the element value to add.
	 */
	void addFirst(final int data);

	/**
	 * Appends the specified element to the end of this list.
	 * 
	 * @param data
	 *            the element value to add.
	 */
	void addLast(final int data);

	/**
	 * Returns the number of elements in this list.
	 * 
	 * @return return this (@code size}.
	 */
	int size();

	/**
	 * Returns the element value at the specified position in this list if exist
	 * otherwise throws {@link IndexOutOfBoundsException}.
	 * 
	 * @param index
	 *            the position at which element to be access.
	 * @return the element value.
	 * @throws {@link IndexOutOfBoundsException}
	 *             if this index lies between index < 0 and index >= size
	 */
	int get(final int index) throws IndexOutOfBoundsException;

	/**
	 * This method returns head element present at index = 0 if exist otherwise
	 * return -1;
	 *
	 * @return return this {@code first} if exist otherwise -1.
	 */
	int getFirst();

	/**
	 * This method returns last element of this list if exist otherwise return
	 * -1;
	 * 
	 * @return the element at size -1 position if exist.
	 */
	int getLast();

	/**
	 * Remove specified element at the specified position in this list if exist
	 * otherwise throws {@link IndexOutOfBoundsException}
	 * 
	 * @param index
	 *            the position at which element to be remove.
	 * @throws throws {@link IndexOutOfBoundsException} if index not exist.
	 */
	boolean remove(final int index) throws IndexOutOfBoundsException;

	/**
	 * Remove the element at the beginning of this list.
	 * 
	 * @return true if this {@code first} removed successfully otherwise false.
	 */
	boolean removeFirst();

	/**
	 * Remove the element to the end of this list.
	 * 
	 * @return true if this {@code last} removed successfully otherwise false.
	 */
	boolean removeLast();
	/**
	 * Search an element in this list and return its first occurrence position 
	 * if exist and if not -1 otherwise -2 if list is empty. 
	 * @param data to be search in this list.
	 * @return returns -1 if element not exist, 
	 * 		   returns -2 if list's empty 
	 * 		   else return index of first occurrence.
	 */
	int contain(int data);
	
	/**
	 * Reverse this list  
	 */
	void reverse();
	
	/**
	 * Remove first occurrence of element specified by its value if exist.  
	 * 
	 * @param data
	 *            the specified element value.
	 * @return    returns true if element exist with same value otherwise false
	 */
	boolean delete(final int data);
}
