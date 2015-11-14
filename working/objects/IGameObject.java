package objects;

import java.util.List;
import java.util.Vector;

import javafx.geometry.Point2D;
import objects.events.IEvent;

public interface IGameObject extends GameEventListener{
	
	public void update();
	
	public Point2D getLocation();
	
	public EObjectType getType();
	
	public void sendEventToChildren(IEvent e);
	
	public void setToDestroy();
	
	public void move();
	
	public void setVelocity(double x, double y);
	
	public List<IChild> getChildren();

}
