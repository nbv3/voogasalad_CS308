package objects.events;

public class CollisionEvent extends AbstractEvent{
	private static final EEventType myType = EEventType.CollisionEvent;
	//What data do we need specifically for a collision?

	@Override
	public EEventType getType() {
		return myType;
	}
}
