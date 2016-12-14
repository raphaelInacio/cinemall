package com.cinemall.safecracking;

import static java.lang.System.out;

public abstract class Player {
	
	private String name;
	private int guessCount = 0;
		
	public Player(String name) {
		this.name = name;
	}

	public abstract String guess();
	public abstract void learnFromGuess(GuessResult result) ;

	public String nextGuess(){
		this.guessCount++;
		
		return guess();
		
	};
	
	public String getName(){
		return this.name;
	}
	
	public int getGuessCount(){
		return this.guessCount;
	}
	
	
	protected void printGuessResult(GuessResult result) {
		out.println();
		out.println("*** Guess Result ****");
		out.println("Guess: " + result.getGuess());
		out.println("Digits found: " + result.getDigitsFound());
		out.println("Digits in the right position: " + result.getPositionsOk());
		out.println("*********************");
		out.println();
	}
	

}
