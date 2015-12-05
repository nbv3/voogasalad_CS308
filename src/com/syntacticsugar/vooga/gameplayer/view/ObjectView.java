package com.syntacticsugar.vooga.gameplayer.view;

import java.util.Observable;
import java.util.Observer;

import com.syntacticsugar.vooga.gameplayer.objects.BoundingBox;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class ObjectView extends Observable implements Observer {
	
	private StackPane myViewPane;
	private double scalingFactor;
	protected double tempCoord1;
	protected double tempCoord2;
	
	public ObjectView(String path, BoundingBox box , double scale) {
		myViewPane = new StackPane();
		ImageView iv = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(path)));
		iv.setFocusTraversable(true);
		scalingFactor = scale;
		applyTransform(box);
		tempCoord1 = box.getPoint().getX();
		tempCoord2 = box.getPoint().getY();
		iv.setFitHeight(scalingFactor*box.getWidth());
		iv.setFitWidth(scalingFactor*box.getHeight());
		myViewPane.getChildren().add(iv);
		//myGameView.getChildren().add(myViewPane);
		gameView.addObjectView(myViewPane);
		box.addObserver(this);
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
	
	public StackPane getViewPane(){
		return myViewPane;
	}


}
