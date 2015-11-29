package com.syntacticsugar.vooga.gameplayer.view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.Observable;
import java.util.Observer;

import com.syntacticsugar.vooga.gameplayer.objects.BoundingBox;

import javafx.scene.image.Image;

public class ObjectView implements Observer{
	
	private StackPane myViewPane;
	private double scalingFactor;
	
	public ObjectView(String path, BoundingBox box , GameView myGameView) {
		myViewPane = new StackPane();
		ImageView iv = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(path)));
		scalingFactor = myGameView.getScalingFactor();
		applyTransform(box);
		iv.setFitHeight(scalingFactor*box.getWidth());
		iv.setFitWidth(scalingFactor*box.getHeight());
		myViewPane.getChildren().add(iv);
		myGameView.getChildren().add(myViewPane);
		box.addObserver(this);
	}

	@Override
	public void update(Observable obs, Object arg1) {
		BoundingBox box = (BoundingBox) obs;
		// TODO Use the myTransform to scale the properties of 
		// the bounding box passed as box
		applyTransform(box);
	}
	
	private void applyTransform(BoundingBox box) {
		double xCoordinate = box.getPoint().getX()*scalingFactor;
		double yCoordinate = box.getPoint().getY()*scalingFactor;
		myViewPane.relocate(xCoordinate, yCoordinate);
		myViewPane.setRotate(box.getRotate());
	}
	
	public StackPane getViewPane(){
		return myViewPane;
	}

}
