package com.martin_bolton_macdonald;

import java.util.*;

public class GameClass{
	
	private List<GameChoices> gameChoiceList = Arrays.asList(GameChoices.values());
	private int gamesWon;
	private int gamesCompleted;
	private boolean gameWon;
	
	public List<GameChoices> getGameChoiceList(){
		return gameChoiceList;
	}
	
	public int checkGameResult(GameChoices myChoice, GameChoices theirChoice){
		
		if(myChoice == theirChoice) return 0;
		
		gamesCompleted++;
		
		switch(myChoice){
			case ROCK:
				if(theirChoice == GameChoices.PAPER || theirChoice == GameChoices.SPOCK) return 2; 
				break;
			case PAPER:
				if(theirChoice == GameChoices.SCISSORS || theirChoice == GameChoices.LIZARD) return 2; 
				break;
			case SCISSORS: 
				if(theirChoice == GameChoices.ROCK || theirChoice == GameChoices.SPOCK) return 2; 
				break;
			case LIZARD:
				if(theirChoice == GameChoices.ROCK || theirChoice == GameChoices.SCISSORS) return 2; 
				break;
			case SPOCK:
				if(theirChoice == GameChoices.PAPER || theirChoice == GameChoices.LIZARD) return 2; 
				break;
		}
		
		gamesWon++;
		
		return 1;
		
	}
	
	public int getGamesWon(){
		return gamesWon;
	}
	
	public int getGamesCompleted(){
		return gamesCompleted;
	}
	
	public boolean gameFinished(int targetScore, int maxNoOfGames){
		
		if (gamesWon == targetScore){
			gameWon = true;
			return true;
		}else if(gamesCompleted == maxNoOfGames){
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
		gamesCompleted = 0;
	}
	
}