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
		myImageView.setFitHeight(scalingFactor*box.getHeight());
		myImageView.setFitWidth(scalingFactor*box.getWidth());
		myGameView.getChildren().add(myImageView);
		box.addObserver(this);
	}

	@Override
	public void update(Observable obs, Object arg1) {
		ObservableBoundingBox box = (ObservableBoundingBox) obs;
		applyTransform(box);
	}
	
	private void applyTransform(ObservableBoundingBox box) {
		double xCoordinate = box.getPoint().getX()*scalingFactor;
		double yCoordinate = box.getPoint().getY()*scalingFactor;
		myImageView.relocate(xCoordinate, yCoordinate);
	}

}