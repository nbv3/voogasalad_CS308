package view;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ObjectView implements Observer {

	private ImageView myImageView;
	private double scalingFactor;
	
	public ObjectView(String path,ObservableBoundingBox box , GameView myGameView) {
		this.myImageView = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(path)));
		scalingFactor = myGameView.getScalingFactor();
		applyTransform(box);
		myGameView.getChildren().add(myImageView);
		box.addObserver(this);
	}

	@Override
	public void update(Observable obs, Object arg1) {
		ObservableBoundingBox box = (ObservableBoundingBox) obs;
		// TODO Use the myTransform to scale the properties of 
		// the bounding box passed as box
		applyTransform(box);
	}
	
	private void applyTransform(ObservableBoundingBox box) {
		// APPLY TRANSFORM TO IMAGEVIEW
		System.out.println(box.getPoint().getX() + "X --- " + box.getPoint().getY() + " Y ----- " + scalingFactor);
		double xCoordinate = box.getPoint().getX()*scalingFactor;
		double yCoordinate = box.getPoint().getY()*scalingFactor;
		myImageView.relocate(xCoordinate, yCoordinate);
	}

}