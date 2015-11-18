package simple.conditions;

import java.util.Collection;

import simple.obj.ISimpleObject;
import simple.obj.SimpleObjectType;

public class EnemyDeathCondition implements ISimpleCondition {

	private int enemiesAlive;
	private SimpleConditions type = SimpleConditions.WINNING;


	@Override
	public boolean isConditionMet() {
		return enemiesAlive <= 0;
	}

	@Override
	public boolean checkObject(Collection<ISimpleObject> universe) {
		for(ISimpleObject object: universe){
			if(object.getType().equals(SimpleObjectType.ENEMY)){
				enemiesAlive++;
			}
		}
		
		return isConditionMet();
	}

	@Override
	public SimpleConditions returnType() {
		return type;
	}

}
