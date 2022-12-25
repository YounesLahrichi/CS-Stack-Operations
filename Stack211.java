package LahrichiYounes;

import java.util.*;

public class Stack211 <T> {
	//This initializes the 3 hashmaps needed for each method down below
	public static HashMap<Integer, String> errorMessage = new HashMap<>();
	public static HashMap<Character, Character> pair = new HashMap<>();
	public static HashMap<Character, Integer> precedence = new HashMap<>();
	
	//This variable is used for the index of the stack
	int stackTop;
	//A normal ArrayList used to simulate the stack
	ArrayList<T> myStack = new ArrayList<>();
	//This is a constructor for the class that sets the intial value of the stackTop to -1 which lets the computer know its an empty stack
	public Stack211(){   
		stackTop = -1;
	}
	//This pushes a value onto the stack. It increases stackTop then adds the value to the ArrayList
	public void push(T c){ // pushes a given object to the stack
		stackTop++;
		myStack.add(c);
	}
	//This pops the top value of the stack by removing the value in the ArrayLst myStack at the index of stackTop.
	public T pop(){ 
		T c = myStack.get(stackTop);
		myStack.remove(stackTop);
		stackTop--;
		return c;
	}
		   
	// checks if the stack is empty
	public boolean isEmpty(){ 
		if (stackTop == -1) {
			return true;
		} else {
			return false;
		}
	
	}
	// This is the HashMap for error messages
	public static void setErrorMessage() {
		errorMessage.put(1, "Syntax Error: Expected \")\" ");
		errorMessage.put(2, "Syntax Error: Expected \"}\" ");
		errorMessage.put(3, "Syntax Error: Incomplete Expression");
	}
	 // This is the HashMap for pair checking
	static void setPair() { 
		pair.put(')','(');
		pair.put('}','{');
	}
	 //This method prints errors when they are found
	public static void printError(int location, int errorNo){
		for (int i=0; i<location; i++) {
	        System.out.print(" ");
	      }
	      System.out.println("^"); 
	      System.out.println(errorMessage.get(errorNo));
	}
	// returns the object that is at the top of the stack.
	public T topOfStack() {
		T c = myStack.get(stackTop);
		return c;
	}
	
	

	
	

}