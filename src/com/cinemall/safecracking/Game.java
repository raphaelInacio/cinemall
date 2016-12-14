package com.cinemall.safecracking;

import static java.lang.System.out;

public class Game {

	public static final int CODE_SIZE		=	4;
	private static final int CODE_SIZE_MASK	=	1000;

	private Player[] players;
	private String safeCode;
	private char[] parts = new char[CODE_SIZE];
	private int turn = 0;

	public void start(int iaPlayers, int humanPlayers){
		
		initAlizePlayers(iaPlayers, humanPlayers);
		generateSafeCode();
		play();
		
	}

	private void play() {
		
		for(turn = 0;turn <= players.length; turn++){
			
			if (turn == players.length){
				turn = 0;
			}
			
			String guess = players[turn].nextGuess();
			
			//out.println("[" + players[turn].getName() + "] " + guess);
			
			GuessResult result = checkGuess(players[turn], guess);
					
			players[turn].learnFromGuess(result);
		
		}
	}

	private GuessResult checkGuess(Player player, String guess) {

		if (safeCode.equals(guess)){
			finishWinner(player, guess);
			return null;
		}
		
		int digitsFound = 0;
		int positionsOk = 0;
		
		for(int i=0; i< CODE_SIZE; i++){
			if (guess.charAt(i) == this.parts[i]){
				positionsOk++;
			}
			
			for(int j=0; j < CODE_SIZE; j++){
				if (guess.charAt(i) == this.parts[j]){
					digitsFound++;
				}
			}
		}
		
		GuessResult result = new GuessResult(guess, digitsFound, positionsOk);
		
		return result;
		
	}

	private void finishWinner(Player player, String guess) {

		out.println();
		out.println("***************");
		out.println("*** Winner ****");
		out.println("Player: " + player.getName());
		out.println("Code: " + guess);
		out.println("Guesses: " + player.getGuessCount());
		out.println("***************");
		out.println();
		
		System.exit(0);

	}

	private void generateSafeCode() {
		
		int code = (int) (Math.random() * CODE_SIZE_MASK);
		
		this.safeCode = fixCode(code);
		//System.out.println(this.safeCode);
		//int code = 1234;

		this.parts = this.safeCode.toCharArray();
		
	}

	private String fixCode(int code) {
		
		String _code = code + "";
		
		while(_code.length() < CODE_SIZE){
			_code = "0" + _code;
		}
		
		return _code;
	}

	private void initAlizePlayers(int iaPlayers, int humanPlayers) {
		
		this.players = new Player[iaPlayers + humanPlayers];
		
		int position = 0;
				
		for(int i=0; i<humanPlayers; i++){
			this.players[position++] = new HumanPlayer();
		}
		
		for(int i=0; i<iaPlayers; i++){
			this.players[position++] = new IAPlayer();
		}

	}
	
	public static void main (String ...  args){
		new Game().start(1, 1);
	}
	
	
}
