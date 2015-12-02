package com.syntacticsugar.vooga.gameplayer.objects;

import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;

public interface ICollidable {

	/**
	 * Returns a Collection of Events associated with colliding with a specific type
	 * of object.
	 * @param type
	 * @return
	 */
	public Collection<IGameEvent> getEventsFromCollision(GameObjectType type);
	
	/**
	 * Adds an event to be thrown when this object collides with the object type specified.
	 * @param type
	 * @param event
	 */
	public void addCollisionBinding(GameObjectType type, IGameEvent event);
	
	/**
	 * Method to be called when a collision involving this object is detected.
	 * @param collidedObject
	 */
	public void onCollision(IGameObject collidedObject);
	
}
