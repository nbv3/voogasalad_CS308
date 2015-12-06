package com.syntacticsugar.vooga.gameplayer.view.implementation;

import java.util.Observable;
import java.util.Observer;

import com.syntacticsugar.vooga.gameplayer.view.DataBox;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class InformationBox extends DataBox implements Observer {

	private Label myScore;
	private final String text = "Score: ";
	private Button waveButton;

	public InformationBox() {
		myScore = new Label("Score: 0");
		myScore.getStyleClass().add("title");
		waveButton = new Button("Start Wave");
		waveButton.setAlignment(Pos.CENTER);
		waveButton.setMaxHeight(Double.MAX_VALUE);
		addContent(waveButton, myScore);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		int score = (int) arg1;
		myScore.setText(text + " " + Integer.toString(score));

	}
	
	public void setWaveButton(EventHandler<MouseEvent> onMouseClicked){
		waveButton.setOnMouseClicked(onMouseClicked);
	}

}
