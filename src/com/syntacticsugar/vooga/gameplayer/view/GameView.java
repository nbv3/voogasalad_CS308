package com.syntacticsugar.vooga.gameplayer.view;

import java.util.Collection;
import java.util.Observer;

import com.syntacticsugar.vooga.gameplayer.universe.IEventPoster;
import com.syntacticsugar.vooga.gameplayer.universe.IUniverseView;
import com.syntacticsugar.vooga.gameplayer.view.implementation.InformationBox;
import com.syntacticsugar.vooga.gameplayer.view.implementation.TileView;
import com.syntacticsugar.vooga.xml.data.ObjectData;
import com.syntacticsugar.vooga.xml.data.TowerData;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class GameView extends BorderPane{
	
	private double mySize;
	private Pane gameField;
	private InformationBox myInfoBox; 
	private TowerControlSection myTowerBox;
	
	public GameView(double size){
		this.getStylesheets().add("/com/syntacticsugar/vooga/gameplayer/view/css/game.css");
		this.setFocusTraversable(true);
		mySize = size;
		initializeComponents();
	}
	
	public void resetComponents(){
		this.getChildren().clear();
		initializeComponents();
	}

	private void initializeComponents() {
		gameField = new Pane();
		this.setCenter(gameField);
		myTowerBox = new TowerControlSection();
		this.setRight(myTowerBox.getContent());
		myInfoBox = new InformationBox();
		this.setBottom(myInfoBox);
	}

	public double getScalingFactor(){
		return (1.0/1000)*mySize;
	}

	public void addObjectView(Pane myViewPane) {
		gameField.getChildren().add(myViewPane);
	}
	
	public void removeObjectView(Pane myViewPane){
		gameField.getChildren().remove(myViewPane);
	}

	public Pane getView() {
		return gameField;
	}
	
	public void initializeTowerTileObserver(TileView tile){
		myTowerBox.addObserver(tile);
		tile.addObserver(myTowerBox);
	}

	public void initializeAvailableTowers(Collection<TowerData> availableTowers, IUniverseView universe, IEventPoster poster) {
		myTowerBox.initialize(availableTowers, universe, poster);
		
	}

	public Observer getScoreBox() {
		return myInfoBox;
	}
}
