package view;

import java.util.Observable;

import javafx.geometry.Point2D;

public class BoundingBox extends Observable {

	private Point2D myPoint;
	private double myWidth;
	private double myHeight;
	
	public BoundingBox(Point2D p, double width, double height) {
		this.myPoint = p;
		this.myWidth = width;
		this.myHeight = height;
	}
	
	public Point2D getPoint() {
		return this.myPoint;
	}
	
	public double getWidth() {
		return this.myWidth;
	}
	
	public double getHeight() {
		return this.myHeight;
	}
	
	public void setPoint(double x, double y) {
		this.myPoint = new Point2D(x, y);
		triggerViewUpdate();
	}
	
	public void setWidth(double width) {
		this.myWidth = width;
		triggerViewUpdate();
	}
	
	public void setHeight(double height) {
		this.myHeight = height;
		triggerViewUpdate();
	}
	
	private void triggerViewUpdate() {
		setChanged();
		notifyObservers();
	}
	
}
