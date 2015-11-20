package com.syntacticsugar.vooga.gameplayer.conditions;

import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;

public class EnemyDeathCondition implements IGameCondition {

	private int enemiesAlive;
	private static final ConditionType type = ConditionType.WINNING;


	@Override
	public boolean isConditionMet() {
		return enemiesAlive <= 0;
	}

	@Override
	public boolean checkCondition(Collection<IGameObject> universe) {
		enemiesAlive = 0;
		for(IGameObject object: universe){
			if(object.getType().equals(GameObjectType.ENEMY)){
				enemiesAlive++;
			}
		}
		return isConditionMet();
	}

	@Override
	public ConditionType returnType() {
		return type;
	}

}
