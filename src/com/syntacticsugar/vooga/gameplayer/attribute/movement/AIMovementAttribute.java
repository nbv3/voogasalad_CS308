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

	public AIMovementAttribute(double speed) {
		super(speed);
		myNextTile = new Point(-1, -1);
	}

	@Override
	public void updateSelf(IGameUniverse universe) {
		IGameMap map = universe.getMap();
		List<Point> ends = map.getDestinationPoints();
		
		if (myNextTile.equals(new Point(-1, -1))) {
			System.out.println("First time calculating path");
			// path has never been calculated
			// calculate path
			try {
				myCurrentTile = map.getMapIndexFromCoordinate(getParent().getBoundingBox().getPoint());
				System.out.println(myCurrentTile);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PathFinder pathFinder = new PathFinder(map.isWalkable(), myCurrentTile, ends);
			myNextTile = pathFinder.getNext();
			System.out.println("First time next tile: " + myNextTile.toString());
			return;
		}

		if (ends.contains(myCurrentTile)) {
			//System.out.println("Reached destination");
			// reached destination
			setDirection(Direction.STOP);
			setVelocity(Direction.STOP);
			return;
		}

		if (myNextTile.equals(myCurrentTile)) {
			System.out.println("No path available");
			// no path available
			setDirection(Direction.STOP);
			setVelocity(Direction.STOP);
			return;
		}

		// not at destination yet but close
		if (closeToNextTile(map)) {
			System.out.println("close recalculate");
			System.out.println("currentPoint: "+myCurrentTile.toString() + "\tnextTile: "+myNextTile.toString());

			// move straight to nextmap
			getParent().setPoint(universe.getMap().getCoordinateFromMapIndex(myNextTile));
			myCurrentTile = new Point(myNextTile);
			// recalculate next tile
			PathFinder pathFinder = new PathFinder(map.isWalkable(), myCurrentTile, ends);
			myNextTile = pathFinder.getNext();

			Direction moveDirection = getNewDirection();
			setDirection(moveDirection);
			setVelocity(getDirection());
			System.out.println("recalculated currentPoint: "+myCurrentTile.toString() + "\tnextTile: "+myNextTile.toString());
			return;
		}

		// move along direction
		Direction moveDirection = getNewDirection();
		setDirection(moveDirection);
		setVelocity(getDirection());
		move(universe);
	}

	private boolean closeToNextTile(IGameMap map) {
		Point2D currentPoint = getParent().getPoint();
		Point2D nextPoint = map.getCoordinateFromMapIndex(myNextTile);
		return currentPoint.distance(nextPoint) <= 1.5 * getSpeed(); // <= or bigger
																// ratio
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
