import java.util.ArrayList;
import java.util.Random;

public class DixieCups {

	// *********************************************** HELPER OBJECTS ***********************************************
	
	/**
	 * 
	 * @author Joseph
	 *
	 */
	
	public class Cup{
		
		public Cup(int numOfChoices, int cup) {
			choices = new ArrayList<Choice>();
			
			this.cup = cup;
			availableChoices = 0;
			
			for (int i = 0; i < numOfChoices; i++) {
				choices.add(new Choice(i+1));
			}
			
			countChoices();
		}
		
		private int cup;
		private int availableChoices;
		
		public ArrayList<Choice> choices;
		
		public int countChoices() { availableChoices = 0; for (Choice choice : choices) { if (choice.valid) { availableChoices++; }} return availableChoices; }
		public int getChoicesCount() { return availableChoices; }
		
		/** @return Size of choice array  */
		public int getChoicesRange() { return choices.size(); }
		
		/**
		 * Input actual point value instead of array index
		 * Check if a any choices in a range are valid
		 * @param lower limit
		 * @param upper limit
		 * @return false if any move is invalid within the range
		 */
		
		public boolean checkChoiceRangeValidity(int lower, int upper) {
			for (int i = lower; i <= upper-1; i++) {
				if (!isValid(i)) {
					return false;
				}
			}
			
			return true;
		}
		
		public String toString() {
			String output = "[ Cup " + cup + " ";
			
			for (Choice choice : choices) {
				output += "{ " + choice.getValue() + ", " + this.isValid(choice.getValue()) + " }, ";
			}
			
			return output.substring(0, output.length()-2) + " ]";
		}
		
		/** 
		 * Validates a choice for use
		 * @param choice Input actual point value instead of array index
		 */
		
		public void validate(int choice) { choices.get(choice-1).validate(); }
		
		/** 
		 * Blocks a choice from being used
		 * @param choice Input actual point value instead of array index
		 */
		
		public void invalidate(int choice) { choices.get(choice-1).invalidate(); }
		
		/** 
		 * @param choice Input actual point value instead of array index
		 * @return Choice validity
		 */
		
		public boolean isValid(int choice) { return choices.get(choice-1).isValid(); }
		
	}
	
	/**
	 * 
	 * @author Joseph
	 *
	 */
		
	private class Choice {
		private int value;
		private boolean valid;
			
		public Choice(int value) {
			this.value = value;
			valid = true;
		}
			
		public void invalidate() { valid = false; }
		public void validate() { valid = true; }
		
		public boolean isValid() { return valid; }
		public int getValue() { return value; }
		
		public String toString() { return "{ " + value + ", " + valid + " }"; }
		
	}
	
	/**
	 * 
	 * @author Joseph
	 *
	 */
	
	public class Player {
		private int playerID;
		
		private int gamesWon;
		private int gamesLost;
		
		private boolean isWinner;
		private boolean isLoser;
		
		private ArrayList<Move> moves;
		
		public Player(int id) {
			playerID = id;
			
			gamesWon = 0;
			gamesLost = 0;
			
			reset();
		}
		
		public int getID() { return playerID; }
		
		public int getGamesWon() { return gamesWon; }
		public int gamesLost() { return gamesLost; }
		
		public boolean isWinner() { return isWinner; }
		public boolean isLoser() { return isLoser; }
		
		public void reset() { isWinner = false; isLoser = false; moves = new ArrayList<Move>(); }
		public void won() { isWinner = true; isLoser = false; gamesWon++; }
		public void lost() { isWinner = false; isLoser = true; gamesLost++; }
		
		public void addMove(Move move) { moves.add(move); }
		public Move getMove(int move) { return moves.get(move); }
		public Move getLastMove() { return moves.get(moves.size()-1); }
		public ArrayList<Move> getMoves() { return moves; }
		
		public void removeLastMove() { moves.remove(moves.size()-1); }
		public void removeMove(int move) { moves.remove(move); }
		
		public String toString() {
			String output = "[ Player ID: " + playerID + ", Wins: " + gamesWon + ", Loses: " + gamesLost + ", ";
			
			for (Move move : moves) {
				output += "{ " + move.getCup() + ", " + move.getChoice() + " }, ";
			}
			
			return output.substring(0, output.length()-2) + " ( " + getLastMove() + " ) ]";
		}
		
	}
	
	/**
	 * 
	 * @author Joseph
	 *
	 */
	
	public class Move {
		
		/**
		 * 
		 * @param The cup location Ex. (0-15)
		 * @param The point value of the choice Ex. (1,2,3)
		 * @param The Player ID Ex. (0,1)
		 */
		
		public Move(int cup, int choice, int player) {
			this.cup = cup;
			this.choice = choice;
			this.playerID = player;
			
			
			
		}
		
		private int cup;
		private int choice;
		private int playerID;
		
		public int getCup() { return cup; }
		
		/**
		 * @return Point value of choice instead of array index (index=value-1)
		 */
		
		public int getChoice() { return choice; }
		public int getPlayerID() { return playerID; }
		
		public String toString() { return "[ Player: " + playerID + ", Cup: " + cup + ", Choice: " + choice + " ]"; }
	}
	
	// *********************************************** MAIN CLASS ***********************************************
	
	// *************************** ATTRIBUTES ***************************
	
	public int currentCup;
	public int nextCup;
	public int coinsRemaining;
	public int rngRange;
	
	private int cupSize;
	
	private boolean trainingComplete;
	
	private ArrayList<Cup> cups;
	private ArrayList<Player> players;
	private ArrayList<Move> moves;
	
	private Random rng;
	
	// *************************** CONSTRUCTORS *************************
	
	public DixieCups(int cupSize, int choiceCount, int playerSize) {
		this.cupSize = cupSize;
		rngRange = choiceCount;
		
		cups = new ArrayList<Cup>();
		players = new ArrayList<Player>();
		moves = new ArrayList<Move>();
		
		resetGame();
		
		for (int i = 0; i < cupSize; i++) {
			cups.add(new Cup(choiceCount, i));
		}
		
		for (int i = 0; i < playerSize; i++) {
			players.add(new Player(i));
		}
		
		System.out.println("Game created with " + (cups.size()) + " cups, " + (cups.get(0).countChoices()) 
				+ " choices per cup, and " + players.size() + " players");
	}
	
	// *************************** MAIN *********************************
	
	public static void main(String[] args) throws Exception {
		DixieCups dcups = new DixieCups(16,3,2);
		
		for (int i = 0; i < 10; i++) {
			System.out.println("\nTraining Session " + (i+1));
			dcups.train();
		}
		
		System.out.println("\n\nComplete\n" + dcups);
		
	}
	
	// *************************** HELPER METHODS ***********************
	
	public boolean checkForWinners() { for (Player player : players) { if (player.isWinner()) { return true; } } return false; }
	public int whoWon() { if (!checkForWinners()) { return -10; } for (Player player : players) { if (player.isWinner()) { return player.getID(); } } return -1; } 
	public void resetPlayers() { for (Player player : players) { player.reset(); }}
	
	/**Resets moves list, resets coin count, and resets cup position */
	public void resetGame() { moves = new ArrayList<Move>(); currentCup = 0; coinsRemaining = cupSize-1; }
	
	
	/**
	 * @param move Move to be checked
	 * @return Whether or not the move is legal
	 * @throws Exception 
	 */
	
	public boolean moveIsLegal(Move move) throws Exception {
		if (move.getCup() > cupSize || move.getCup() < 0) {
			throw new Exception("Cup does not exist: " + move.getCup());
			
		} if (move.getPlayerID() > players.size() || move.getPlayerID() < 0) {
			throw new Exception("Player does not exist: " + move.getPlayerID());
			
		} else {
			return true;
		}
	}
	
	/**
	 * Checks to see if a player can win
	 * @return If winning condition is met
	 */
	
	public boolean checkForWinningCondition() {
		if (coinsRemaining == 1) {
			players.get(moves.get(moves.size()-1).getPlayerID()).won();
			System.out.println("Player " + moves.get(moves.size()-1).getPlayerID() + " won by default");
			return true;
			
		} else if (coinsRemaining == 2 && !cups.get(currentCup).isValid(1)) {
			players.get(moves.get(moves.size()-1).getPlayerID()).won();
			System.out.println("Player " + moves.get(moves.size()-1).getPlayerID() + " won by default");
			return true;
			
		} else if (coinsRemaining <= 0) {
			
			for (int i = moves.size()-1; i >= 0; i--) {
				if (moves.get(i).getChoice() + coinsRemaining >= 1) {
					players.get(moves.get(i).getPlayerID()).won();
					System.out.println("Player " + moves.get(i).getPlayerID() + " won by default");
					return true;
				}
			}
			
			return false;
			
		} else if ((coinsRemaining >= 2 && coinsRemaining <= cups.get(0).countChoices()) && !cups.get(currentCup).checkChoiceRangeValidity(1, cups.get(0).getChoicesCount())) {
			players.get(moves.get(moves.size()-1).getPlayerID()).won();
			System.out.println("Player " + moves.get(moves.size()-1).getPlayerID() + " won by default");
			return true;
			
		} else {
			return false;
		}
	}
	
	public String toString() {
		String output = "";
		
		for (Cup cup : cups) { output += cup + "\n"; }
		
		return output;
	}
	
	// *************************** GAMEPLAY METHODS *********************
	
	/**
	 * Automatically checks if the move is valid, makes the move, and logs the move
	 * @param Move to be made
	 * @return Value of the move
	 * @throws Exception 
	 */
	
	public int play(Move move) throws Exception {
		if (moveIsLegal(move)) {
			if (currentCup + move.getChoice() < cupSize && coinsRemaining - move.getChoice() > 0) {
				if (cups.get(move.getCup()).isValid(move.getChoice())) {
					
					currentCup 		+= move.getChoice();
					coinsRemaining  -= move.getChoice();
				
					moves.add(move);
					players.get(move.getPlayerID()).addMove(move);
				
					System.out.println("Player " + move.getPlayerID() + " choose " + move.getChoice() +", and got to cup " + currentCup + 
						" from " + (currentCup-move.getChoice()) + ". Coins remaining: " + coinsRemaining);
				
					return move.getChoice();
					
				}
			}
		} 
		
		return -1;
	}
	
	/**
	 * Play the game using a random number generator
	 * @param player Player ID
	 * @param rngRange Range of random number generator
	 * @return Either an error code or the play
	 * @throws Exception if too many attempts are made
	 */
	
	public int playRNG(int player, int rngRange) throws Exception  {
		int play;
		int choice;
		Move move;
		
		for (int attempts = 1; attempts < cups.get(0).getChoicesCount()*20; attempts++) {
			
			choice = rng.nextInt(rngRange)+1;
			move = new Move(currentCup, choice, player);
			
			if (currentCup + choice > cupSize || coinsRemaining - choice < 0) { 
				
				System.out.println("Re-rolling new choice for player (Player: " + player + ", Prev: " + move + ", Attempt: " + attempts + ")");
				
				continue;
			}
			
			if (cups.get(move.getCup()).isValid(move.getChoice())) { 
				play = play(move); 
			} else if (!cups.get(move.getCup()).isValid(move.getChoice())) { 
				System.out.println("Invalid Move " + cups.get(move.getCup())); play = -1; 
			} else {
				play = -1;
			}
			
			if ((play == choice && play != -1) && coinsRemaining > 0) { return play; }
			if (checkForWinningCondition()) { return 0; }
			
			
			System.out.println("Re-rolling new play for player (Player: " + player + ", Prev: " + move + ", Attempt: " + attempts + ")");
			
		}
		
		throw new Exception("Too many attempts made");

	}
	
	// *************************** AI METHODS ***************************
	
	/**
	 * Picks the move that can get removed based on a player's last move
	 * Will leave one move per cup
	 * @param playerID ID of the player that lost
	 * @return move that can get removed
	 */
	
	public Move getRemovableMove(int playerID) {
		
		/*
		if (!players.get(playerID).getMoves().isEmpty()) {
			if (cups.get(players.get(playerID).getMove(players.get(playerID).getMoves().size()-1).getCup()).countChoices() == 1) {
				int index = players.get(playerID).getMoves().size()-1;
				
				do {
					
					if (!players.get(playerID).getMoves().isEmpty()) { break; } else { index--; }
			
					if (cups.get(players.get(playerID).getMove(index).getCup()).countChoices() > 1) { 
						return players.get(playerID).getMove(index);
						
					}
			
				} while (cups.get(players.get(playerID).getMove(index).getCup()).countChoices() == 1);
			
			} else if (cups.get(players.get(playerID).getMove(players.get(playerID).getMoves().size()-1).getCup()).countChoices() > 1) {
				return players.get(playerID).getLastMove();
			
			}
		}
		*/
		
		if (!players.get(playerID).getMoves().isEmpty()) {
			if (cups.get(players.get(playerID).getLastMove().getCup()).countChoices() > 1) {
				return players.get(playerID).getLastMove();
				
			} else {
				int index = players.get(playerID).getMoves().size()-1;
				players.get(playerID).removeMove(index);
				index--;
				
				do {
					if (index <= -1) { break; }
					
					if (players.get(playerID).getMoves().isEmpty()) 
						{ break; } else { players.get(playerID).removeMove(index); index = players.get(playerID).getMoves().size()-1; }
					
					if (index <= -1) { break; }
					
					if (cups.get(players.get(playerID).getMove(index).getCup()).countChoices() > 1) { return players.get(playerID).getMove(index); }
					
				} while (cups.get(players.get(playerID).getMove(index).getCup()).countChoices() == 1);
			}
		}
		
		
		//System.out.println("\n\n" + this);
		return new Move(-99,-99,-99);
	}
	
	public void train() throws Exception {
		rng = new Random();
		
		trainingComplete = false;
		
		int gamesPlayed = 0;
		int winner;
		int loser;
		int firstPlayer;
		
		// Training Session
		
		do {
			System.out.println("\nGame " + (gamesPlayed+1) + " is beginning");
			resetPlayers();
			resetGame();
			
			firstPlayer = rng.nextInt(players.size()-1);
			System.out.println("Player " + firstPlayer + " will go first");
			
			// Game
			
			do {
				
				System.out.println("Player " + firstPlayer + " will go");
				playRNG(firstPlayer, rngRange);
				
				// Check for winner
				if (checkForWinningCondition()) { break; }
				
				for (int i = 0; i <= players.size()-1; i++) {
					if (i != firstPlayer) {
						System.out.println("Player " + i + " will go");
						playRNG(i, rngRange);
						
						// Check for winner
						if (checkForWinningCondition()) { break; }
					}
				}
				
			} while (!checkForWinners());
			
			winner = whoWon();
			
			if (winner == (players.size()-1)) {
				loser = 0;
			} else {
				loser = winner + 1;
			}
			
			System.out.println("Winner: " + winner +" Loser: " + loser);
			for (Player player : players) { System.out.println(player); } 
			
			Move move = getRemovableMove(loser);
			
			if (move.getPlayerID() == -99) { 
				System.out.println("No removable moves"); 
				
			} else {
				cups.get(move.getCup()).invalidate(move.getChoice());
				System.out.println("Invalidating Move " + move);
				
			}
			
			gamesPlayed++;
			
			if (gamesPlayed % 10 == 0) { System.out.println(this); }
			
			int choices = 0;
			for (Cup cup : cups) { choices += cup.countChoices(); }
			if (choices == (cupSize + 5) || choices == (cupSize - 5)) { trainingComplete = true; }
			
		} while (!trainingComplete);
		
		System.out.println("Training Complete! " + gamesPlayed + " games played");
		System.out.println(this);
		
	}
	
	
	
}
