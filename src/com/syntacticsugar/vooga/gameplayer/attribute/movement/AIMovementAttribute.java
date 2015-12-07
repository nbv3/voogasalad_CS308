package com.syntacticsugar.vooga.gameplayer.attribute.movement;

import java.awt.Point;
import java.io.Serializable;
import java.util.List;

import com.syntacticsugar.vooga.authoring.parameters.EditableClass;
import com.syntacticsugar.vooga.gameplayer.event.implementations.DestinationReachedEvent;
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
		//System.out.println(ends.toString());

		if (myNextTile.equals(new Point(-1, -1))) {
			// calculate path first time
			try {
				myCurrentTile = map.getMapIndexFromCoordinate(getParent().getBoundingBox().getPoint());
			} catch (Exception e) { }
			PathFinder pathFinder = new PathFinder(map.isWalkable(), myCurrentTile, ends);
			myNextTile = pathFinder.getNext();
			return;
		}
		if (ends.contains(myCurrentTile) ) {
			// reached destination or no path available
			stopDirection();
			universe.postEvent(new DestinationReachedEvent());
			return;
		}

		if ( myNextTile.equals(myCurrentTile)) {
			stopDirection();
			return;
		}

		if (closeToNextTile(map)) {
			// move straight to next tile
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
		//System.out.println(getParent().getPoint());
		Point2D nextPoint = map.getCoordinateFromMapIndex(myNextTile);
		//System.out.println("current: "+currentPoint.toString());
		//System.out.println("next  t: "+nextPoint.toString());
		return currentPoint.distance(nextPoint) <= 1.2 * getSpeed();
	}

	private void moveDirection() {
		Direction moveDirection = getNewDirection();
		setDirection(moveDirection);
		// setVelocity(getDirection()); WHY NOT THIS: TODO
		setVelocity(moveDirection);
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
