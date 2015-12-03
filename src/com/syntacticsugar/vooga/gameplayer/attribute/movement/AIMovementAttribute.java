package com.syntacticsugar.vooga.gameplayer.attribute.movement;

import java.awt.Point;
import java.util.List;

import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.Direction;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;
import com.syntacticsugar.vooga.util.pathfinder.PathFinder;

import javafx.geometry.Point2D;

public class AIMovementAttribute extends AbstractMovementAttribute {

	private Point myNextTile;
	boolean reachedNext;
	
	public AIMovementAttribute(double speed) {
		super(speed);
		reachedNext = true;
	}

	@Override
	public void updateSelf(IGameUniverse universe) {
		if (!reachedNext) {
			// move along line from transformed currentTile to transformed nextTile
			Direction moveDirection = getNewDirection();
			// move(universe);
			if (isPastNext()) {
				// set location to transformed nextTile
				reachedNext = true;
			}
		} else {
			reachedNext = false;
			IGameMap map = universe.getMap();
			List<Point> ends = map.getDestinationPoints();
			PathFinder pathFinder = new PathFinder(map.isWalkable(), myCurrentTile, ends);
			myNextTile = pathFinder.getNext();
		}
	}
	
	private boolean isPastNext() {
		// calculates if you are past myNextTile on the line from myCurrentTile to myNextTile
		return true;
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
