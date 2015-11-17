package objects;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import engine.EventPoster;
import javafx.geometry.Point2D;
import objects.events.IEvent;
import view.BoundingBox;

public abstract class AbstractGameObject implements IGameObject {

	// Member variables

	// Unique, corresponds to a view object
	int myID;

	// Maybe this is a list if objects can have multiple types?
	EObjectType myType;
	BoundingBox myBoundingBox;
	Vector<Double> myVelocity;

	Boolean toBeDestroyed;

	Map<EObjectType, List<IEvent>> myCollisionEvents;

	// This holds all the attributes and items an object has
	List<IChild> myChildren;

	EventPoster myPoster;

	// Methods

	public AbstractGameObject(Point2D p, double w, double h, EventPoster poster) {
		myBoundingBox = new BoundingBox(p, w, h);

		setVelocity(0.0, 0.0);
		myPoster = poster;
		myChildren = new LinkedList<>();
		toBeDestroyed = false;
		myCollisionEvents = new HashMap<>();
	}

	public void setVelocity(double x, double y) {
		Vector<Double> vel = new Vector<>();
		vel.add(x);
		vel.add(y);
		myVelocity = vel;
	}

	public Vector<Double> getVelocity() {
		return myVelocity;
	}

	public EObjectType getType() {
		return myType;
	}

	public Point2D getLocation() {
		return myBoundingBox.getPoint();
	}

	public void setLocation(Point2D loc) {
		myBoundingBox.setPoint(loc.getX(), loc.getY());
	}

	public void addCollisionEvent(EObjectType type, IEvent e) {
		if (myCollisionEvents.keySet().contains(type)) {
			myCollisionEvents.get(type).add(e);
		} else {
			myCollisionEvents.put(type, new LinkedList<>());
			myCollisionEvents.get(type).add(e);
		}
	}

	public List<IEvent> onCollision(IGameObject obj) {
		//Send every event for the right type of object
		return myCollisionEvents.get(obj.getType());
	}

	public void sendEventToChildren(IEvent e) {
		for (IChild c : myChildren) {
			c.receiveEvent(e);
		}
	}

	public void onEvent(IEvent e) {
		sendEventToChildren(e);
	}

	public void setID(int id) {
		myID = id;
	}

	public int getID() {
		return myID;
	}

	public void move() {
		double x = myBoundingBox.getPoint().getX();
		double y = myBoundingBox.getPoint().getY();
		myBoundingBox.setPoint(x + myVelocity.get(0), y + myVelocity.get(1));
	}

	public void setVelocity(Vector<Double> vel) {
		myVelocity = vel;
	}

	public void update() {

		for (IChild c : myChildren) {
			c.update();
		}
		move();
		System.out.println(myBoundingBox.getPoint());
	}

	public List<IChild> getChildren() {
		return myChildren;
	}

	public EventPoster getPoster() {
		return myPoster;
	}

	public BoundingBox getBoundingBox() {
		return myBoundingBox;
	}

	public void setObjectType(EObjectType type) {
		myType = type;
	}

}
