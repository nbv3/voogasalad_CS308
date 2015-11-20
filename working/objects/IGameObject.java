package objects;

<<<<<<< HEAD
import java.util.List;
import java.util.Vector;

import editor.IEditableObject;
import engine.EventPoster;
import javafx.geometry.Point2D;
=======
import java.awt.Point;
import java.util.List;

import environment.GameMap;
>>>>>>> 3ac8a181ea26f81bf2f885525a7b824fd41f6282
import objects.events.IEvent;
import view.IViewable;

public interface IGameObject extends IGameEventListener, IViewable, IEditableObject{
	
	public void update();
	
<<<<<<< HEAD
	public Point2D getLocation();
	
	public void setLocation(Point2D loc);
	
=======
	public Point getLocation();
		
>>>>>>> 3ac8a181ea26f81bf2f885525a7b824fd41f6282
	public EObjectType getType();
	
	public void sendEventToChildren(IEvent e);
	
	public void setVelocity(double x, double y);
	
	public Vector<Double> getVelocity();
	
	public List<IChild> getChildren();
	
	public EventPoster getPoster();
	
<<<<<<< HEAD
	public List<IEvent> getEventsFromCollision(IGameObject obj);

=======
	public void move(Point loc);
>>>>>>> 3ac8a181ea26f81bf2f885525a7b824fd41f6282
}
