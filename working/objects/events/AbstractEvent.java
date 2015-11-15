package objects.events;

import objects.IGameObject;

public abstract class AbstractEvent implements IEvent {

	// Member variables
	private EEventType myType;
	private IGameObject mySource;
	private IGameObject myTarget;

	// Constructors

	/**
	 * Creates event with no source or target
	 * 
	 * @param type
	 */
	public AbstractEvent(EEventType type) {
		this(type, null, null);
	}

	/**
	 * Creates event with a type and source but not target
	 * 
	 * @param type
	 * @param source
	 */

	public AbstractEvent(EEventType type, IGameObject source) {
		this(type, source, null);
	}

	/**
	 * Creates event with type, source, and target objects
	 * 
	 * @param type
	 * @param source
	 * @param target
	 */

	public AbstractEvent(EEventType type, IGameObject source, IGameObject target) {
		myType = type;
		mySource = source;
		myTarget = target;
	}

	// Methods (see IEvent for documentation)

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
