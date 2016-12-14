package com.cinemall.safecracking;

public class GuessResult {
	
	private String guess;
	private int digitsFound;
	private int positionsOk;
	
    public GuessResult(String guess, int digitsFound, int positionsOk) {
		this.guess = guess;
		this.digitsFound = digitsFound;
		this.positionsOk = positionsOk;
	}

    public GuessResult(){}
    
	public String getGuess() {
		return guess;
	}

	public void setGuess(String guess) {
		this.guess = guess;
	}

	public int getDigitsFound() {
		return digitsFound;
	}

	public void setDigitsFound(int digitsFound) {
		this.digitsFound = digitsFound;
	}

	public int getPositionsOk() {
		return positionsOk;
	}

	public void setPositionsOk(int positionsOk) {
		this.positionsOk = positionsOk;
	}
	
    
    
    
}
