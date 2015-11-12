package objects.events;

import objects.IGameObject;

public interface IEvent {

	public IGameObject getSource();
	
	public IGameObject getTarget();
	
	public EEventType getType();
	
}
