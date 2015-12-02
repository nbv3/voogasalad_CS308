package com.syntacticsugar.vooga.gameplayer.view;

import java.util.concurrent.Callable;

import com.syntacticsugar.vooga.gameplayer.view.implementation.TileView;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class GameView extends BorderPane {
	
	private double mySize;
	private Pane gameField;
	private InformationBox myInfoBox; 
	private TowerBox myTowerBox;
	
	public GameView(double size){
		mySize = size;
//		this.setWidth(mySize);
//		this.setHeight(mySize);
		gameField = new Pane();
		this.setCenter(gameField);
		myTowerBox = new TowerBox();
		this.setRight(myTowerBox.getContent());
		myInfoBox = new InformationBox();
		this.setBottom(myInfoBox);
	}
	
	/**
	 * TODO: talk to backend to figure out this scaling situation
	 */
	
	public double getScalingFactor(){
		return (1.0/1000)*mySize;
	}

	public void addObjectView(Pane myViewPane) {
		gameField.getChildren().add(myViewPane);
	}

	public Pane getView() {
		return gameField;
	}
	
	public void initializeTowerTileObserver(TileView tile){
		myTowerBox.addObserver(tile);
	}

}
