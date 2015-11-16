package objects.events;

import objects.IGameObject;

public class GoalScoreEvent extends AbstractEvent {

	public GoalScoreEvent() {
		super(EEventType.GoalScoreEvent);
	}
}
