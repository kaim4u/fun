package org.fun.ds.helper;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.fun.ds.List;
import org.fun.ds.impl.LinkedList;
import static org.fun.ds.helper.ApplicationMessages.*;

/**
 * Helper class for {@link org.fun.app.ListApp}
 * 
 * @author Rakesh Kaim
 */
public class ListProxy {

	/*
	 * (non-Javadoc) Initializing new empty list
	 */
	private List list = new LinkedList();

	/*
	 * (non-Javadoc) Initializing new input reader
	 */
	private Scanner scanner = new Scanner(System.in);

	/*
	 * (non-Javadoc) Construct this helper class and populate list with
	 * specified capacity
	 */
	public ListProxy(int capacity) {
		for (int i = 0; i <= capacity; ++i) {
			list.addLast(i);
		}
		appHeader();
	}

	/*
	 * (non-Javadoc) Handle user request to add an element at last position
	 */
	void addLast() {
		print(INPUT_NUMBER);
		int data = getInput();
		list.addLast(data);
		print(ADD_SUCCESS);
	}

	/*
	 * (non-Javadoc) Handle user request to add element at first position
	 */
	void addFirst() {
		print(INPUT_NUMBER);
		int data = getInput();
		list.addFirst(data);
		print(ADD_SUCCESS);
	}

	/*
	 * (non-Javadoc) Handle user request to insert an element at specified
	 * position
	 */
	void add() {
		if (list.size() == 0) {
			print(LIST_EMPTY);
			return;
		}
		print(INPUT_NUMBER);
		int data = getInput();
		print(INPUT_POSITION);
		int i = getInput();
		while (i >= list.size()) {
			println(INVALID_POSITION + (list.size() - 1));
			print(INPUT_POSITION);
			i = getInput();
		}
		list.add(i, data);
		System.out.print(ADD_SUCCESS);
	}

	/*
	 * (non-Javadoc) Handle user request to remove last element
	 */
	void removeLast() {
		if (list.size() == 0) {
			print(LIST_EMPTY);
			return;
		}
		list.removeLast();
		print(LAST_SUCCESS);
	}

	/*
	 * (non-Javadoc) Handle user request to remove first element
	 */
	void removeFirst() {
		if (list.size() == 0) {
			print(LIST_EMPTY);
			return;
		}
		list.removeFirst();
		print(FIRST_SUCCESS);
	}

	/*
	 * (non-Javadoc) Handle user request to remove an element at specified
	 * position
	 */
	void remove() {
		int size = list.size();
		if (size == 0) {
			print(LIST_EMPTY);
			return;
		}
		print(INPUT_POSITION);
		int i = getInput();
		while (i >= size) {
			println(INVALID_POSITION + (size - 1));
			print(INPUT_POSITION);
			i = getInput();
		}
		list.remove(i);
		print(REMOVE_SUCCESS);
	}

	/*
	 * (non-Javadoc) Handle user request to check whether the specified data
	 * value present in the list or not
	 */
	void search() {
		if (list.size() == 0) {
			println(LIST_EMPTY);
			return;
		}
		print(INPUT_NUMBER);
		int data = getInput();
		int i = list.contain(data);
		if (i == -1)
			println(NOT_FOUND);
		else
			println(FOUND + i);
	}

	/*
	 * (non-Javadoc) Handle user request to reverse the list
	 */
	void reverse() {
		list.reverse();
	}

	/*
	 * (non-Javadoc) Handle user request to create new list of specified size
	 */
	void addBulk() {
		int size = 0;
		while (true) {
			print(INPUT_SIZE);
			size = getInput();
			if (isValidRange(size)) {
				list = null;
				list = new LinkedList();
				for (int i = 0; i < size; ++i)
					list.addLast(i);
				break;
			} else {
				println(INVALID_RANGE);
			}
		}

	}

	/*
	 * (non-Javadoc) Handle user request to create new empty list
	 */
	private void createEmptyList() {
		list = null;
		list = new LinkedList();
	}

	/*
	 * (non-Javadoc) Handle user request to delete element with specified value
	 */
	private void delete() {
		if (list.size() == 0) {
			println(LIST_EMPTY);
			return;
		}
		print(INPUT_NUMBER);
		int data = getInput();
		if (list.delete(data))
			println(REMOVE_SUCCESS);
		else
			print(REMOVE_FAIL);
	}

	/*
	 * (non-Javadoc) Handle normal exit when user enter exit number
	 */
	void normalExit() {
		println(NORMAL_EXIT);
		close();
		System.exit(NORMAL_EXIT_SIGNAL);
	}

	/*
	 * (non-Javadoc) Exception handling block in case user enter input other
	 * than integer
	 */
	void abnormalExit() {
		println(NOT_VALID_INPUT);
		close();
		System.exit(ABNORMAL_EXIT_SIGNAL);
	}

	/*
	 * (non-Javadoc) Write message for invalid menu range
	 */
	void invalidMenuRangeMessage() {
		println(INVALID_MENU_RANGE);
	}

	/*
	 * (non-Javadoc) Write message for menu choice
	 */
	void enterChoiceMessage() {
		print(INPUT_CHOICE);
	}

	/*
	 * (non-Javadoc) Validate list size while creating pre-populated list
	 * 
	 * @param size the of new list
	 * 
	 * @return true if the specified number lies between the list size range
	 * inclusively
	 */
	boolean isValidRange(final int size) {
		return size >= MIN_RANGE && size <= MAX_RANGE;
	}

	/*
	 * (non-Javadoc) Validate user menu choice
	 * 
	 * @param choice
	 * 
	 * @return true if the specified choice lies between the menu range
	 * inclusively
	 */
	boolean isValidChoice(final int choice) {
		return choice >= MENU_MIN_RANGE && choice <= MENU_MAX_RANGE;
	}

	/*
	 * (non-Javadoc) Read user input
	 * 
	 * @return returns user input if user enter valid input otherwise exit from
	 * the current session.
	 */
	int getInput() {
		int in = 0;
		try {
			in = scanner.nextInt();
		} catch (InputMismatchException ex) {
			abnormalExit();
		}
		return in;
	}

	/*
	 * (non-Javadoc) Close standard input stream
	 */
	private void close() {
		scanner.close();
	}

	/*
	 * (non-Javadoc) Print current state of the list
	 */
	void showList() {
		println(list.toString());
	}

	/*
	 * (non-Javadoc) Print menu header
	 */
	void menuHeader() {
		println(MENU_HEADER);
	}

	/*
	 * (non-Javadoc) Print menu
	 */
	void menu() {
		println(MENU1);
		println(MENU2);
		println(MENU3);
		println(MENU4);
		println(MENU5);
		println(MENU6);
		println(MENU7);
		println(MENU8);
		println(MENU9);
		println(MENU10);
		println(MENU11);
		println(MENU12);
	}

	/*
	 * (non-Javadoc) Build menu and render the view
	 */
	void renderView() {
		menuHeader();
		showList();
		menu();
	}

	/*
	 * (non-Javadoc) Print application header
	 */
	void appHeader() {
		println(APP_HEADER);

	}

	/*
	 * (non-Javadoc) Helper method for print application messages on standard
	 * input with new line
	 */
	private void println(String msg) {
		System.out.println(msg);
	}

	/*
	 * (non-Javadoc) Helper method for print application messages on standard
	 * input without new line
	 */
	private void print(String msg) {
		System.out.print(msg);
	}

	/*
	 * (non-Javadoc) Handle application initialization and manage application
	 * life cycle
	 */
	public void init() {
		int choice = -1;
		while (true) {
			renderView();
			enterChoiceMessage();
			choice = getInput();
			switch (choice) {
			case 1:
				addLast();
				break;
			case 2:
				addFirst();
				break;
			case 3:
				add();
				break;
			case 4:
				removeLast();
				break;
			case 5:
				removeFirst();
				break;
			case 6:
				remove();
				break;
			case 7:
				search();
				break;
			case 8:
				reverse();
				break;
			case 9:
				addBulk();
				break;
			case 10:
				createEmptyList();
				break;
			case 11:
				delete();
				break;
			case 12:
				normalExit();
			}
			if (isValidChoice(choice))
				continue;
			else
				invalidMenuRangeMessage();
		}
	}
}
