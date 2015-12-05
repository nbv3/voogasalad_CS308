package com.syntacticsugar.vooga.gameplayer.attribute.movement;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.syntacticsugar.vooga.gameplayer.attribute.AbstractAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.Direction;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.IMover;
import com.syntacticsugar.vooga.gameplayer.objects.IBoundingBox;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;

import javafx.geometry.Point2D;

public abstract class AbstractMovementAttribute extends AbstractAttribute implements IMover {
	
	private double xVelocity;
	private double yVelocity;
	private double mySpeed;
	
	protected Point myCurrentTile;
	
	public AbstractMovementAttribute(double speed) {
		super();
		resetVelocity();
		setSpeed(speed);
		myCurrentTile = new Point(0,0);
	}
	
	public double getXVelocity() {
		return new Double(xVelocity);
	}

	public double getYVelocity() {
		return new Double(yVelocity);
	}
	
	@Override
	public void resetVelocity() {
		this.xVelocity = 0;
		this.yVelocity = 0;
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
	public void setVelocity(Direction dir) {
		if (dir.equals(Direction.LEFT) || dir.equals(Direction.RIGHT)) {
			this.xVelocity = (dir.equals(Direction.RIGHT) ? mySpeed : -1.0*mySpeed);
			this.yVelocity = 0;
		}
		else if (dir.equals(Direction.DOWN) || dir.equals(Direction.UP)) {
			this.yVelocity = (dir.equals(Direction.DOWN) ? mySpeed : -1.0*mySpeed);
			this.xVelocity = 0;
		}
		else if (dir.equals(Direction.STOP)) {
			this.xVelocity = 0;
			this.yVelocity = 0;
		}
	}
	
	@Override
	public void setDirection(Direction dir) {
		this.getParent().getBoundingBox().setDirection(dir);
	}
	
	public Direction getDirection() {
		return this.getParent().getBoundingBox().getDirection();
	}
	
	private void fixBounds(IGameUniverse universe) {
		IGameMap map = universe.getMap();
		List<Point2D> points = getPointsToCheck();
		if (points.size() == 0) {
			return;
		}
		Point mapPoint;
		Point mapPoint2;
		try {
			mapPoint = map.getMapIndexFromCoordinate(points.get(0));
			mapPoint2 = map.getMapIndexFromCoordinate(points.get(1));
		} catch (Exception e) {
			resetVelocity();
			return;
		}
		
		Boolean canWalkOne = map.isWalkable()[mapPoint.x][mapPoint.y];
		Boolean canWalkTwo = map.isWalkable()[mapPoint2.x][mapPoint2.y];
		
		
		if (!(canWalkOne && canWalkTwo)) {
			resetVelocity();
		}
	}
	
	private List<Point2D> getPointsToCheck() {
		//Important: This only works for cardinal movement!
		Point2D point = getParent().getBoundingBox().getPoint();
		double XVel = getXVelocity();
		double YVel = getYVelocity();
		
		List<Point2D> points = new ArrayList<>();
		if (XVel < 0) {
			Point2D newPoint = new Point2D(point.getX() + getXVelocity(), point.getY());
			Point2D newPoint2 = new Point2D(point.getX() + getXVelocity(), point.getY() + getParent().getBoundingBox().getHeight());
			points.add(newPoint);
			points.add(newPoint2);
		}
		else if (XVel > 0) {
			Point2D newPoint = new Point2D(point.getX() + getXVelocity() + getParent().getBoundingBox().getWidth(), point.getY());
			Point2D newPoint2 = new Point2D(point.getX() + getXVelocity() + getParent().getBoundingBox().getWidth(), point.getY() + getParent().getBoundingBox().getHeight());
			points.add(newPoint);
			points.add(newPoint2);
		}
		else if (YVel < 0) {
			Point2D newPoint = new Point2D(point.getX(), point.getY() + getYVelocity());
			Point2D newPoint2 = new Point2D(point.getX() + getParent().getBoundingBox().getWidth(), point.getY() + getYVelocity());
			points.add(newPoint);
			points.add(newPoint2);
		}
		else if (YVel > 0) {
			Point2D newPoint = new Point2D(point.getX(), point.getY() + getYVelocity() + getParent().getBoundingBox().getHeight());
			Point2D newPoint2 = new Point2D(point.getX() + getParent().getBoundingBox().getWidth(), point.getY() + getYVelocity() + getParent().getBoundingBox().getHeight());
			points.add(newPoint);
			points.add(newPoint2);
		}
		
		return points;
	}
	
	@Override
	public abstract void updateSelf(IGameUniverse universe);
	
	@Override
	public void move(IGameUniverse universe) {
		fixBounds(universe);
		IBoundingBox box = getParent().getBoundingBox();
		Point2D oldPoint = box.getPoint();
		Point2D newPoint = new Point2D(oldPoint.getX() + getXVelocity(), oldPoint.getY() + getYVelocity());
		box.setPoint(newPoint);
	}
	
}
