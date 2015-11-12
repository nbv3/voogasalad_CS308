package tiles.implementations;

import java.awt.Point;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tiles.AbstractGameTile;
import view.IView;

public class DecoratorTile extends AbstractGameTile implements IView {

	private AbstractGameTile myImplementation;
	private ImageView myImageView;
	
	public DecoratorTile(Point p) {
		super(p);
		myImplementation = new PathTile(p);
		setImage("path_wood_1.png");
	}

	@Override
	public boolean isWalkable() {
		// TODO Auto-generated method stub
		return myImplementation.isWalkable();
	}

	@Override
	public boolean isPlaceable() {
		return myImplementation.isPlaceable();
	}
	
	public AbstractGameTile getImplementation() {
		return myImplementation;
	}
	
	public void setImplementation(AbstractGameTile gt) {
		this.myImplementation = gt;
	}

	@Override
	public ImageView getView() {
		return myImageView;
	}

	@Override
	public void setImage(String path) {
		myImageView = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(path)));
	}
	
}
