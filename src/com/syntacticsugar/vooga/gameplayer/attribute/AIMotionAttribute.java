package com.syntacticsugar.vooga.gameplayer.attribute;

import java.awt.Point;

import com.syntacticsugar.vooga.gameplayer.attribute.movement.IMover;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.algs.IMovementSetter;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.algs.MoveRightCardinal;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.utilities.Path;

import javafx.geometry.Point2D;

public class AIMotionAttribute extends AbstractAttribute implements IMover {

	private double xVelocity;
	private double yVelocity;
	private double mySpeed;
	private Point2D currentLocation;
	private Point2D destinationLocation;
	
	private Path myPath;
	private Point2D currentTile;
	private Point2D nextTile;
	private Point2D destinationTile;
	
	private IMovementSetter myMover;
	
	public AIMotionAttribute(IGameObject parent) {
		super(parent);
		myMover = new MoveRightCardinal(); // DEFAULT RIGHT MOVEMENT TODO
		// currentLocation = parent.getBoundingBox().getPoint(); TODO
		
		// update currentTile
		myPath = new Path();
		setVelocity(0, 0);
		setSpeed(3);
	}
	
	@Override
	public void receiveEvent(IGameEvent event) {
		// TODO could be speed changes, make immobile for n seconds, etc.
	}
	
	private void generatePath(IGameUniverse universe) {
		// TODO
		/*
		 * Find destination point
		 */
		//destinationTile = universe.getDestinationPoint();
		
		/*
		 * Get boolean tileMap for path
		 */
		//Map<Point, Boolean> tileMap = universe.getTileMap();
		
		/*
		 * Find path
		 */
		//myPath = new PathFinder(tileMap, universe.getMapSize(), currentTile, destinationTile);
	}
	
	private Point nextPoint() {
		int currentIndex = myPath.getList().indexOf(currentTile);
		if (currentIndex == myPath.getList().size()-1 ) {
			return myPath.getDestination();
		} else {
			return myPath.getList().get(currentIndex+1);
		}
	}

	@Override
	public void updateSelf(IGameUniverse universe) {
		// every n frames, run generatePath(universe);
		
		// set new xVelocity, yVelocity
		// convert currentTile to double and subtract currentLocation
		// this difference is the velocity in the direction you want to go
		
		// move to nextPoint
		move();
	}
	
	@Override
	public void move() {
		Point nextPoint = nextPoint();
		// ISimpleBoundingBox box = getParent().getBoundingBox();
		// Point2D oldPoint = box.getPoint();
		// convert nextPoint to Point2D
		// if (distance from nextPoint is greater than xVelocity + yVelocity) {
		// 		box.setPoint(new Point2D(oldPoint.getX() + xVelocity, oldPoint.getY() + yVelocity));
		// } else {
		//		box.setPoint(nextPointX, nextPointY);
		// }
		// box.setPoint(new Point2D(oldPoint.getX() + xVelocity, oldPoint.getY() + yVelocity));
		System.out.println(String.format("X Velocity: %d   Y Velocity: %d", xVelocity, yVelocity));
	}
	
	@Override
	public double getSpeed() {
		return this.mySpeed;
	}

	@Override
	public void setSpeed(double speed) {
		this.mySpeed = speed;
	}
	
	@Override
	public void setVelocity(double xVel, double yVel) {
		setXVelocity(xVel);
		setYVelocity(yVel);
	}

	@Override
	public void setXVelocity(double xvel) {
		this.xVelocity = xvel;
	}
	
	@Override
	public void setYVelocity(double yvel) {
		this.yVelocity = yvel;
	}

}
