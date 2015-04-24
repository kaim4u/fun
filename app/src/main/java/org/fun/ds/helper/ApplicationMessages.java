package org.fun.ds.helper;
/**
 * Class holds application wide messages
 * @author Rakesh Kaim
 */
public class ApplicationMessages {
	
	/*Application Configuration constants*/
	static final int MENU_MIN_RANGE = 1;
	static final int MENU_MAX_RANGE = 13;
	static final int MIN_RANGE = 0;
	static final int MAX_RANGE = 5000000; // 5 million
	static final int NORMAL_EXIT_SIGNAL = 0;
	static final int ABNORMAL_EXIT_SIGNAL = -1;
	
	/*Messages used in menu*/
	static final String APP_HEADER = "\n\nProgram To Demonstrate Singly Linked List Operations";
	static final String MENU_HEADER = "\n\nCurrent List State";
	static final String MENU1 = "\n\t\tPress [1] to add after last element";
	static final String MENU2 = "\t\tPress [2] to add before first element";
	static final String MENU3 = "\t\tPress [3] to add at specified position";
	static final String MENU4 = "\t\tPress [4] to remove last element";
	static final String MENU5 = "\t\tPress [5] to remove first element";
	static final String MENU6 = "\t\tPress [6] to remove at specified position";
	static final String MENU7 = "\t\tPress [7] to search an element";
	static final String MENU8 = "\t\tPress [8] to reverse this list nonrecursively";
	static final String MENU9 = "\t\tPress [9] to reverse this list recursively";
	static final String MENU10 = "\t\tPress [10] to create a new prepopulated list of size between "+MIN_RANGE+"-"+MAX_RANGE;
	static final String MENU11  = "\t\tPress [11] to create a new empty list";
	static final String MENU12 = "\t\tPress [12] to delete specified number";
	static final String MENU13 = "\t\tPress [13] to quit\n";
	static final String NOTE = "\t\tNote:";
	static final String NOTE1 = "\t\t1. Please be patience. Printing of list may takes time depending upon current list size.";
	static final String NOTE2 = "\t\t2. You may have to adjust JVM memory option (-Xms,Xmx) depending upon list size";
	static final String NOTE3 = "\t\t3. In case of recusive reversal you may have to increase stack size (-Xss).\n";
	
	/*Application responses */
	static final String INPUT_NUMBER = "Enter number ";
	static final String INPUT_SIZE = "Enter new list size ";
	static final String INPUT_CHOICE = "Enter choice ";
	static final String INPUT_POSITION = "Enter position ";
	static final String INVALID_POSITION = "Invalid position. Valid position lies between 0 to ";
	static final String INVALID_RANGE = "Invalid range. Valid range lies between "+MIN_RANGE+" to "+MAX_RANGE;
	static final String INVALID_MENU_RANGE = "Invalid input. Valid input lies between "+MENU_MIN_RANGE+" to "+MENU_MAX_RANGE;
	static final String ADD_SUCCESS = "Element added successfully";
	static final String REMOVE_SUCCESS = "Element removed successfully";
	static final String REMOVE_FAIL = "Element not found";
	static final String LAST_SUCCESS = "Last element removed successfully";
	static final String FIRST_SUCCESS = "First element removed successfully";
	static final String LIST_EMPTY = "List is empty. Please add elements";
	static final String NOT_FOUND = "Element not found";
	static final String FOUND = "Element found at index ";
	static final String NOT_VALID_INPUT= "Only integers are allowed. Please try again.\n";
	static final String NORMAL_EXIT = "Thanks for testing this application!\n";
	static final String JVM_MEMORY_ERORR= "\nInsufficient Memory Error. Please adjust -Xms -Xmx JVM option and try again.\n";
	static final String JVM_MEMORY_ERORR_2= "\nInsufficient Stack Memory Error. Please adjust -Xss JVM option and try again.\n";
}
