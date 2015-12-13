// This entire file is part of my masterpiece.
// 
package com.syntacticsugar.vooga.gameplayer.view;

import java.util.Observable;
import java.util.Observer;

import com.syntacticsugar.vooga.gameplayer.objects.BoundingBox;
import com.syntacticsugar.vooga.gameplayer.view.gameview.IScalingFactorContainer;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class ObjectView extends Observable implements Observer {
	
	private Pane myViewPane;
	private double scalingFactor;
	private Point2D originalCoordinates;
	
	public ObjectView(String path, BoundingBox box , IScalingFactorContainer myContainer) {
		initializeParameters(box, myContainer);
		initializeImageView(path, box, myContainer);
		box.addObserver(this);
	}

	private void initializeImageView(String path, BoundingBox box, IScalingFactorContainer myContainer) {
		ImageView iv = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(path)));
		iv.setFocusTraversable(true);
		applyTransform(box);
		iv.setFitHeight(scalingFactor*box.getWidth());
		iv.setFitWidth(scalingFactor*box.getHeight());
		myViewPane.getChildren().add(iv);
		myContainer.addObjectView(myViewPane);
	}

	private void initializeParameters(BoundingBox box, IScalingFactorContainer myContainer) {
		myViewPane = new StackPane();
		originalCoordinates = new Point2D(box.getPoint().getX(), box.getPoint().getY());
		scalingFactor = myContainer.getScalingFactor();
	}

	@Override
	public void update(Observable obs, Object arg1) {
		BoundingBox box = (BoundingBox) obs;
		applyTransform(box);
	}
	
	private void applyTransform(BoundingBox box) {
		double xCoordinate = box.getPoint().getX()*scalingFactor;
		double yCoordinate = box.getPoint().getY()*scalingFactor;
		myViewPane.relocate(xCoordinate, yCoordinate);
		myViewPane.setRotate(box.getRotate());
	}
	
	public Pane getViewPane(){
		return myViewPane;
	}
	
	public Point2D getOriginalCoordinates(){
		return originalCoordinates;
	}

}
