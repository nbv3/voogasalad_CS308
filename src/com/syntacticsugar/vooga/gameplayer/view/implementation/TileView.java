package com.syntacticsugar.vooga.gameplayer.view.implementation;

import java.util.Observable;

import com.syntacticsugar.vooga.gameplayer.attribute.movement.Direction;
import com.syntacticsugar.vooga.gameplayer.objects.BoundingBox;
import com.syntacticsugar.vooga.gameplayer.view.DirectionArrows;
import com.syntacticsugar.vooga.gameplayer.view.GameView;
import com.syntacticsugar.vooga.gameplayer.view.ISimpleGameView;
import com.syntacticsugar.vooga.gameplayer.view.ObjectView;
import com.syntacticsugar.vooga.gameplayer.view.TowerPlaceInfo;
import javafx.scene.layout.StackPane;

public class TileView extends ObjectView{
	
	private boolean walkable;
	private boolean selectMode;

	public TileView(String path, BoundingBox box, GameView myGameView, Boolean isPath) {
		super(path, box, myGameView);
		walkable = isPath;
		selectMode = false; 
		initializeHoverProperties(myGameView);
	}

	private void initializeHoverProperties(ISimpleGameView myGameView) {
		StackPane myPane = getViewPane();
		myPane.getChildren().get(0).setOnMouseClicked(e -> selected(myGameView));
		myPane.getChildren().get(0).setOnMouseEntered(e -> changeOpacity(myPane, 0.75));
		myPane.getChildren().get(0).setOnMouseExited(e -> changeOpacity(myPane, 1));
	}
	
	private void changeOpacity(StackPane myPane, double value){
		if(!walkable && selectMode){
			myPane.setOpacity(value);
		}
	}
	
	private void selected(ISimpleGameView myGameView){
		if(!walkable && selectMode){
			chooseDirection(myGameView);
			//setChanged();
			//notifyObservers(new Point2D(tempCoord1, tempCoord2));
		}
	}
	
	private void chooseDirection(ISimpleGameView myGameView){
		DirectionArrows myArrows = new DirectionArrows(this, myGameView);
		myArrows.setLayoutX(myGameView.getScalingFactor()*this.tempCoord1 - this.getViewPane().getWidth());
		myArrows.setLayoutY(myGameView.getScalingFactor()*this.tempCoord2 - this.getViewPane().getWidth());
		myGameView.addObjectView(myArrows);
	}
	
	public void informTowerControl(Direction direction, DirectionArrows dirArrows, ISimpleGameView gameView){
		setChanged();
		TowerPlaceInfo towerData = new TowerPlaceInfo(tempCoord1, tempCoord2, direction);
		gameView.removeObjectView(dirArrows);
		notifyObservers(towerData);
	}
	
	@Override 
	public void update(Observable arg0, Object arg1) {
		selectMode = (boolean) arg1;
	}

}
