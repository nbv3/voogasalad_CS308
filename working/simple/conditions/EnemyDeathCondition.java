package simple.conditions;

import simple.obj.ISimpleObject;
import simple.obj.SimpleObjectType;

public class EnemyDeathCondition implements ISimpleCondition {

	private final int enemySize;
	private int enemiesDead;
	private SimpleConditions type = SimpleConditions.WINNING;

	public EnemyDeathCondition(int size) {
		enemySize = size;
		enemiesDead = 0;
	}

	@Override
	public boolean isConditionMet(ISimpleObject object) {
		if(object.getType().equals(SimpleObjectType.ENEMY)){
			enemiesDead++;
		}
		return enemiesDead >= enemySize;
	}

	@Override
	public boolean checkObject(ISimpleObject object) {
		if(isConditionMet(object)){
			return true;
		}
		else
			return false;
	}

	@Override
	public SimpleConditions returnType() {
		return type;
	}

}
