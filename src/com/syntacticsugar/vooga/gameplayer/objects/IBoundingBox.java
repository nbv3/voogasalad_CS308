package com.syntacticsugar.vooga.gameplayer.objects;

import javafx.geometry.Point2D;

public interface IBoundingBox {

	public Point2D getPoint();
	
	public double getWidth();
	
	public double getHeight();
	
	public void setPoint(Point2D point);
	
	public void setWidth(double width);
	
	public void setHeight(double height);
	
}
