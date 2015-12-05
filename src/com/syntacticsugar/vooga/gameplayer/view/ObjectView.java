package com.syntacticsugar.vooga.gameplayer.view;

import java.util.Observable;
import java.util.Observer;

import com.syntacticsugar.vooga.gameplayer.objects.BoundingBox;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class ObjectView extends Observable implements Observer {
	
	private StackPane myViewPane;
	private GameView myGameView;
	private double scalingFactor;
	protected double tempCoord1;
	protected double tempCoord2;
	
	public ObjectView(String path, BoundingBox box , GameView gameView) {
		myViewPane = new StackPane();
		ImageView iv = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(path)));
		iv.setFocusTraversable(true);
		scalingFactor = gameView.getScalingFactor();
		applyTransform(box);
		tempCoord1 = box.getPoint().getX();
		tempCoord2 = box.getPoint().getY();
		iv.setFitHeight(scalingFactor*box.getWidth());
		iv.setFitWidth(scalingFactor*box.getHeight());
		myViewPane.getChildren().add(iv);
		//myGameView.getChildren().add(myViewPane);
		gameView.addObjectView(myViewPane);
		myGameView = gameView;
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
	
	public GameView getGameView(){
		return myGameView;
	}

}
