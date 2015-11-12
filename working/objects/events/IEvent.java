package objects.events;

import objects.IGameObject;

public interface IEvent {

	public IGameObject getFirst();
	
	public IGameObject getSecond();
	
	public EEventType getType();
	
}
