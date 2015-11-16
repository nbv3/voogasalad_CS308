package objects.events;

import objects.IGameObject;

public class HitSolidObjectEvent extends AbstractEvent {

	public HitSolidObjectEvent(IGameObject source) {
		super(EEventType.HitSolidObjectEvent, source);
	}

}
