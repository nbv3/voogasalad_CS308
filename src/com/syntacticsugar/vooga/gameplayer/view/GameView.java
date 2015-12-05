package com.syntacticsugar.vooga.gameplayer.view;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class GameView extends Pane {
	
	private double mySize;
	
	public GameView(double size){
		this.getStylesheets().add("/com/syntacticsugar/vooga/gameplayer/view/css/game.css");
		this.setFocusTraversable(true);
		mySize = size;
	}

	public double getScalingFactor(){
		return (1.0/1000)*mySize;
	}

	public void addViewElement(Node myViewPane) {
		this.getChildren().add(myViewPane);
	}
	
	public void removeViewElement(Node myViewPane){
		this.getChildren().remove(myViewPane);
	}


}
