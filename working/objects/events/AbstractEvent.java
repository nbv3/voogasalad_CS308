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
	
	public IGameObject mySource;
	public IGameObject myTarget;
	
	public IGameObject getSource() {
		return mySource;
	}
	
	public IGameObject getTarget() {
		return myTarget;
	}

	public EEventType getType() {
		return myType;
	}
}
