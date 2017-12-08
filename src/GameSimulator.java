package com.martin_bolton_macdonald;

import java.util.*;

public class GameSimulator{
	
	private List<GameChoices> gameChoiceList = Arrays.asList(GameChoices.values());
	
	private int checkGameResult(GameChoices myChoice, GameChoices theirChoice){
		
		int myChoicePos = myChoice.ordinal();
		int theirChoicePos = theirChoice.ordinal();
		int sumOfChoices = myChoicePos + theirChoicePos;
		
		System.out.println(myChoicePos);
		System.out.println(theirChoicePos);
		
		switch(myChoicePos){
			case 0: if(sumOfChoices == 1 || sumOfChoices == 4) return 2; break;
			case 1:	if(sumOfChoices == 3 || sumOfChoices == 4) return 2; break;
			case 2:	if(sumOfChoices == 2 || sumOfChoices == 6) return 2; break;
			case 3:	if(sumOfChoices == 3 || sumOfChoices == 5) return 2; break;
			case 4:	if(sumOfChoices == 5 || sumOfChoices == 7) return 2; break;
		}
		
		return 1;
		
	}
	
	public static void main(String[] args){
		
		GameSimulator gameSim = new GameSimulator();
		
		System.out.println(gameSim.checkGameResult(gameSim.gameChoiceList.get(new Random().nextInt(gameSim.gameChoiceList.size() - 1)), gameSim.gameChoiceList.get(new Random().nextInt(gameSim.gameChoiceList.size() - 1))));
		
	}
	
}