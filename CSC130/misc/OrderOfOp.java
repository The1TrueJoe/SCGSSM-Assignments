import java.util.Scanner;
import java.util.Stack;

public class OrderOfOp {
	
	private static void Stack<Double> numbers;
	private static void Stack<Character> operators;
	
	public static void main(String[] args) {

 /*
 		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter equation: ");
		String input = keyboard.nextLine();

		System.out.println("Select Calculation Type \n (0) Infix \n (1) Postfix");
		String type = keyboard.nextLine();

		switch (type) {
			case ("0") :

		}

*/
		
		numbers = new Stack<Double>();
		operators = new Stack<Character>();


 		String input = "23 + 5 * 12";

 		fillStacks(splitToArray(input));
 		System.out.println(calculate());

	}

	// Assuming that the stacks are organized in infix

	Stack<Character> tempOperators;
	Stack<Double> tempNumbers;

	private static double calculate() {
		boolean ableToContinue = true;
		double num;
		char operation;

		tempOperators = new Stack<Character>();
		tempNumbers = new Stack<Double>();

		while (ableToContinue) {
			try {

				if (operators.peek() == '(') {

					Stack<Character> tempOperators2 = new Stack<Character>();
					Stack<Double> tempNumbers2 = new Stack<Double>();

					tempOperators = new Stack<Character>();
					tempNumbers = new Stack<Double>();

					while (operators.peek() != ')') {
						calculateSingleOperation();

						while (ableToContinue) {
							try {
								tempOperators2.push(tempOperators.pop());

							} catch (EmptyStackException e) {
								ableToContinue = false;
							}
						}

						while (ableToContinue) {
							try {
								tempNumbers2.push(tempNumbers.pop());

							} catch (EmptyStackException e) {
								ableToContinue = false;
							}
						}
					}

				} else {
					numbers.pop(calculateSingleOperation());
					resetStacks();
				}

			} catch (EmptyStackException e) {
				ableToContinue = false;
			}
		}

	}

	private static double calculateSingleOperation() {

		tempNumbers = new Stack<Double>();
		tempOperators = new Stack<Character>();

		if (operators.peek() == '^') {
			return math.pow(numbers.pop(), numbers.pop());
		} else {
			tempNumbers.push(numbers.pop());
			tempNumbers.push(numbers.pop());
			tempOperators.push(operators.pop());

			if (operators.peek() == '*') {
				return numbers.pop() * numbers.pop();
			} else {
				tempNumbers.push(numbers.pop());
				tempNumbers.push(numbers.pop());
				tempOperators.push(operators.pop());

				if (operators.peek() == '%') {
					return numbers.pop() % numbers.pop();
				} else {
					tempNumbers.push(numbers.pop());
					tempNumbers.push(numbers.pop());
					tempOperators.push(operators.pop());

					if (operators.peek() == '/') {
						return numbers.pop() / numbers.pop();
					} else {
						tempNumbers.push(numbers.pop());
						tempNumbers.push(numbers.pop());
						tempOperators.push(operators.pop());

						if (operators.peek() == '+') {
							return numbers.pop() + numbers.pop();
						} else {
							tempNumbers.push(numbers.pop());
							tempNumbers.push(numbers.pop());
							tempOperators.push(operators.pop());

							if (operators.peek() == '-') {
								return numbers.pop() - numbers.pop();
							} else {
								System.out.println("Invalid Calculation, Returning 0");
								return 0;
							}
						}
					}
				}
			}
		}

	}

	private static void resetStacks() {
		while (ableToContinue) {
			try {
				operators.push(tempOperators.pop());

			} catch (EmptyStackException e) {
				ableToContinue = false;
			}
		}

		while (ableToContinue) {
			try {
				numbers.push(tempNumbers.pop());

			} catch (EmptyStackException e) {
				ableToContinue = false;
			}
		}
	}


	// Fills data into stacks assuming data is in infix

	private static void fillStacks(String[] input) {

		for (String op : input) {
			if (isValidOperator(op.charAt(0))) {
				operators.push(op);
				continue;

			} else if (op.charAt(0) = '(' || op.charAt(0) = ')') {
				operators.push(op.charAt(0));
				continue;
			}

			try {
				numbers.push(Double.parseDouble(op));
				continue;
			} catch (NumberFormatException e) {
				System.out.println("UNABLE TO SORT (" + op + ")" );
			}

		}

	}

	// Organizes input string into a list of operands/operators in inputted order

	private static String[] splitToArray(String input) {
		int arrayLength = 0;

		for (int i = 0; i < input.length()-1; i++) {
			if (!input.charAt(i) == ' ') {
				arrayLength++;
			}
		}

		String[] array = new String[arrayLength];
		int arrayIndex = 0;

		for (int i = 0; i < input.length()-1; i++) {
			if (input.charAt(i) == ' ') {
				continue;
			} else if (input.charAt(i).isDigit()) {
				if (input.charAt(i) == '.') {
					continue;
				}

				String newDigit = "";

				int x = i;

				for (; x < input.legnth()-1; x++) {
					if (input.charAt(x).isDigit() || input.charAt(i) == ".") {
						newDigit += charAt(x);
					} else {
						break;
					}
				}

				int i = x - 1;

				array[arrayIndex] = newDigit;
				arrayIndex++;

			} else if (isValidOperator(input.charAt(i))) {
				array[arrayIndex] = input.charAt(i);
				arrayIndex++;
			}
		}

		return array;
	}

	// Checks if a char is a valid operator

	private static boolean isValidOperator(char input) {
		switch (input) {
			case('*'):
				return true;
			case('/'):
				return true;
			case('+'):
				return true;
			case('-'):
				return true;
			case('^'):
				return true;
			case('%'):
				return true;
			default:
				return false;
		}
	}

	// Converts postfix into infix

	private static String[] postfixToInfix(String[] input) {

	}

}
