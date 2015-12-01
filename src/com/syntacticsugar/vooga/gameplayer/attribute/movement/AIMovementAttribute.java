package com.syntacticsugar.vooga.gameplayer.attribute.movement;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.Direction;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;
import com.syntacticsugar.vooga.gameplayer.utilities.Path;
import com.syntacticsugar.vooga.gameplayer.utilities.PathFinder;

import javafx.geometry.Point2D;

public class AIMovementAttribute extends AbstractMovementAttribute {

	private Path myPath;
	private Point myNextTile;
	
	private int myFrameCount;
	private int myPathUpdateRate; // TODO: Move into a resource file
	
	public AIMovementAttribute(double speed) {
		super(speed);
		
		// update currentTile
		myPath = new Path();
		
		myFrameCount = 0;
		myPathUpdateRate = 20;
	}
	
	private void generatePath(IGameUniverse universe) {
		IGameMap map = universe.getMap();
		List<Point> ends = map.getDestinationPoints();
		List<Point> starts = new ArrayList<>();
		starts.add(myCurrentTile);
		
		myPath = new PathFinder(map, map.getSize(), starts, ends).getPath();
	}
	
	private Point nextPoint() {
		int currentIndex = myPath.getList().indexOf(myCurrentTile);
		if (currentIndex == myPath.getList().size()-1 ) {
			return myPath.getDestination();
		} else {
			return myPath.getList().get(currentIndex+1);
		}
	}

	@Override
	public void updateSelf(IGameUniverse universe) {
		// every n frames, run generatePath(universe);
		myFrameCount++;
		if (myFrameCount % myPathUpdateRate == 0) {
			generatePath(universe);
		}
			
		setNextDestination(universe.getMap());
		move(universe);
	}
	
	private void setNextDestination(IGameMap map) {
		
		if (isInsideTile(map)) {
			myNextTile = nextPoint();
		}
		
		Direction dir = getDirection();
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
	
	private Direction getDirection() {
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
