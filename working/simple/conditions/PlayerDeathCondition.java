package simple.conditions;

import simple.obj.ISimpleObject;
import simple.obj.SimpleObjectType;

public class PlayerDeathCondition implements ISimpleCondition {

	private SimpleConditions type = SimpleConditions.LOSING;

	@Override
	public boolean isConditionMet(ISimpleObject object) {
		return object.getType().equals(SimpleObjectType.PLAYER);
	}

	@Override
	public boolean checkObject(ISimpleObject object) {
		if (isConditionMet(object)) {
			return true;
		} else
			return false;

	}

	@Override
	public SimpleConditions returnType() {
		return type;
	}

}
