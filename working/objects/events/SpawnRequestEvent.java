package objects.events;

import objects.IGameObject;

public class SpawnRequestEvent extends AbstractEvent {

	public SpawnRequestEvent(IGameObject obj) {
		super(EEventType.SpawnRequestEvent, obj);
	}
	
}
