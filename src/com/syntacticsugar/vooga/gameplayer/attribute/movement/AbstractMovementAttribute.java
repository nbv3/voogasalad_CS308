package com.syntacticsugar.vooga.gameplayer.attribute.movement;

import java.util.ArrayList;
import java.util.List;

import com.syntacticsugar.vooga.gameplayer.attribute.AbstractAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.Direction;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.HDirection;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.IMover;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.VDirection;
import com.syntacticsugar.vooga.gameplayer.objects.IBoundingBox;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;

import javafx.geometry.Point2D;

public abstract class AbstractMovementAttribute extends AbstractAttribute implements IMover {
	
	private double xVelocity;
	private double yVelocity;
	private double mySpeed;
	
	public AbstractMovementAttribute(double speed) {
		super();
		resetVelocity();
		setSpeed(speed);
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
	public void setXVelocity(HDirection xDir) {
		this.xVelocity = 
				xDir.equals(HDirection.STOP) ? 
						0 : (xDir.equals(HDirection.RIGHT) ? mySpeed : -1.0*mySpeed);
	}
		
	@Override
	public void setYVelocity(VDirection yDir) {
		this.yVelocity = 
				yDir.equals(VDirection.STOP) ? 
						0 : (yDir.equals(VDirection.DOWN) ? mySpeed : -1.0*mySpeed);
	}
	
	@Override
	public void setRotate(double rotation) {
		this.getParent().getBoundingBox().setRotate(rotation);
	}
	
	@Override
	public void setDirection(Direction dir) {
		this.getParent().getBoundingBox().setDirection(dir);
	}
	
	@Override
	public void fixBounds(IGameUniverse universe) {
		IGameMap map = universe.getMap();
		List<Point2D> points = getPointsToCheck();
		System.out.println(points.size());
		if (points.size() == 0) {
			return;
		}
		Point2D mapPoint;
		Point2D mapPoint2;
		try {
			mapPoint = map.getMapIndexFromCoordinate(points.get(0));
			mapPoint2 = map.getMapIndexFromCoordinate(points.get(1));
		} catch (Exception e) {
			resetVelocity();
			return;
		}
		
		Boolean canWalkOne = map.isWalkable()[(int) mapPoint.getX()][(int) mapPoint.getY()];
		Boolean canWalkTwo = map.isWalkable()[(int) mapPoint2.getX()][(int) mapPoint2.getY()];
//		Boolean onMapOneX = (mapPoint.getX() >= 0 && mapPoint.getX() <= 1000); // TODO: 1000 to resource file
//		Boolean onMapOneY = (mapPoint.getY() >= 0 && mapPoint.getY() <= 1000); // TODO: 1000 to resource file
//		Boolean onMapTwoX = (mapPoint2.getX() >= 0 && mapPoint2.getX() <= 1000); // TODO: 1000 to resource file
//		Boolean onMapTwoY = (mapPoint2.getY() >= 0 && mapPoint2.getY() <= 1000); // TODO: 1000 to resource file
		
		
		if (!(canWalkOne && canWalkTwo)) {// || !(onMapOneX && onMapOneY && onMapTwoX && onMapTwoY)) {
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
			Point2D newPoint = point.add(getXVelocity(), 0);
			Point2D newPoint2 = point.add(getXVelocity(), getParent().getBoundingBox().getHeight());
			points.add(newPoint);
			points.add(newPoint2);
		}
		else if (XVel > 0) {
			Point2D newPoint = point.add(getXVelocity() + getParent().getBoundingBox().getWidth(), 0);
			Point2D newPoint2 = point.add(getXVelocity() + getParent().getBoundingBox().getWidth(), getParent().getBoundingBox().getHeight());
			points.add(newPoint);
			points.add(newPoint2);
		}
		else if (YVel < 0) {
			Point2D newPoint = point.add(0, getYVelocity());
			Point2D newPoint2 = point.add(getParent().getBoundingBox().getWidth(), getYVelocity());
			points.add(newPoint);
			points.add(newPoint2);
		}
		else if (YVel > 0) {
			Point2D newPoint = point.add(0, getYVelocity() + getParent().getBoundingBox().getHeight());
			Point2D newPoint2 = point.add(getParent().getBoundingBox().getWidth(), getYVelocity() + getParent().getBoundingBox().getHeight());
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
		box.setPoint(new Point2D(oldPoint.getX() + getXVelocity(), oldPoint.getY() + getYVelocity()));
	}
	
}
