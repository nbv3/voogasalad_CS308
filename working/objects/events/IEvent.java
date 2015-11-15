package objects.events;

import objects.IGameObject;

public interface IEvent {

	/**
	 * Method to return the source of the event
	 */

	public IGameObject getSource();

	/**
	 * Method to return the target of the event
	 */

	public IGameObject getTarget();

	/**
	 * Method to return the type of the event
	 */

	public EEventType getType();

}
