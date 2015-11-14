package objects.events;

import objects.IGameObject;

public abstract class AbstractEvent implements IEvent{
	
	private static EEventType myType;
	
	public AbstractEvent() {
		this(EEventType.NULL);
		mySource = null;
		myTarget = null;
	}
	
	public AbstractEvent(EEventType type) {
		this(type, null, null);
	}
	
	public AbstractEvent(EEventType type, IGameObject obj) {
		this(type, obj, null);
	}
	
	public AbstractEvent(EEventType type, IGameObject source, IGameObject target) {
		myType = type;
		mySource = source;
		myTarget = target;
	}
	
	protected IGameObject mySource;
	protected IGameObject myTarget;
	
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
