package com.martin_bolton_macdonald;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class GameSimulator extends JFrame{
	
	private GameClass gameClass = new GameClass();
	private JLabel myChoiceLabel;
	private JLabel theirChoiceLabel;
	private JLabel gamesWonLabel;
	private JLabel gamesLostLabel;
	
	public GameSimulator(){
		initComponents();
	}
	
	public static void main(String[] args){
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				new GameSimulator().setVisible(true);
			}
		});
		
	}
	
	public void initComponents(){
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Rock, Paper, Scissors, Lizard, Spock Game");
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		JPanel scorePanel = new JPanel();
		scorePanel.setLayout(new GridLayout(1, 2));
		
		gamesWonLabel = new JLabel("WON: " + 0);
		gamesLostLabel = new JLabel("LOST: " + 0);
		
		scorePanel.add(Box.createVerticalStrut(1));
		scorePanel.add(gamesWonLabel);
		scorePanel.add(Box.createVerticalStrut(1));
		scorePanel.add(gamesLostLabel);
		
		JPanel choicePanel = new JPanel();
		choicePanel.setLayout(new GridLayout(1,5));
		choicePanel.add(Box.createVerticalStrut(10));
				
		JButton[] buttonArray = new JButton[5];
		ButtonModel[] buttonModelArray = new ButtonModel[5];
		myChoiceLabel = new JLabel("xxx");
		theirChoiceLabel = new JLabel("xxx");
		
		
		for (int i = 0; i < gameClass.getGameChoiceList().size(); i++){
			buttonArray[i] = new JButton();
			buttonArray[i].setText(gameClass.getGameChoiceList().get(i).name());
			buttonModelArray[i] = buttonArray[i].getModel();
			buttonModelArray[i].addChangeListener(new ChangeListener(){
				
				@Override
				public void stateChanged(ChangeEvent e){
					ButtonModel buttonModel = (ButtonModel) e.getSource();
					int position = Arrays.asList(buttonModelArray).indexOf(buttonModel);
					if (buttonModel.isPressed()){
						Random rand = new Random();
						int otherPosition = rand.nextInt(gameClass.getGameChoiceList().size());
						updateChoiceLabels(position, otherPosition);
						updateScoreLabel(gameClass.checkGameResult(gameClass.getGameChoiceList().get(position), gameClass.getGameChoiceList().get(otherPosition)));
					};
				}
				
			});
			choicePanel.add(buttonArray[i]);
			if (i < gameClass.getGameChoiceList().size() - 1){
				choicePanel.add(Box.createVerticalStrut(1));
			}
		}
		
		choicePanel.add(Box.createVerticalStrut(10));
		mainPanel.add(Box.createVerticalStrut(30));
		mainPanel.add(scorePanel);
		mainPanel.add(Box.createVerticalStrut(30));
		mainPanel.add(choicePanel);
		mainPanel.add(Box.createVerticalStrut(30));
		mainPanel.add(myChoiceLabel);
		mainPanel.add(Box.createVerticalStrut(30));
		mainPanel.add(theirChoiceLabel);
		mainPanel.add(Box.createVerticalStrut(30));
		add(mainPanel);
		
		pack();
		
	}
	
	public void updateChoiceLabels(int position, int otherPosition){
		
		myChoiceLabel.setText(gameClass.getGameChoiceList().get(position).name());
		theirChoiceLabel.setText(gameClass.getGameChoiceList().get(otherPosition).name());
		
	}
	
	public void updateScoreLabel(int score){
		if (score == 1){
			gamesWonLabel.setText("WON: " + gameClass.getGamesWon());
		} else if (score == 2){
			gamesLostLabel.setText("LOST: " + gameClass.getGamesLost());
		}
	}
	
}