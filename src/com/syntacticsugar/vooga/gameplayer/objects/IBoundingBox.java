package com.syntacticsugar.vooga.gameplayer.objects;

import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.Direction;

import javafx.geometry.Point2D;

public interface IBoundingBox {

	public Point2D getPoint();
	
	public Direction getDirection();
	
	public double getRotate();
	
	public double getWidth();
	
	public double getHeight();
	
	public void setPoint(Point2D point);
	
	public void setDirection(Direction dir);
	
	public void setRotate(double rotation);
	
	public void setWidth(double width);
	
	public void setHeight(double height);

	
}
