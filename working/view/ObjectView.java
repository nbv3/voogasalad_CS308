package view;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ObjectView implements Observer {

	private ImageView myImageView;
	private ITransform myTransform;
	
	public ObjectView(String path, ITransform trans) {
		this.myImageView = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(path)));
		setTransform(trans);
	}
	
	public void setTransform(ITransform trans) {
		this.myTransform = trans;
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
	}

}