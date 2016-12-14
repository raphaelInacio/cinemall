package com.cinemall.safecracking;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

public class IAPlayer extends Player {
	
	private static int playerNumber = 1;
	
	private String	digitsFound		= "";
	
	private String	nextGuess = "0000";
	private int		lastDigitTryed = 0;

	private IAMode mode = IAMode.DISCOVERY;

	private List<String> calculatedGuesses;
	private int row;
	
	public IAPlayer() {
		super("IA Player " + playerNumber++);		
	}

	@Override
	public String guess() {	
		return  nextGuess;
	}
	
	@Override
	public void learnFromGuess(GuessResult result) {

		switch(mode){
			
			case DISCOVERY:
				learnDiscovery(result);
				break;

			case ANALYSIS:
				learnAnalysis(result);
				break;
		}		
				
	}

	private void learnAnalysis(GuessResult result) {
		
		if (this.calculatedGuesses == null){
			calculateGuesses();			
		}else{

			this.row++;
			
			if (this.row >= this.calculatedGuesses.size()){
				out.println("Something went very wrong!");
				System.exit(-1);
			}
		}
		
		this.nextGuess = this.calculatedGuesses.get(this.row);
		
	}

	private void calculateGuesses() {
		
		this.calculatedGuesses = new ArrayList<String>();
        permutation("", digitsFound);

	}
	

    private void permutation(String prefix, String str) {
    	
        int n = str.length();
        
        if (n == 0){
        	this.calculatedGuesses.add(prefix);
        }else {
            for (int i = 0; i < n; i++){
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
            }
        }

    }
	    
	
	private void learnDiscovery(GuessResult result) {

		if (result.getDigitsFound() > 0){
			digitsFound = digitsFound + lastDigitTryed;
		}
		
		if (result.getPositionsOk() > 1){
			
			for (int i = 1; i < result.getPositionsOk(); i++) {
				digitsFound = digitsFound + lastDigitTryed;
			}
			
		}
		
		if (digitsFound.length() == Game.CODE_SIZE){
			this.mode = IAMode.ANALYSIS;
			learnAnalysis(result);
			return;
		}

		setNextGuess();
		
	}

	private void setNextGuess() {
		
		lastDigitTryed++;
		
		StringBuilder guessBuilder = new StringBuilder();
		
		for (int i=0; i<Game.CODE_SIZE; i++ ){
			guessBuilder.append(lastDigitTryed);
		}

		this.nextGuess = guessBuilder.toString();

	}
}
