package tiles;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.IView;

public abstract class AbstractGameTile implements IView, IGameTile {
	
	private Point myPoint;
	private ImageView myImage;
	
	public AbstractGameTile(Point p) {
		myPoint = p;
		myImage = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("default_tile.jpg")));
	}
	
	public Point getPoint() {
		return myPoint;
	}

	@Override
	public ImageView getView() {
		return myImage;
	}

	@Override
	public void setImage(String path) {
		// TODO Auto-generated method stub
		
	}

}
