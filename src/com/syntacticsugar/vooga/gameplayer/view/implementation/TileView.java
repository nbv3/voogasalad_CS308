package com.syntacticsugar.vooga.gameplayer.view.implementation;

import java.util.Observable;

import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.Direction;
import com.syntacticsugar.vooga.gameplayer.objects.BoundingBox;
import com.syntacticsugar.vooga.gameplayer.view.DirectionArrows;
import com.syntacticsugar.vooga.gameplayer.view.GameView;
import com.syntacticsugar.vooga.gameplayer.view.ObjectView;
import com.syntacticsugar.vooga.gameplayer.view.TowerData;

import javafx.scene.layout.StackPane;

public class TileView extends ObjectView{
	
	private boolean walkable;
	private boolean selectMode;

	public TileView(String path, BoundingBox box, GameView myGameView, Boolean isPath) {
		super(path, box, myGameView);
		walkable = isPath;
		selectMode = false; 
		initializeHoverProperties();
	}

	private void initializeHoverProperties() {
		StackPane myPane = getViewPane();
		myPane.getChildren().get(0).setOnMouseClicked(e -> selected());
		myPane.getChildren().get(0).setOnMouseEntered(e -> changeOpacity(myPane, 0.75));
		myPane.getChildren().get(0).setOnMouseExited(e -> changeOpacity(myPane, 1));
	}
	
	private void changeOpacity(StackPane myPane, double value){
		if(!walkable && selectMode){
			myPane.setOpacity(value);
		}
	}
	
	private void selected(){
		if(!walkable && selectMode){
			chooseDirection();
			//setChanged();
			//notifyObservers(new Point2D(tempCoord1, tempCoord2));
		}
	}
	
	private void chooseDirection(){
		DirectionArrows myArrows = new DirectionArrows(this.getViewPane().getWidth(), this);
		myArrows.setLayoutX(getGameView().getScalingFactor()*this.tempCoord1 - this.getViewPane().getWidth());
		myArrows.setLayoutY(getGameView().getScalingFactor()*this.tempCoord2 - this.getViewPane().getWidth());
		getGameView().addViewElement(myArrows);
	}
	
	public void informTowerControl(Direction direction, DirectionArrows dirArrows){
		setChanged();
		TowerData towerData = new TowerData(tempCoord1, tempCoord2, direction);
		getGameView().removeViewElement(dirArrows);
		notifyObservers(towerData);
	}
	
	@Override 
	public void update(Observable arg0, Object arg1) {
		selectMode = (boolean) arg1;
	}

}
