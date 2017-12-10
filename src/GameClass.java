package com.martin_bolton_macdonald;

import java.util.*;

public class GameClass{
	
	private List<GameChoices> gameChoiceList = Arrays.asList(GameChoices.values());
	private int gamesWon;
	private int gamesLost;
	private boolean gameWon;
	private static final int TARGET_SCORE = 11;
	
	public List<GameChoices> getGameChoiceList(){
		return gameChoiceList;
	}
	
	public int checkGameResult(GameChoices myChoice, GameChoices theirChoice){
		
		if(myChoice == theirChoice) return 0;
		
		switch(myChoice){
			case ROCK:
				if(theirChoice == GameChoices.PAPER || theirChoice == GameChoices.SPOCK){gamesLost++; return 2;} 
				break;
			case PAPER:
				if(theirChoice == GameChoices.SCISSORS || theirChoice == GameChoices.LIZARD){gamesLost++; return 2;} 
				break;
			case SCISSORS: 
				if(theirChoice == GameChoices.ROCK || theirChoice == GameChoices.SPOCK){gamesLost++; return 2;}
				break;
			case LIZARD:
				if(theirChoice == GameChoices.ROCK || theirChoice == GameChoices.SCISSORS){gamesLost++; return 2;} 
				break;
			case SPOCK:
				if(theirChoice == GameChoices.PAPER || theirChoice == GameChoices.LIZARD){gamesLost++; return 2;} 
				break;
		}
		
		gamesWon++;
		
		return 1;
		
	}
	
	public int getGamesWon(){
		return gamesWon;
	}
	
	public int getGamesLost(){
		return gamesLost;
	}
	
	public boolean gameFinished(){
		
		if (gamesWon == TARGET_SCORE){
			gameWon = true;
			return true;
		}else if(gamesLost == TARGET_SCORE){
			gameWon = false;
			return true;
		}
		
		return false;
	}
	
	public boolean isGameWon(){
		return gameWon;
	}
	
	public void reset(){
		gamesWon = 0;
		gamesLost = 0;
		gameWon = false;
	}
	
}