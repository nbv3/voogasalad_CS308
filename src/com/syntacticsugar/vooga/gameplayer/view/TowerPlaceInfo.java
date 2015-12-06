package com.syntacticsugar.vooga.gameplayer.view;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.Direction;

import javafx.geometry.Point2D;

public class TowerPlaceInfo {
	
	private Point2D myCoordinates;
	private Direction myDirection;
	
	public TowerPlaceInfo(double x, double y, Direction direction){
		myCoordinates = new Point2D(x, y);
		myDirection = direction;
	}
	
	public Point2D getCoordinates(){
		return myCoordinates;
	}
	
	public Direction getDirection(){
		return myDirection; 
	}

}
