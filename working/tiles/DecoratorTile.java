package tiles;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

import objects.SpawnerObject;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tiles.implementations.SceneryTile;
import view.IView;

public class DecoratorTile extends Observable implements IGameTile, IView {
	
	private IGameTile myImplementation;
	private ImageView myImageView = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("scenery_grass_1.png")));
	private List<SpawnerObject> spawnerList;
	
	public DecoratorTile(Point p) {
		myImplementation = new SceneryTile(p);
		myImageView.getStyleClass().add("tile");
		myImageView.getStyleClass().add("tile-select-off");
		setImage(myImageView);
		spawnerList = new LinkedList<SpawnerObject>();
	}

	@Override
	public boolean isWalkable() {
		return myImplementation.isWalkable();
	}

	@Override
	public boolean isPlaceable() {
		return myImplementation.isPlaceable();
	}

	@Override
	public Point getPoint() {
		return myImplementation.getPoint();
	}
	
	public IGameTile getImplementation() {
		return myImplementation;
	}
	
	public void setImplementation(IGameTile gt) {
		this.myImplementation = gt;
	}

	@Override
	public ImageView getView() {
		return myImageView;
	}

	@Override
	public void setImage(ImageView iv) {
		myImageView = iv;
		setChanged();
		notifyObservers();
	}

	public List<SpawnerObject> getSpawnerList() {
		return spawnerList;
	}

	public void setSpawnerList(List<SpawnerObject> spawnerList) {
		this.spawnerList = spawnerList;
	}
	
}
