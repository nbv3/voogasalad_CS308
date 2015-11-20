package objects.enemy;

import java.util.List;

<<<<<<< HEAD
import engine.EventPoster;
import javafx.geometry.Point2D;
import objects.AbstractGameObject;
=======
import environment.GameMap;
>>>>>>> 3ac8a181ea26f81bf2f885525a7b824fd41f6282
import objects.EObjectType;
import objects.attributes.IAttribute;
import objects.events.IEvent;
import tools.Path;
import tools.PathFinder;

public abstract class AbstractEnemy extends AbstractGameObject implements IEnemy{
	
	private List<IAttribute> myAttributes;
	
<<<<<<< HEAD
	public AbstractEnemy(Point2D p, double w, double h, EventPoster poster) {
		super(p, w, h, poster);
=======
	private Path myPath;
	
	public AbstractEnemy(Point p) {
		/*
		 * TODO: expand constructor
		 */
		myPoint = p;
	}
	
	@Override
	public Point getLocation() {
		return myPoint;
>>>>>>> 3ac8a181ea26f81bf2f885525a7b824fd41f6282
	}
	
	@Override
<<<<<<< HEAD
	public List<Point2D> findPath() {
=======
	public Point getDestination() {
>>>>>>> 3ac8a181ea26f81bf2f885525a7b824fd41f6282
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Point> findPath(GameMap gm) {
		PathFinder pf = new PathFinder(gm.getTileMap(), gm.getMapSize(), getLocation(), getDestination());
		myPath = pf.getPath();
		return myPath.getList();
	}

	@Override
<<<<<<< HEAD
	public void move() {
=======
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EObjectType getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendEventToChildren(IEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setToDestroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(Point loc) {
>>>>>>> 3ac8a181ea26f81bf2f885525a7b824fd41f6282
		// TODO Auto-generated method stub
		
	}	
}
