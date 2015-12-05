package com.syntacticsugar.vooga.gameplayer.attribute.movement;

import java.awt.Point;
import java.util.Collection;
import java.util.List;
import java.util.Observable;

import com.syntacticsugar.vooga.authoring.parameters.DoubleParameter;
import com.syntacticsugar.vooga.authoring.parameters.IEditableParameter;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.Direction;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;
import com.syntacticsugar.vooga.util.pathfinder.PathFinder;

import javafx.geometry.Point2D;

public class AIMovementAttribute extends AbstractMovementAttribute {

	private PathFinder pathFinder;
	private List<Point> myPath;
	private Point myNextTile;
	
	private int myFrameCount;
	private int myPathUpdateRate; // TODO: Move into a resource file
	
	public AIMovementAttribute() {
		super(new DoubleParameter(0.0, "AISpeed: "));
		
		// update currentTile
		myFrameCount = 0;
		myPathUpdateRate = 20;
	}
	
	private void generatePath(IGameUniverse universe) {
		IGameMap map = universe.getMap();
		List<Point> ends = map.getDestinationPoints();
		
		pathFinder = new PathFinder(map.isWalkable(), myCurrentTile, ends);
		myPath = pathFinder.getPath();
	}
	
	private Point nextPoint() {
		myNextTile = new Point(pathFinder.getNext());
		return pathFinder.getNext();
	}

	@Override
	public void updateSelf(IGameUniverse universe) {
		// every n frames, run generatePath(universe);
		if (myFrameCount % myPathUpdateRate == 0) {
			generatePath(universe);
		}
			
		setNextDestination(universe.getMap());
		move(universe);
		myFrameCount++;
	}
	
	private void setNextDestination(IGameMap map) {
		
		if (isInsideTile(map)) {
			myNextTile = nextPoint();
		}
		if (myNextTile == null) {
			return;
		}
		
		Direction dir = getNewDirection();
		setDirection(dir);
		
		// ISimpleBoundingBox box = getParent().getBoundingBox();
		// Point2D oldPoint = box.getPoint();
		// convert nextPoint to Point2D
		// if (distance from nextPoint is greater than xVelocity + yVelocity) {
		// 		box.setPoint(new Point2D(oldPoint.getX() + xVelocity, oldPoint.getY() + yVelocity));
		// } else {
		//		box.setPoint(nextPointX, nextPointY);
		// }
		// box.setPoint(new Point2D(oldPoint.getX() + xVelocity, oldPoint.getY() + yVelocity));
		System.out.println(String.format("X Velocity: %d   Y Velocity: %d", getXVelocity(), getYVelocity()));
	}
	
	private Boolean isInsideTile(IGameMap map) {
		Boolean result = false;

		Point2D point = getParent().getBoundingBox().getPoint();
		Point2D tile = map.getCoordinateFromMapIndex(myNextTile);
		Boolean xLeft = point.getX() > tile.getX();
		Boolean xRight = point.getX() + getParent().getBoundingBox().getWidth() < tile.getX() + map.getTileSize();
		Boolean yBot = point.getY() > tile.getY();
		Boolean yTop = point.getY() + getParent().getBoundingBox().getHeight() < tile.getY() + map.getTileSize();
		if (xLeft && xRight && yBot && yTop) {
			result = true;
		}
		
		return result;
	}
	
	private Direction getNewDirection() {
		if (myCurrentTile.x < myNextTile.x) {
			return Direction.RIGHT;
		}
		else if (myCurrentTile.x > myNextTile.x) {
			return Direction.LEFT;
		}
		else if (myCurrentTile.y < myNextTile.y) {
			return Direction.UP;
		}
		else if (myCurrentTile.y > myNextTile.y) {
			return Direction.DOWN;
		}
		return Direction.STOP;
	}



}
