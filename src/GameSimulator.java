package com.martin_bolton_macdonald;

import java.util.*;

public class GameSimulator{
	
	private List<GameChoices> gameChoiceList = Arrays.asList(GameChoices.values());
	
	private int checkGameResult(GameChoices myChoice, GameChoices theirChoice){

		if(myChoice == theirChoice) return 0;
		
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
		
		return 1;
		
	}
	
	public static void main(String[] args){
		
		GameSimulator gameSim = new GameSimulator();
		
		System.out.println(gameSim.checkGameResult(gameSim.gameChoiceList.get(new Random().nextInt(gameSim.gameChoiceList.size() - 1)), gameSim.gameChoiceList.get(new Random().nextInt(gameSim.gameChoiceList.size() - 1))));
		
	}
	
}