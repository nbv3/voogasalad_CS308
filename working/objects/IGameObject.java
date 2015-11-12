package objects;

import java.awt.Point;

import objects.events.IEvent;

public interface IGameObject{
	
	public void update();
	
	public Point getLocation();
	
	public EObjectType getType();
	
	public void sendEventToChildren(IEvent e);
	
	public void setToDestroy();
	
	public void move(Point loc);

}
