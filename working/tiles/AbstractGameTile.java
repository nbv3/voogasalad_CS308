package tiles;

import java.awt.Point;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.IView;

public abstract class AbstractGameTile implements IGameTile {
	
	private Point myPoint;
	
	public AbstractGameTile(Point p) {
		myPoint = p;
	}
	
	public Point getPoint() {
		return myPoint;
	}

}
