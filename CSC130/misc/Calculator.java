import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {
	
	public static Queue<String> input;

	public static void main(String[] args) {
		input = new LinkedList<String>();

		input.add("2");
		input.add("+");
		input.add("4");
		input.add("*");
		input.add("2");


/*
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter Equation");
		String textInput = keyboard.nextLine();
		keyboard.close();

		for (int i = 0; i < textInput.length()-1; i++) {
			if (textInput.charAt(i) == ' ') {
				continue;
				
			} else if (Character.isDigit(textInput.charAt(i))) {
				if (textInput.charAt(i) == '.') {
					continue;
					
				}

				String newDigit = "";

				int x = i;
				for (; x < textInput.length()-1; x++) {
					if (Character.isDigit(textInput.charAt(x)) || textInput.charAt(x) == '.') {
						newDigit += textInput.charAt(x);
						
					} else {
						break;
						
					}
				}

				i = x;
				
				input.add(newDigit);
				
			} else {
				input.add(textInput.charAt(i) + "");
			}
		}
*/
		
		System.out.println(calculate());
		
	}
	
	public static String calculate() {

		int i = 0;
		
		Stack<Character> operations = new Stack<Character>();
		Stack<Double> numbers = new Stack<Double>();
		
		if (input.peek().equals("(")) {
			
		} else {
			
			boolean canContinue = true;
			while (canContinue) {
				
				if (input.isEmpty()) {
					canContinue = false;
				}

				if (i < input.size()) {
					canContinue = false;

				} else {
					i++;

				}

				//numbers.push(Double.parseDouble(input.remove()));


				if (Character.isDigit(input.peek().charAt(0))) {
					numbers.push(Double.parseDouble(input.remove()));
				}

				
				if (input.peek().equals("^")) {
					input.remove();

					numbers.push(Math.pow(numbers.pop(), Double.parseDouble(input.remove())));
					continue;
				} else {
					operations.push(input.remove().charAt(0));
					numbers.push(Double.parseDouble(input.remove()));
				}

				if (input.peek().equals("/") || input.peek().equals("*")) {

					switch(input.peek()) {
						case("/"):
							input.remove();
							numbers.push(numbers.pop() / Double.parseDouble(input.remove()));
						case("*"):
							input.remove();
							numbers.push(numbers.pop() / Double.parseDouble(input.remove()));
					}

					continue;
				} else {
					operations.push(input.remove().charAt(0));
					numbers.push(Double.parseDouble(input.remove()));
				}

				if (input.peek().equals("/") || input.peek().equals("*")) {

					switch(input.peek()) {
						case("/"):
							input.remove();
							numbers.push(numbers.pop() / Double.parseDouble(input.remove()));
						case("*"):
							input.remove();
							numbers.push(numbers.pop() / Double.parseDouble(input.remove()));
					}

					continue;

				} else {
					operations.push(input.remove().charAt(0));
					numbers.push(Double.parseDouble(input.remove()));
				}
				
				boolean canContinue2 = true;
				while (canContinue2) {
					try {
						input.add(numbers.pop() + "");
						
					} catch (EmptyStackException e) {
						canContinue2 = false;
					}

					try {
						input.add(operations.pop() + "");

					} catch (EmptyStackException e) {

					}
				}
				
			}
				
		}
		
		return input.peek() + "";
	}
	
	 
	
}
