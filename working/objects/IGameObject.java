package objects;

import java.util.List;

import editor.IEditableObject;
import engine.EventPoster;
import javafx.geometry.Point2D;
import objects.events.CollisionEvent;
import objects.events.IEvent;
import view.IViewable;

public interface IGameObject extends GameEventListener, IViewable, IEditableObject{
	
	public void update();
	
	public Point2D getLocation();
	
	public void setLocation(Point2D loc);
	
	public EObjectType getType();
	
	public void sendEventToChildren(IEvent e);
		
	public void move();
	
	public void setVelocity(double x, double y);
	
	public List<IChild> getChildren();
	
	public EventPoster getPoster();
	
	public void onCollision(IGameObject obj);

}
