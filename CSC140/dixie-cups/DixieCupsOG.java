import java.util.ArrayList;
import java.util.Random;

public class DixieCupsOG {
	
	private final int GAME_CUPS = 15;
	
	private ArrayList<Cup> cups;
	private Player[] players;
	
	private int coinsLeft;
	private int currentCup;
	
	private Random rng;

	public class Cup {
		public Cup(int number) { 
			this.number = number; 
			
			
			valid1 = true;
			valid2 = true;
			valid3 = true;
		}
		
		public Cup(int number, boolean valid1, boolean valid2, boolean valid3) {
			this.number = number;
			
			this.valid1 = valid1;
			this.valid2 = valid2;
			this.valid3 = valid3;
		}
		
		private int number;
		private int recentMove;
		
		public boolean valid1;
		public boolean valid2;
		public boolean valid3;
		
		public int getNumber() { return number; }
		public int getRecentMove() { return recentMove; }
		
		public int countChoices() { int i = 0; if (valid1) { i++; } if (valid2) { i++; } if (valid2) { i++; } return i; }
		
		public void setRecentMove(int move) { recentMove = move; }
		
		public String toString() { return "[ Cup: " + number + " (1) " + valid1 + " (2) " + valid2 + " (3) " + valid3 + " ]";}
	
	}
	
	public class Move {
		
		public Move(int cup, int choice, int player) {
			this.cup = cup;
			this.choice = choice;
			this.player = player;
		}
		
		public int cup;
		public int choice;
		public int player;
		
		public String toString() { return "[ Player: " + player + " Cup: " + cup + ", Choice: " + choice + " ]"; }
	}
	
	public class Player {
		
		public Player(int number) { 
			this.number = number; 
	
			gamesWon = 0; 
			gamesLost = 0;
			
			reset(); 
			
			moves = new ArrayList<Move>();
			
		}
		
		private ArrayList<Move> moves;
		public boolean isWinner;
		public boolean isLoser;
		
		public int number;
		
		public int gamesWon;
		public int gamesLost;
		
		public void lost() { isWinner = false; isLoser = true; gamesLost++;}
		public void won() { isWinner = true;  isLoser = false; gamesWon++;}
		public void reset() { isWinner = false; isLoser = false; resetMoves();}
		
		public void addMove(int cup, int choice, int player) { moves.add(new Move(cup, choice, player)); }
		public void addMove(Move move) { moves.add(move); }
		
		public void resetMoves() { moves = new ArrayList<Move>(); }
		
		public Move getLastMove() { if (moves.size() != 0 && ((moves.size() - 1) > 0)) { return moves.get(moves.size() - 1); } else { return new Move(0,0,-98); } }
		public void removeLastMove() { if (moves.size() != 0 && ((moves.size() - 1) > 0)) { moves.remove(moves.size() - 1); } }

		public ArrayList<Move> getMoves() { return moves; }
		
		public String toString() { 
			String output = "[ Player " + number + ", Moves: {"; 
			for (Move move : moves) { output += "(" + move.cup + ", " + move.choice + "), "; }
			output = output.substring(0, output.length()-2) + "}]";
			return output;
		}
		
	}
	
	public DixieCupsOG() {
		coinsLeft = GAME_CUPS;
		currentCup = 0;
		
		cups = new ArrayList<Cup>();
		
		for (int i = 0; i < GAME_CUPS+1; i++) {
			cups.add(new Cup(i));
		}
		
		System.out.println("Created " + cups.size() + " cups");
		
	}
	
	public void invalidateMove(Move move) throws Exception {
		int cup = move.cup;
		int play = move.choice;
		
		if (cup < 0 || cup > GAME_CUPS)
			throw new Exception("Invalid Cup");
		
		if (play == 1)
			cups.get(cup).valid1 = false;
		
		else if (play == 2)
			cups.get(cup).valid2 = false;
		
		else if (play == 3)
			cups.get(cup).valid3 = false;
		
		else
			throw new Exception("Invalid Number");
			
	}
	
	public boolean checkChoiceValidation(int cup, int play) throws Exception {
		if (cup < 0 || cup > GAME_CUPS)
			throw new Exception("Invalid Cup");
		
		if (play == 1)
			return cups.get(cup).valid1;
		
		else if (play == 2)
			return cups.get(cup).valid2;
		
		else if (play == 3)
			return cups.get(cup).valid3;
		
		else
			throw new Exception("Invalid Number");
	}
	
	public Move pickRemovableMove(int player) {
		
		//if (players[player].getMoves().size() == )
		
		if (cups.get(players[player].getLastMove().cup-1).countChoices() > 1) {
			return players[player].getLastMove();
		}
		
		ArrayList<Move> moves = players[player].getMoves();
		Move move;
		
		for (int i = moves.size()-1; i > 0; i--) {
			move = moves.get(i);
			
			if (cups.get(move.cup).countChoices() > 1) {
				return move;
			}
		}
		
		return new Move(0,0,-99);
	}
	
	public void resetGame() {
		coinsLeft = GAME_CUPS;
		currentCup = 0;
		
		for (Player player : players) {
			player.reset();
		}
	}
	
	public void playerLost(int player) {
		if (player == 0) {
			players[1].won();
			players[0].lost();
			
		} else if (player == 1) {
			players[0].won();
			players[1].lost();
		}
	}
	
	public void playerWon(int player) {
		if (player == 0) {
			players[0].won();
			players[1].lost();
			
		} else if (player == 1) {
			players[1].won();
			players[0].lost();
		}
	}
	
	public int play(int choice, int player) throws Exception {
		if (choice > 3 || choice < 1) {
			throw new Exception("Invalid Choice (1-3): " + choice);
			
		} else if (player < 0 || player > 1) {
			throw new Exception("Invalid Player");
			
		}
		
		if (coinsLeft == 1) {
			playerLost(player);
			System.out.println("Only one coin remaining!, player " + player + " lost by default (New Move {" + currentCup + "," + choice + "} N/A)");
			players[player].removeLastMove();
			
			return -99;
		} else if (coinsLeft == 2) {
			if (!(checkChoiceValidation(currentCup, 1)) && ( checkChoiceValidation(currentCup, 2)) || checkChoiceValidation(currentCup, 3)) {
				System.out.println("There are no possible winning moves. player " + player + " lost by default (New Move {" + currentCup + "," + choice + "} N/A)");
				players[player].removeLastMove();
				playerLost(player);
				
				return -99;
			} else if (checkChoiceValidation(currentCup, 1)) {
				System.out.println("Auto-Reroll - Player " + player + " picked 1 coin with 1 remaining");
				players[player].addMove(new Move(currentCup, 1, player));
				playerWon(player);
				
				return -1;
			}
		} else if (coinsLeft == 3) {
			if ( ( !(checkChoiceValidation(currentCup, 1)) && !(checkChoiceValidation(currentCup, 2)) ) && checkChoiceValidation(currentCup, 3) ) {
				System.out.println("There are no possible winning moves. player " + player + " lost by default (New Move {" + currentCup + "," + choice + "} N/A)");
				players[player].removeLastMove();
				playerLost(player);
				
				return -99;
			} else if (checkChoiceValidation(currentCup, 2)) {
				System.out.println("Auto-Reroll - Player " + player + " picked 2 coins with 1 remaining");
				players[player].addMove(new Move(currentCup, 2, player));
				playerWon(player);
				
				return -12;
			}
		}
		
		if (checkChoiceValidation(currentCup, choice)) {
			if ((coinsLeft - choice) < 1 || (currentCup + choice) > 15) {
				return -1;
				
			} else if ((coinsLeft - choice) == 1 || (currentCup + choice) == 15) {
				playerWon(player);
				System.out.println("Only one coin remaining!, player " + player + " won by default");
				
				return -99;
				
			} else if ((coinsLeft - choice) > 1 || (currentCup + choice) > 15) {
				players[player].addMove(new Move(currentCup, choice, player));
				
				coinsLeft  -= choice;
				currentCup += choice;
				
				System.out.println("Player " + player + " picked " + choice + " coin(s), and got to cup " + currentCup + " from cup " + (currentCup-choice) + ". Coins Remaining: " + coinsLeft);
				
				return choice;
			} else {
				return -1;
			}
			
		} else {
			return -1;
		}
		
	}
	
	public int rngPlay(int player) throws Exception {
		if (player < 0 || player > 1) {
			throw new Exception("Invalid Player");
		}
		
		players[0].reset();
		players[1].reset();
		
		int choice, play;
		
		do {
			choice = rng.nextInt(3)+1;
			play = play(choice, player);
			
			if (play == -99) {
				return choice; 
			} else if (play < -10 && play > -20) {
				return play + 10;
			}
			
			//System.out.println("Regenerating New Number (" + choice + ")");
			
		} while(play != choice);
		
		return choice;
		
	}
	
	public void train() throws Exception {
		final int PLAYER_COUNT = 2;
		
		players = new Player[PLAYER_COUNT];
		rng = new Random();
		
		for (int i = 0; i <= PLAYER_COUNT-1; i++) {
			players[i] = new Player(i);
			System.out.println("Player " + i + " created");
		}
		
		final int NUM_OF_GAMES = 2000;
		
		System.out.println("Beginning Training");
		
		for (int i = 0; i < NUM_OF_GAMES; i++) {
			
			System.out.println("\n");
			
			int firstPlayer = rng.nextInt(PLAYER_COUNT);
			int secondPlayer = -1;
			
			if (firstPlayer == 1) { secondPlayer = firstPlayer - 1; }
			else if (firstPlayer == 0) { secondPlayer = firstPlayer + 1; }
			else { throw new Exception("Incorrect Player Number Generated"); }
				
			System.out.println("Player " + firstPlayer + " goes first");
			System.out.println("Player " + secondPlayer + " goes second");
			
			while ((!players[0].isWinner && !players[0].isLoser) && (!players[1].isWinner && !players[1].isLoser)) {
				rngPlay(firstPlayer);
				
				if (players[0].isWinner || players[1].isWinner) { break; }
				
				rngPlay(secondPlayer);
				
				if (players[0].isWinner || players[1].isWinner) { break; }
			}
			
			int winner, loser;
			
			if (players[0].isWinner) { winner = 0; loser = 1; }
			else if (players[1].isWinner) { winner = 1; loser = 2; }
			else { winner = -1; loser = -1; }
			
			System.out.println("Player " + winner + " Won! ");
				
			Move move = pickRemovableMove(loser);
			if (move.player == -99) { System.out.println("Training Complete! Games: " + i); return; }
			else if (move.player <= -1){ throw new Exception("Invalid Move"); }
				
			System.out.println("Invalidating " + move);
			invalidateMove(move);
			System.out.println(cups.get(move.cup));
			
			
			System.out.println(players[0]);
			System.out.println(players[1]);
			
			resetGame();
			
		}
		
		System.out.println("Training Incomplete! Ran " + NUM_OF_GAMES + " Games");
		
		//System.out.println(this);
	}
	
	public String toString() {
		String output = " ";
		
		for (Cup cup : cups) {
			output += (cup + ", ");
		}
		
		return output.substring(0, output.length()-2);
	}
	
	public static void main(String[] args) throws Exception {
		DixieCups cupgame = new DixieCups();
		System.out.println(cupgame);
		cupgame.train();
		System.out.println(cupgame);
	}
	
}