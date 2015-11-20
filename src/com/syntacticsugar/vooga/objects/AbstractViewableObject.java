package com.syntacticsugar.vooga.objects;

import javafx.geometry.Point2D;

public abstract class AbstractViewableObject implements IViewableObject{
	
	private BoundingBox myBoundingBox;
	private String myPath;
	private int myID;
	
	public AbstractViewableObject(Point2D point, double width, double height, String path, int id){
		myBoundingBox = new BoundingBox(point, width, height);
		myPath = path;
		myID = id;
	}
	
	@Override
	public BoundingBox getBoundingBox(){
		return myBoundingBox;
	}
	
	@Override
	public String getPath(){
		return myPath;
	}

	@Override 
	public int returnID(){
		return myID;
	}
	
}
