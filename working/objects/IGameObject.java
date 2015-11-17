package objects;

import java.awt.Point;
import java.util.List;

import environment.GameMap;
import objects.events.IEvent;

public interface IGameObject{
	
	public void update();
	
	public Point getLocation();
	
	public Point getDestination();
	
	public EObjectType getType();
	
	public void sendEventToChildren(IEvent e);
	
	public void setToDestroy();
	
	public void move(Point loc);
		
	/**
	 * find path upon spawn
	 */
	public List<Point> findPath(GameMap gm); 

}
