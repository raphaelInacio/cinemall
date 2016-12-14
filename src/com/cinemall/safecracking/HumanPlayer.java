package com.cinemall.safecracking;

import static java.lang.System.out;

import java.util.Scanner;

public class HumanPlayer extends Player {

	private static int playerNumber = 1;
	
	public HumanPlayer() {
		super("Player " + playerNumber);
	}
	
	@Override
	public String guess() {
		//return "8888";
		return getInputFromKeyboard();
	}
	
	
	private String getInputFromKeyboard(){
		
		while(true){

			@SuppressWarnings("resource")  //never close System.in!
			Scanner s = new Scanner(System.in);				
			
			try {
				out.println("Please enter your Guess, four numeric digits:");
				String guess = s.nextLine();
	
				if (guess.trim().length() < 4){
					continue;
				}
				
				//check digits
				Integer.parseInt(guess);
								
				return guess;

			} catch (Exception e) {
				//e.printStackTrace();
				continue;
			}	
		}
	}

	@Override
	public void learnFromGuess(GuessResult result) {

		//printGuessResult(result);
		
		out.println("[Guess Again, is not:] " + result.getGuess());
		
	}

}
