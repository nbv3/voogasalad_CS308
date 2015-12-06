package com.syntacticsugar.vooga.gameplayer.attribute.movement;

import java.awt.Point;
import java.io.Serializable;
import java.util.List;

import com.syntacticsugar.vooga.authoring.parameters.EditableClass;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;
import com.syntacticsugar.vooga.util.pathfinder.PathFinder;

import javafx.geometry.Point2D;

@EditableClass(
		className = "AI Motion Attribute"
		)
public class AIMovementAttribute extends AbstractMovementAttribute implements Serializable{

	private static final long serialVersionUID = 1L;

	private Point myNextTile;

	public AIMovementAttribute() {
		super();
	}
	
	@Override
	protected void setDefaults() {
		super.setDefaults();
		myNextTile = new Point(-1, -1);
	}

	/**
	 * Moves towards the nearest location on the game map that has been
	 * flagged as a destination point.
	 */
	@Override
	public void updateSelf(IGameUniverse universe) {
		IGameMap map = universe.getMap();
		List<Point> ends = map.getDestinationPoints();

		if (myNextTile.equals(new Point(-1, -1))) {
			// path has never been calculated
			// calculate path
			try {
				myCurrentTile = map.getMapIndexFromCoordinate(getParent().getBoundingBox().getPoint());
			} catch (Exception e) {
				System.out.println("failed to fetch currentTile from map");
			}
			PathFinder pathFinder = new PathFinder(map.isWalkable(), myCurrentTile, ends);
			myNextTile = pathFinder.getNext();
			return;
		}

		if (ends.contains(myCurrentTile) || myNextTile.equals(myCurrentTile)) {
			// reached destination or no path available
			stopDirection();
			return;
		}

		// not at destination yet but close
		if (closeToNextTile(map)) {
			// move straight to nextmap
			getParent().setPoint(universe.getMap().getCoordinateFromMapIndex(myNextTile));
			myCurrentTile = new Point(myNextTile);
			// recalculate next tile
			PathFinder pathFinder = new PathFinder(map.isWalkable(), myCurrentTile, ends);
			myNextTile = pathFinder.getNext();

			moveDirection();
			return;
		}

		// move along direction
		moveDirection();
		move(universe);

	}

	private boolean closeToNextTile(IGameMap map) {
		Point2D currentPoint = getParent().getPoint();
		Point2D nextPoint = map.getCoordinateFromMapIndex(myNextTile);
		return currentPoint.distance(nextPoint) <= 1.2 * getSpeed();
	}
	
	private void moveDirection() {
		Direction moveDirection = getNewDirection();
		setDirection(moveDirection);
		setVelocity(getDirection());
	}
	
	private void stopDirection() {
		setDirection(Direction.STOP);
		setVelocity(Direction.STOP);
	}

	private Direction getNewDirection() {
		if (myCurrentTile.x < myNextTile.x) {
			return Direction.RIGHT;
		} else if (myCurrentTile.x > myNextTile.x) {
			return Direction.LEFT;
		} else if (myCurrentTile.y < myNextTile.y) {
			return Direction.DOWN;
		} else if (myCurrentTile.y > myNextTile.y) {
			return Direction.UP;
		}
		return Direction.STOP;
	}
}
