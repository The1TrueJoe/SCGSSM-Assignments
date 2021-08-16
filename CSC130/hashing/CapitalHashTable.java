import java.util.ArrayList;

public class CapitalHashTable {
	
	class State {
		private String name;
		private String capital;
		
		public State(String name, String capital) {
			this.name = name;
			this.capital = capital;
			
		}
		
		public String getName() {
			return name;
			
		}
		
		public String getCapital() {
			return capital;
			
		}
		
		public void rename(String name) {
			this.name = name;
		}
	}
	
	
	private State[] states = {
			new State("Alabama", 		"Montgomery"), 		new State("Alaska", 		"Juneau"), 			new State("Arizona", 		"Phoenix"),
			new State("Arkansas", 		"Little Rock"), 	new State("California", 	"Sacramento"), 		new State("Colorado", 		"Denver"),
			new State("Connecticut", 	"Hartford"), 		new State("Delaware", 		"Dover"), 			new State("Florida", 		"Tallahassee"),
			new State("Georgia", 		"Atlanta"), 		new State("Hawaii", 		"Honolulu"), 		new State("Idaho", 			"Boise"),
			new State("Illinois", 		"Springfield"), 	new State("Indiana", 		"Indianapolis"), 	new State("Iowa", 			"Des Moines"),
			new State("Kansas", 		"Topeka"), 			new State("Kentucky", 		"Frankfort"), 		new State("Louisiana", 		"Baton Rouge"),
			new State("Maine", 			"Augusta"), 		new State("Maryland", 		"Annapolis"), 		new State("Massachusetts", 	"Boston"), 
			new State("Michigan", 		"Lansing"), 		new State("Minnesota", 		"St. Paul"), 		new State("Mississippi", 	"Jackson"), 
			new State("Missouri", 		"Jefferson City"),	new State("Montana", 		"Helena"), 			new State("Nebraska", 		"Lincoln"),
			new State("Nevada", 		"Carson City"), 	new State("New Hampshire", 	"Concord"),	 		new State("New Jersey", 	"Trenton"),
			new State("New Mexico", 	"Santa Fe"), 		new State("New York", 		"Albany"), 			new State("North Carolina", "Raleigh"),
			new State("North Dakota", 	"Bismarck"), 		new State("Ohio", 			"Columbus"), 		new State("Oklahoma", 		"Oklahoma City"),
			new State("Oregon", 		"Salem"), 			new State("Pennsylvania", 	"Harrisburg"),		new State("Rhode Island", 	"Providence"),
			new State("South Carolina", "Columbia"), 		new State("South Dakota", 	"Pierre"), 			new State("Tennessee", 		"Nashville"),
			new State("Texas", 			"Austin"), 			new State("Utah", 			"Salt Lake City"),	new State("Vermont", 		"Montpelier"),
			new State("Virginia", 		"Richmond"), 		new State("Washington", 	"Olympia"), 		new State("West Virginia", 	"Charleston"),
			new State("Wisconsin", 		"Madison"), 		new State("Wyoming", 		"Cheyenne")
			
	};
	
	private String[] hashTable;
	
	public CapitalHashTable() {
		hashTable = new String[50];
		
	}
	
	public void buildHashTable() {
		
		int tmpIndex = 0;
		
		for (State state : states) {
			tmpIndex = hash(state.getName());
			
			if (collides(tmpIndex)) {
				
				int x = tmpIndex + 1;
				
				while (collides(x)) {
					x++;
					
				}
				
				hashTable[x] = state.getCapital();
				
			}
		}
	}
	
	private int hash(String stateName) {
		
		int hash = ((getWordValue(stateName) % 13) + ((stateName.length() * 11) % 15)) % 39;
		
		hash = checkHashConstraints(hash);
		
		return hash;
		
	}
	
	private int checkHashConstraints(int hash) {
		if (hash > 50) {
			hash = (hash % 19);
		} else if (hash < 0) {
			hash = (hash * -1 + 9876) % 313;
		} else {
			return hash;
		}
		
		hash = checkHashConstraints(hash);
		
		return hash;
		
	}
	
	public String getCapital(String stateName) {
		return "";
	}
	
	private boolean collides(int desiredIndex) {
		if (hashTable[desiredIndex] == null) {
			return false;
			
		} else {
			return true;
			
		}
		
	}
	
	
	private int getWordValue(String word) {
		char[] letters = word.toCharArray();
		int value = 0;
		
		for (char letter : letters) {
			value += getLetterValue(letter);
			
		}
		
		value += (getLetterValue(word.charAt(0)) * 3);
		value += (getLetterValue(word.charAt(0)) / 3);
		
		return value;
	}
	
	private int getLetterValue(char letter) {
		
		letter = Character.toUpperCase(letter);
		
		switch (letter) {
		case 'A':
			return 1;
		case 'B':
			return 2;
		case 'C':
			return 3;
		case 'D':
			return 4;
		case 'E':
			return 5;
		case 'F':
			return 6;
		case 'G':
			return 7;
		case 'H':
			return 8;
		case 'I':
			return 9;
		case 'J':
			return 10;
		case 'K':
			return 11;
		case 'L':
			return 12;
		case 'M':
			return 13;
		case 'N':
			return 14;
		case 'O':
			return 15;
		case 'P':
			return 16;
		case 'Q':
			return 17;
		case 'R':
			return 18;
		case 'S':
			return 19;
		case 'T':
			return 20;
		case 'U':
			return 21;
		case 'V':
			return 22;
		case 'W':
			return 23;
		case 'X':
			return 24;
		case 'Y':
			return 25;
		case 'Z':
			return 26;
		case ' ':
			return 0;
		default:
			return -1;
		}
		
	}
	
	private void clean() {
		for(int i = 0; i < states.length; i++) {
			if (states[i].getName().contains("New")) {
				states[i].rename(states[i].getName().substring(states[i].getName().indexOf("w") + 2));
			} else if (states[i].getName().contains("North")) {
				states[i].rename(states[i].getName().substring(states[i].getName().indexOf("h") + 2) + "N");
			} else if (states[i].getName().contains("South")) {
					states[i].rename(states[i].getName().substring(states[i].getName().indexOf("h") + 2) + "S");
			} else if (states[i].getName().contains("West")) {
					states[i].rename(states[i].getName().substring(states[i].getName().indexOf("h") + 2) + "W");
			}
		}
	}
	
	private void removeFirst() {
		for (int i = 0; i < states.length; i++) {
			states[i].rename(states[i].getName().substring(1));
		}
	}
	
	public String toString() {
		String output = "";
		
		for (String capital : hashTable) {
			output += capital + "\n";
		}
		
		return output;
	}
	
	// Temporary Testing Function
	
	public void testHash(String test) 			{ System.out.println(hash(test)); }
	public void testLetterValue(char letter) 	{ System.out.println(getLetterValue(letter)); }
	public void testWordValue(String word) 		{ System.out.println(getWordValue(word)); }
	
	public void testHashValuesNoCollisionHandling() {
		for (State state : states) {
			System.out.println(state.getName() + ": " + hash(state.getName()));
			
		}
	}
	
	public void testHashValuesCollisionCount() {
		int collisions = 0;
		int hash;
		
		ArrayList<Integer> hashes = new ArrayList<Integer>();
		
		for (State state : states) {
			hash = hash(state.getName());
			 
			if (hashes.contains(hash)) {
				collisions++;
				
		
			} else {
				hashes.add(hash);
				
			}
			
			System.out.println(state.getName() + ": " + hash);
			
		}
		
		System.out.println("\n\nCollisions: " + collisions + "\nUnique Numbers: " + hashes.size());
	}
	
	public void testWordValueStepByStep(String word) {
		char[] letters = word.toCharArray();
		int value = 0;
		int letterValue;
		
		System.out.println(word + " Value: ");
		
		for (char letter : letters) {
			letterValue = getLetterValue(letter);
			value += letterValue;
			
			System.out.print(letterValue + " + ");
			
		}
		
		System.out.print("Total: " + value);
	}
	
	/*
	
	public void testCalcFormula() {
		String[] tmptable;
		
		int tmpIndex = 0;
		
		int bestI = 0, bestX = 0, bestY = 0;
		int bestNumOfCollisons = 100;
		
		for (int i = 3; i < 20; i++) {
			for (int x = 1; i < 20; x++) {
				for (int y = 1; i < 20; y++) {
					tmptable = new String[50];
					
					int collisions = 0;
					
					System.out.println("I: " + i + " X: " + x + " Y: " + y + "\n\n");
					
					for (State state : states) {
						tmpIndex = customHash(state.getName(), i, x, y);
						
						if (tmptable[tmpIndex] == null) {
							tmptable[tmpIndex] = state.getCapital();
							
						} else {
							collisions++;
							
							tmpIndex += 1;
							
							while (collides(tmpIndex)) {
								tmpIndex++;
								collisions++;
								
							}
							
							tmptable[tmpIndex] = state.getCapital();
							
						}
						
						System.out.println("State: " + state.getName() + " Index: " + tmpIndex);
					}
					
					System.out.println("\n\n");
					
					if (collisions < bestNumOfCollisons) {
						bestNumOfCollisons = collisions;
						
						bestI = i;
						bestX = x;
						bestY = y;
					}
					
				}
			}
		}
		
		System.out.println("Best Results: Collisions: " + bestNumOfCollisons + "(" + bestI + "," + bestX + "," + bestY + ")");
	}
	
	*/
	
	public static void main (String[] args) {
		CapitalHashTable table = new CapitalHashTable();
		
		table.testHashValuesCollisionCount();
		//table.testCalcFormula();
		
		//table.buildHashTable();
		//System.out.println(table);
		
	}

}
