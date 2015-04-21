package org.fun.ds.helper;
/**
 * Class holds application wide messages
 * @author Rakesh Kaim
 */
public class ApplicationMessages {
	/*Application constants*/
	static final int MENU_MIN_RANGE = 1;
	static final int MENU_MAX_RANGE = 11;
	static final int MENU_EXIT = 10;
	static final int MIN_RANGE = 0;
	static final int MAX_RANGE = 1000;
	static final int NORMAL_EXIT_SIGNAL = 0;
	static final int ABNORMAL_EXIT_SIGNAL = -1;
	/*Messages used in menu*/
	static final String HEADER = "\nPrograme to demonstrate singly linked list operations\n";
	static final String MENU_HEADER = "\n\nCurrent List contains";
	static final String MENU1 = "\n\t\tPress [1] to add after last element";
	static final String MENU2 = "\t\tPress [2] to add before first element";
	static final String MENU3 = "\t\tPress [3] to add at specified position";
	static final String MENU4 = "\t\tPress [4] to remove last element";
	static final String MENU5 = "\t\tPress [5] to remove first element";
	static final String MENU6 = "\t\tPress [6] to remove at specified position";
	static final String MENU7 = "\t\tPress [7] to search an element";
	static final String MENU8 = "\t\tPress [8] to reverse this list";
	static final String MENU9 = "\t\tPress [9] to create a new list of given size ("+MIN_RANGE+"-"+MAX_RANGE+")";
	static final String MENU10  = "\t\tPress [10] to create a new empty list";
	static final String MENU11 = "\t\tPress [11] to quit\n";
	/*Application responses */
	static final String INPUT_NUMBER = "Enter Number ";
	static final String INPUT_POSITION = "Enter position ";
	static final String INVALID_POSITION = "Invalid position. Valid position lies between 0 to ";
	static final String INVALID_RANGE = "Invalid range. Valid range lies between "+MIN_RANGE+" to "+MAX_RANGE;
	static final String INVALID_MENU_RANGE = "Invalid input. Valid input lies between "+MENU_MIN_RANGE+" to "+MENU_MAX_RANGE;
	static final String ADD_SUCCESS = "Element added successfully";
	static final String REMOVE_SUCCESS = "Element removed successfully";
	static final String LAST_SUCCESS = "Last element removed successfully";
	static final String FIRST_SUCCESS = "First element removed successfully";
	static final String LIST_EMPTY = "List is empty. Please add an element";
	static final String NOT_FOUND = "Element not found";
	static final String FOUND = "Element found at index  ";
	static final String NOT_VALID_INPUT="Congratulation !! You crack the program.\n";
	static final String NORMAL_EXIT = "Thanks for testing this application.\n";
}
