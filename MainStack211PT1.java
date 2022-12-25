package LahrichiYounes;
import java.util.*;

public class MainStack211PT1 {

	public static void main(String[] args) {
		Stack211.setErrorMessage();
		Stack211.setPair();
		//This is the string for the infix statements
		String[] myStatement = new String[4];
		myStatement[0] = "(1+3 * {4+3)";
		myStatement[1] = "(2 - 1";
		myStatement[2] = "(4+8*(2+6)";
		myStatement[3] = "7*5)";
		
		for(int i = 0; i < 4; i++) {
			System.out.println(myStatement[i]);
			 Stack211<Character> charStack = new Stack211<>();
			 boolean errorOccured = false;
			 //Stage one  checks whether the expression is valid or not.
			 //This reads the character from the infix statement
			 for (int j = 0; j < myStatement[i].length(); j++) {
				 char c = myStatement[i].charAt(j);
				// System.out.println(c);
				 //This checks if the chracter is a parenthses or a curly bracket. If so it pushes it to the stack
				 if((c == '{') || (c == '(')) {
					 charStack.push(c);
				 }
				 //This if checks if when closing the paranthses, it pops them off the stack and checks if they match
				 if ( c == ')') {
			    	  if (charStack.isEmpty()) {
			    		  Stack211.printError(j,3);
			    		  errorOccured=true;
			    		  break;
			    	  } else {
			    		 char popA = charStack.pop();
			    		if (popA !=(Stack211.pair.get(c))) {
					           Stack211.printError(j,2);
					           errorOccured=true;
					           break;
			    		} 
			    	  }
			      }
				// This checks if curly brace closes then it pops them off the stack and checks to see if they match
			      if ( c == '}') {
			    	  if (charStack.isEmpty()) {
			    		  Stack211.printError(j,3);
			    	  } else {
			    		 char popA = charStack.pop();
			    		if (popA !=( Stack211.pair.get(c))) {
					           Stack211.printError(j,2);
			    		} 
			    	  }
			      }
			      if (!charStack.isEmpty() && (j == myStatement[i].length() - 1)) {
			    	  Stack211.printError(j,3);
				  }
			 }
		}
	}
}
