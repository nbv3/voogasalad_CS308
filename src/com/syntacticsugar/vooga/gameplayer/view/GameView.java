package com.syntacticsugar.vooga.gameplayer.view;

import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.view.implementation.TileView;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class GameView extends BorderPane {
	
	private double mySize;
	private Pane gameField;
	private InformationBox myInfoBox; 
	private TowerBox myTowerBox;
	
	public GameView(double size){
		mySize = size;
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
		tile.addObserver(myTowerBox);
	}

	public void initializeAvailableTowers(Collection<ObjectData> availableTowers, IGameUniverse universe) {
		myTowerBox.initialize(availableTowers, universe);
		
	}

}
