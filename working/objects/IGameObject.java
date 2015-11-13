package objects;

import java.awt.Point;
import java.util.List;
import java.util.Vector;

import objects.events.IEvent;

public interface IGameObject extends GameEventListener{
	
	public void update();
	
	public Point getLocation();
	
	public EObjectType getType();
	
	public void sendEventToChildren(IEvent e);
	
	public void setToDestroy();
	
	public void move();
	
	public void setVelocity(Vector<Double> vel);
	
	public List<IChild> getChildren();

}
