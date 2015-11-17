package objects.enemy;

import java.awt.Point;
import java.util.List;

import environment.GameMap;
import objects.EObjectType;
import objects.components.IComponent;
import objects.events.IEvent;
import tools.Path;
import tools.PathFinder;

public class AbstractEnemy implements IEnemy{
	
	private Point myPoint;
	private List<IComponent> myComponents;
	
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
	}
	
	@Override
	public Point getDestination() {
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
		// TODO Auto-generated method stub
		
	}	
}
