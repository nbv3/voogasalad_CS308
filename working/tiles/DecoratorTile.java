package tiles;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

import objects.SpawnerObject;
import objects.towers.AbstractTower;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import tiles.implementations.SceneryTile;
import view.IView;

public class DecoratorTile extends Observable implements IGameTile, IView {
	
	private IGameTile myImplementation;
	private ImageView myImageView = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("scenery_grass_1.png")));
	private List<SpawnerObject> spawnerList;
	private List<AbstractTower> towerList;
	
	public DecoratorTile(Point p) {
		myImplementation = new SceneryTile(p);
		myImageView.getStyleClass().add("tile");
		myImageView.getStyleClass().add("tile-select-off");
		myImageView.setOnMouseEntered(e->hoverOnTile());
		myImageView.setOnMouseExited(e->hoverOffTile());
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
	
	public List<AbstractTower> getTowerList()
	{
		return towerList;
	}

	public void setSpawnerList(List<SpawnerObject> spawnerList) {
		this.spawnerList = new LinkedList<SpawnerObject>(spawnerList);
	}
	
	public void setTowerList(List<AbstractTower> towerList)
	{
		this.towerList = towerList;
	}
	
	public void hoverOnTile(){
		myImageView.getStyleClass().add("tile-hover-on");
	}
	
	public void hoverOffTile(){	
		myImageView.getStyleClass().remove("tile-hover-on");
	}
	
}
