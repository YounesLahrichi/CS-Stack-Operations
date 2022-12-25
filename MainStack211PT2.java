package LahrichiYounes;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class MainStack211PT2 {
	
	public static HashMap<Character, Integer> precedence = new HashMap<>();

	public static void main(String[] args) {
		
		setPrecedence();
		System.out.println(checkPrecedence('*','+'));
		String[] Statement = {
				"(1+5)*(8-3)+(6+3*7)",
				"(4+1)*(5+7)",
				"(7*9-2*4)*(8-1*8+9)"
				};
		
		for (int i = 0; i < Statement.length; i++){
			// Stack of chars for converting to post-fix
			Stack211<Character> charStack = new Stack211<>(); 
			String post = "";
			charStack.setErrorMessage();
			charStack.setPair();
			
			System.out.println("Expression " + (i+1));
			System.out.println("Infix: " + Statement[i]);
			// read one token by one
			for (int j = 0; j < Statement[i].length(); j++) {
				char c= Statement[i].charAt(j);
				
				// if its a number, add to the postfix expression
				if (c >= '0' && c <= '9') {
					post += c;
				}
				
				//if a left parantheses, push to the stack
				else if (c == '(' || c == '{') {
					charStack.push(c);
				}
				
				// if a closing parantheses, pop until you come to a left parantheses
				else if (c == ')' || c == '}') {
					char p = charStack.pop();
					
					while (!charStack.isEmpty() && p != '(' && p != '{') {
						post += p;
						p = charStack.pop();
					}
				}
				
				//Checks the precedednce of the top of the stack, pops everything until the precedence is 
				//lower than the current expressions.
				else if (c == '+' || c == '-' || c == '*' || c == '/') {
					while (!charStack.isEmpty() && checkPrecedence(charStack.topOfStack() , c)) {
						char p = charStack.pop();
						post += p;
					}
					charStack.push(c);
					
				}
				
				System.out.println(charStack.myStack.toString());
			}
			
			// if looped has looped through all of the statement, everything is poppped.
			while (!charStack.isEmpty()) {
				char p = charStack.pop();
				post += p;
			}
			
			System.out.println("Postfix: " + post);
			
			Stack211<Integer> evalSt = new Stack211<>(); // Stack for Integers
			int value;
			
			// Loop for each post-fix expression
			for (int k = 0; k < post.length(); k++) {
				char c = post.charAt(k);
				
				//if the character is a number it pushes it to the stack for evaluation.
				if (c >= '0' && c <= '9') {
					value = c - '0';
					evalSt.push(value);
				}
				
				// If an operator, the first two values are popped and the operation is performed. The result is sent back into to stack. 
				else if ((c == '+' || c == '-' || c == '*' || c == '/')) {
					int value1 = evalSt.pop();
					int value2 = evalSt.pop();
					int newValue = 0;
					
					if (c == '+') {
						newValue = value2 + value1;
						evalSt.push(newValue);
					} else if (c == '-') {
						newValue = value2 - value1;
						evalSt.push(newValue);
					}  else if (c == '*') {
						newValue = value2 * value1;
						evalSt.push(newValue);
					}  else if (c == '/') {
						newValue = value2 / value1;
						evalSt.push(newValue);
					}			
				}
			}
			
			System.out.println("Evaluation: " + evalSt.pop());
			System.out.println();
		}
	}
	
	

	//checks precedence of operators
	private static boolean checkPrecedence(char topOfStack, char c) {
		if (precedence.get(c) >= precedence.get(topOfStack)) {
			return true;
		}
		return false;
	}

	//sets precedence of operators
	public static void setPrecedence() {
		precedence.put('+' , 2);
		precedence.put('-' , 2);
		precedence.put('*' , 1);
		precedence.put('/' , 1);
		precedence.put('(' , 3);
		precedence.put('{' , 3);
	}
}
