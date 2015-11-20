package tiles;

<<<<<<< HEAD
import javafx.geometry.Point2D;
import tiles.implementations.PathTile;
import view.BoundingBox;
import view.ViewableObject;
=======
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
>>>>>>> 3ac8a181ea26f81bf2f885525a7b824fd41f6282

public class DecoratorTile extends ViewableObject implements IGameTile {
	
	private IGameTile myImplementation;
<<<<<<< HEAD
	private BoundingBox myBox;
	
	public DecoratorTile(int id, Point2D p, double width, double height) {
		super(id, new BoundingBox(p, width, height));
		myImplementation = new PathTile(p);
		myBox = new BoundingBox(p, width, height);
=======
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
>>>>>>> 3ac8a181ea26f81bf2f885525a7b824fd41f6282
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
	public Point2D getPoint() {
		return myImplementation.getPoint();
	}
	
	public IGameTile getImplementation() {
		return myImplementation;
	}
	
	public void setImplementation(IGameTile gt) {
		this.myImplementation = gt;
	}

	@Override
	public BoundingBox getBoundingBox() {
		return myBox;
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
