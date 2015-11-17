package simple.conditions;

import simple.obj.SimpleObjectType;

public class PlayerDeathCondition implements ISimpleCondition {

	public PlayerDeathCondition() {
	}

	@Override
	public boolean isConditionMet(SimpleObjectType type) {
		return type.equals(SimpleObjectType.PLAYER);
	}

	@Override
	public void act(SimpleObjectType type) {
		if (isConditionMet(type)) {
			// Player death action
		}
		return;

	}

}
