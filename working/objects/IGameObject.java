package objects;

import java.util.List;
import java.util.Vector;

import editor.IEditableObject;
import engine.EventPoster;
import javafx.geometry.Point2D;
import objects.events.IEvent;
import view.IViewable;

public interface IGameObject extends IGameEventListener, IViewable, IEditableObject{
	
	public void update();
	
	public Point2D getLocation();
	
	public void setLocation(Point2D loc);
	
	public EObjectType getType();
	
	public void sendEventToChildren(IEvent e);
	
	public void setVelocity(double x, double y);
	
	public Vector<Double> getVelocity();
	
	public List<IChild> getChildren();
	
	public EventPoster getPoster();
	
	public List<IEvent> onCollision(IGameObject obj);

}
