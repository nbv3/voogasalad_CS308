package com.syntacticsugar.vooga.gameplayer.view.implementation;

import java.util.Observable;
import java.util.Observer;

import com.syntacticsugar.vooga.gameplayer.view.DataBox;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class InformationBox extends DataBox implements Observer{
	
	private Label myScore;
	
	public InformationBox(){
		super("GameStatistics");
		Label scoreTitle = new Label("Score:  ");
		myScore = new Label("0");
		addContent(scoreTitle);
		addContent(myScore);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		int score = (int) arg1;
		myScore.setText(Integer.toString(score));
		
	}
	

}
