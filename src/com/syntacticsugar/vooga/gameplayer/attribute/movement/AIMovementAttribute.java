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
			// move along line from transformed currentTile to transformed
			// nextTile
			move(universe);
			if (isPastNext(universe.getMap())) {
				// transform myNextPoint to raw double coordinate
				// set location to transformed nextTile
				getParent().setPoint(universe.getMap().getCoordinateFromMapIndex(myNextTile));
				reachedNext = true;
			}
		} else {
			reachedNext = false;
			IGameMap map = universe.getMap();
			List<Point> ends = map.getDestinationPoints();
			PathFinder pathFinder = new PathFinder(map.isWalkable(), myCurrentTile, ends);
			myNextTile = pathFinder.getNext();
			Direction moveDirection = getNewDirection();
			setDirection(moveDirection);
			setVelocity(moveDirection);
		}
	}
	
	private boolean isPastNext(IGameMap map) {
		// calculates if you are past myNextTile on the line from myCurrentTile to myNextTile
		Point2D centerPoint = getParent().getCenterPoint();
		Point2D destPoint = map.getCoordinateFromMapIndex(myNextTile);
		return centerPoint.distance(destPoint) <= getSpeed();
	}

	private Direction getNewDirection() {
		if (myCurrentTile.x < myNextTile.x) {
			return Direction.RIGHT;
		} else if (myCurrentTile.x > myNextTile.x) {
			return Direction.LEFT;
		} else if (myCurrentTile.y < myNextTile.y) {
			return Direction.UP;
		} else if (myCurrentTile.y > myNextTile.y) {
			return Direction.DOWN;
		}
		return Direction.STOP;
	}

}
