package simple.conditions;

import java.util.Collection;

import simple.obj.ISimpleObject;
import simple.obj.SimpleObjectType;

public class PlayerDeathCondition implements ISimpleCondition {

	private SimpleConditions type = SimpleConditions.LOSING;
	private int playerscounted;

	@Override
	public boolean isConditionMet() {
		return playerscounted <= 0;
	}

	@Override
	public boolean checkObject(Collection<ISimpleObject> universe) {
		playerscounted = 0;
		
		for (ISimpleObject object : universe) {
			if (object.getType().equals(SimpleObjectType.PLAYER)) {
				playerscounted++;
			}
		}

		return isConditionMet();

	}

	@Override
	public SimpleConditions returnType() {
		return type;
	}

}
