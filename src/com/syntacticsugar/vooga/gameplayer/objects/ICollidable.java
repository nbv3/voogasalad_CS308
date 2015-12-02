package com.syntacticsugar.vooga.gameplayer.objects;

import com.syntacticsugar.vooga.gameplayer.event.ICollisionEvent;

public interface ICollidable {
	
	/**
	 * Adds an event to be thrown when this object collides with the object type specified.
	 * @param type
	 * @param event
	 */
	public void addCollisionBinding(GameObjectType type, ICollisionEvent event);
	
	/**
	 * Method to be called when a collision involving this object is detected.
	 * @param collidedObject
	 */
	public void onCollision(IGameObject collidedObject);
	
}
