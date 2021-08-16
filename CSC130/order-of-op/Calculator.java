import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {
	
	public static Queue<String> input;

	public static void main(String[] args) {
		input = new LinkedList<String>();
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter Equation");
		String textInput = keyboard.nextLine();
		keyboard.close();
		
		for (int i = 0; i < textInput.length()-2; i++) {
			if (textInput.charAt(i) == ' ') {
				continue;
				
			} else if (Character.isDigit(textInput.charAt(i))) {
				if (textInput.charAt(i) == '.') {
					continue;
					
				}

				String newDigit = "";

				int x = i;
				for (; x < textInput.length()-1; x++) {
					if (Character.isDigit(textInput.charAt(i)) || textInput.charAt(i) == '.') {
						newDigit += textInput.charAt(x);
						
					} else {
						break;
						
					}
				}

				i = x - 1;
				
				input.add(newDigit);
				
			} else {
				input.add(textInput.charAt(i) + "");
			}
		}
		
		System.out.println(calculate());
		
	}
	
	public static double calculate() {
		
		Stack<Character> operations = new Stack<Character>();
		Stack<Double> numbers = new Stack<Double>();
		
		if (input.peek().equals("(")) {
			
		} else {
			
			if (Character.isDigit(input.peek().charAt(0))) {
				numbers.push(Double.parseDouble(input.remove()));
			}
			
			boolean canContinue = true;
			while (canContinue) {
				
				if (input.isEmpty()) {
					return numbers.peek();
				}
				
				if (input.peek() == "^") {
					numbers.push(Math.pow(numbers.pop(), Double.parseDouble(input.remove())));
				
				} else {
					operations.push(input.remove().charAt(0));
					numbers.push(Double.parseDouble(input.remove()));
					
					if (input.peek().equals("/") || input.peek().equals("*")) {
						
						switch(input.remove()) {
							case("/"):
								numbers.push(numbers.pop() / Double.parseDouble(input.remove()));
							case("*"):
								numbers.push(numbers.pop() / Double.parseDouble(input.remove()));
						}
						
					} else {
						operations.push(input.remove().charAt(0));
						numbers.push(Double.parseDouble(input.remove()));
						
						if (input.peek().equals("/") || input.peek().equals("*")) {
							
							switch(input.remove()) {
								case("/"):
									numbers.push(numbers.pop() / Double.parseDouble(input.remove()));
								case("*"):
									numbers.push(numbers.pop() / Double.parseDouble(input.remove()));
							}
							
						} else {
							operations.push(input.remove().charAt(0));
							numbers.push(Double.parseDouble(input.remove()));
							
						}
					}
						
				} 
				
				boolean canContinue2 = true;
				while (canContinue2) {
					try {
						input.add(numbers.pop() + "");
						input.add(operations.pop() + "");
						
					} catch (EmptyStackException e) {
						canContinue2 = false;
						
					}
				}
				
			}
				
		}
		
		return numbers.peek();
	}
	
	 
	
}
