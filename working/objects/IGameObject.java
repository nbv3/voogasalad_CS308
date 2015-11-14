package objects;

import java.awt.Point;
import java.util.List;
import java.util.Vector;

import objects.events.IEvent;
import view.IViewable;

public interface IGameObject extends GameEventListener, IViewable{
	
	public void update();
	
	public Point getLocation();
	
	public EObjectType getType();
	
	public void sendEventToChildren(IEvent e);
	
	public void setToDestroy();
	
	public void move();
	
	public void setVelocity(double x, double y);
	
	public List<IChild> getChildren();

}
