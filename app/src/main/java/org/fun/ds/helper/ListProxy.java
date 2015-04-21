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
	private List list = new LinkedList();
	private Scanner scanner = new Scanner(System.in);

	public ListProxy(int capacity) {
		for (int i = 0; i <= capacity; ++i) {
			list.addLast(i);
		}
		header();
	}

	void addLast() {
		print(INPUT_NUMBER);
		int data = getInput();
		list.addLast(data);
		print(ADD_SUCCESS);
	}

	void addFirst() {
		print(INPUT_NUMBER);
		int data = getInput();
		list.addFirst(data);
		print(ADD_SUCCESS);
	}

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

	void removeLast() {
		if (list.size() == 0) {
			print(LIST_EMPTY);
			return;
		}
		list.removeLast();
		print(LAST_SUCCESS);
	}

	void removeFirst() {
		if (list.size() == 0) {
			print(LIST_EMPTY);
			return;
		}
		list.removeFirst();
		print(FIRST_SUCCESS);
	}

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

	void reverse() {
		list.reverse();
	}

	void addBulk() {
		int nuberOfElements = 0;
		while (true) {
			print(INPUT_SIZE);
			nuberOfElements = getInput();
			if (isValidRange(nuberOfElements)) {
				list = null;
				list = new LinkedList();
				for (int i = 0; i < nuberOfElements; ++i)
					list.addLast(i);
				break;
			} else {
				println(INVALID_RANGE);
			}
		}

	}

	private void createEmptyList() {
		list = null;
		list = new LinkedList();
	}
	private void delete(){
		if (list.size() == 0) {
			println(LIST_EMPTY);
			return;
		}
		print(INPUT_NUMBER);
		int data = getInput();
		if(list.delete(data))
			println(REMOVE_SUCCESS);
		else
			print(REMOVE_FAIL);
	}
	
	void normalExit() {
		println(NORMAL_EXIT);
		close();
		System.exit(NORMAL_EXIT_SIGNAL);
	}

	void abnormalExit() {
		println(NOT_VALID_INPUT);
		close();
		System.exit(ABNORMAL_EXIT_SIGNAL);
	}

	boolean isValidRange(int nuberOfElements) {
		return nuberOfElements >= MIN_RANGE && nuberOfElements <= MAX_RANGE;
	}

	boolean isValidChoice(int in) {
		return in >= MENU_MIN_RANGE && in <= MENU_MAX_RANGE;
	}

	/**
	 * Read user input
	 * @return user input
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

	/**
	 * Close input stream
	 * 
	 * @return user input
	 */
	private void close() {
		scanner.close();
	}

	void showList() {
		println(list.toString());
	}

	void menuHeader() {
		println(MENU_HEADER);
	}

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

	void display() {
		menuHeader();
		showList();
		menu();
	}

	void header() {
		println(HEADER);

	}

	private void println(String msg) {
		System.out.println(msg);
	}

	private void print(String msg) {
		System.out.print(msg);
	}

	public void init() {
		int choice = -1;
		while (true) {
			display();
			print(INPUT_CHOICE);
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
			else{
				println(INVALID_MENU_RANGE);
			}
		}
	}
}
