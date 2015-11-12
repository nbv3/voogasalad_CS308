package objects;

import java.awt.Point;
import java.util.EventListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import environment.GameEnvironment;
import objects.events.AbstractEvent;
import objects.events.CollisionEvent;
import objects.events.ICollisionListener;
import objects.events.IEvent;

public abstract class AbstractGameObject extends Observable implements IGameObject, ICollisionListener{
	
	//Maybe this is a list if objects can have multiple types?
	EObjectType myType;

	Point myLocation;
	
	Map<EObjectType, List<IEvent>> myCollisionEvents;
	
	//This holds all the components and items an object has
	List<IChild> myChildren;

	public AbstractGameObject(Point p, GameEnvironment g) {
		myLocation = p;
		this.addObserver(g);
		
		myCollisionEvents = new HashMap<>();
	}
	
	public EObjectType getType() {
		return myType;
	}
	
	public void addCollisionEvent(EObjectType type, AbstractEvent e) {
		if (myCollisionEvents.keySet().contains(type)) {
			myCollisionEvents.get(type).add(e);
		}
		else {
			myCollisionEvents.put(type, new LinkedList<>());
			myCollisionEvents.get(type).add(e);
		}
	}
	
	public void onCollision(CollisionEvent e) {
		
		//Figure out if this event is for us (and which object is us)
		IGameObject obj;		
		if (e.myFirst.equals(this)) {
			obj = e.mySecond;
		}
		else if (e.mySecond.equals(this)){
			obj = e.myFirst;
		}
		else {
			return;
		}
		
		//Send every event for the right type of object
		for (EObjectType type : myCollisionEvents.keySet()) {
			if (obj.getType().equals(type)){
				List<IEvent> eventList = myCollisionEvents.get(type);
				for (IEvent event: eventList) {
					obj.sendEventToChildren(event);
				}
			}
		}
	}
	
	public void sendEventToChildren(IEvent e){
		for (IChild c: myChildren) {
			c.receiveEvent(e);
		}
	}
	
	public void setToDestroy(){
		//Write this later
	}

}
