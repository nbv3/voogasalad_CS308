package objects.events;

import objects.IGameObject;

public class CollisionEvent extends AbstractEvent{
	
	public CollisionEvent(IGameObject source, IGameObject target) {
		super(EEventType.CollisionEvent, source, target);
	}
	
}
