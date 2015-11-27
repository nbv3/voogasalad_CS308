package com.syntacticsugar.vooga.gameplayer.view.implementation;

import javafx.scene.image.ImageView;

import java.util.Observable;
import java.util.Observer;

import com.syntacticsugar.vooga.gameplayer.objects.BoundingBox;

import javafx.scene.image.Image;

public class ObjectView implements Observer{
	

	private ImageView myImageView;
	private double[] scalingFactor;
	
	public ObjectView(String path, BoundingBox box , GameView myGameView) {
		this.myImageView = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(path)));
		scalingFactor = myGameView.getScalingFactor();
		applyTransform(box);
		myImageView.setFitHeight(scalingFactor[0]*box.getWidth());
		myImageView.setFitWidth(scalingFactor[1]*box.getHeight());
		myGameView.getChildren().add(myImageView);
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
		double xCoordinate = box.getPoint().getX()*scalingFactor[0];
		double yCoordinate = box.getPoint().getY()*scalingFactor[1];
		myImageView.relocate(xCoordinate, yCoordinate);
	}
	
	public ImageView getImageView(){
		return myImageView;
	}

}
