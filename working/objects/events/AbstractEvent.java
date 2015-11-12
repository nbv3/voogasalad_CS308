package objects.events;

import objects.IGameObject;

public abstract class AbstractEvent implements IEvent{
	
	private static EEventType myType;
	
	public AbstractEvent() {
		this(EEventType.NULL);
	}
	
	public AbstractEvent(EEventType type) {
		myType = type;
	}
	
	public IGameObject myFirst;
	public IGameObject mySecond;
	
	public IGameObject getFirst() {
		return myFirst;
	}
	
	public IGameObject getSecond() {
		return mySecond;
	}

	public EEventType getType() {
		return myType;
	}
}
