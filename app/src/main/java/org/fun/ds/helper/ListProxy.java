package org.fun.ds.helper;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.fun.ds.List;
import org.fun.ds.impl.LinkedList;
/**
 * Helper class for {@link org.fun.app.ListApp}
 * @author Rakesh Kaim
 */
public class ListProxy {
	private final List list = new LinkedList();
	private Scanner scanner = new Scanner(System.in);
	
	public ListProxy(int capacity) {
		for(int i = 0; i <= capacity; ++i){
			list.addLast(i);
		}
		header();
	}
	
	void addLast(){
		print(ApplicationMessages.INPUT_NUMBER); 
		int data = getInput();
		list.addLast(data);
		print(ApplicationMessages.ADD_SUCCESS);
	}	
	void addFirst(){
		print(ApplicationMessages.INPUT_NUMBER); 
		int data = getInput();
		list.addFirst(data);
		print(ApplicationMessages.ADD_SUCCESS);
	}
	void add(){
		if(list.size() == 0){
			print(ApplicationMessages.LIST_EMPTY);
			return;
		}
		print(ApplicationMessages.INPUT_NUMBER); 
		int data = getInput();
		print(ApplicationMessages.INPUT_POSITION); 
		int i = getInput();
		while(i >=list.size()){
			println(ApplicationMessages.INVALID_POSITION + (list.size()-1));
			print(ApplicationMessages.INPUT_POSITION);
			i = getInput();
		}
		list.add(i, data);
		System.out.print(ApplicationMessages.ADD_SUCCESS);
	}
	void removeLast(){
		if(list.size() == 0){
			print(ApplicationMessages.LIST_EMPTY);
			return;
		}
		list.removeLast();
		print(ApplicationMessages.LAST_SUCCESS);
	}
	void removeFirst(){
		if(list.size() == 0){
			print(ApplicationMessages.LIST_EMPTY);
			return;
		}
		list.removeFirst();
		print(ApplicationMessages.FIRST_SUCCESS);
	}
	void remove(){
		int size = list.size();
		if(size == 0){
			print(ApplicationMessages.LIST_EMPTY);
			return;
		}
		print(ApplicationMessages.INPUT_POSITION);
		int i = getInput();
		while(i >= size){
			println(ApplicationMessages.INVALID_POSITION + (size-1));
			print(ApplicationMessages.INPUT_POSITION);
			i = getInput();
		}
		list.remove(i);
		print(ApplicationMessages.REMOVE_SUCCESS);
	}
	void search(){
		if(list.size() == 0){
			println(ApplicationMessages.LIST_EMPTY);
			return;
		}
		print(ApplicationMessages.INPUT_NUMBER); 
		int data = getInput();	
		int i = list.contain(data);
		if(i == -1)
			println(ApplicationMessages.NOT_FOUND);
		else
			println(ApplicationMessages.FOUND + i);
	}
	void reverse(){
		list.reverse();
	}
	void normalExit(){
		println(ApplicationMessages.NORMAL_EXIT);
		close();
		System.exit(0);
	}
	void abnormalExit(){
		println(ApplicationMessages.NOT_VALID_INPUT);
		close();
		System.exit(-1);
	}
	boolean isValidChoice(int in){
		return in >= 1 && in < 9;
	}
	/**
	 * Read user input and return it to 
	 * @return user input
	 */
	int getInput(){
		int in =0;
		try{
    	  		in = scanner.nextInt();
      }catch(InputMismatchException ex){
    	  System.out.println(ApplicationMessages.NOT_VALID_INPUT);
    	  close();
    	  System.exit(-1);
      }
		return in;
	}
	/**
	 * Close input stream 
	 * @return user input
	 */
	private void close(){
  		scanner.close();
	}
	void showList(){
		println(list.toString());
	}
	
	void menuHeader(){
		println(ApplicationMessages.MENU_HEADER);
	}
	void menu(){
		println(ApplicationMessages.MENU1);
		println(ApplicationMessages.MENU2);
		println(ApplicationMessages.MENU3);
		println(ApplicationMessages.MENU4);
		println(ApplicationMessages.MENU5);
		println(ApplicationMessages.MENU6);
		println(ApplicationMessages.MENU7);
		println(ApplicationMessages.MENU8);
		println(ApplicationMessages.MENU9);
	}
	void display(){
		menuHeader();
		showList();
		menu();
	}
	void header(){
		println(ApplicationMessages.HEADER);
		
	}
	private void println(String msg){
		System.out.println(msg);
	}
	private void print(String msg){
		System.out.print(msg);
	}
	public void init(){
		int choice = -1;
		while (true) {
			display();
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
			}
			if (isValidChoice(choice))
				continue;
			else if (choice == 9)
				normalExit();
			else
				abnormalExit();
		}
	}
}
