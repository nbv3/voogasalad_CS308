package simple.conditions;

import simple.obj.SimpleObjectType;

public class EnemyDeathCondition implements ISimpleCondition {
	
	private int enemySize;
	
	public EnemyDeathCondition(int size){
		enemySize = size;
	}

	@Override
	public void act(SimpleObjectType type) {
		if(isConditionMet(type)){
			enemySize --;
		}
		if(enemySize <= 0){
			// Do something
		}
		return;
		
	}

	@Override
	public boolean isConditionMet(SimpleObjectType type) {
		return type.equals(SimpleObjectType.ENEMY);
	}

}
