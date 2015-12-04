package com.syntacticsugar.vooga.gameplayer.view.implementation;

import java.util.Observable;
import java.util.Observer;

import com.syntacticsugar.vooga.gameplayer.view.DataBox;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class InformationBox extends DataBox implements Observer {

	private Label myScore;
	private static final String text = "Score: ";

	public InformationBox() {
		myScore = new Label("Score: 0");
		myScore.getStyleClass().add("title");
		Button startButton = new Button("Start Wave");
		startButton.setAlignment(Pos.CENTER);
		startButton.setMaxHeight(Double.MAX_VALUE);
		startButton.setOnMouseClicked(e -> beginWave());
		addContent(startButton, myScore);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		int score = (int) arg1;
		myScore.setText(text + " " + Integer.toString(score));

	}
	
	private void beginWave(){
		//Implement
	}

}
