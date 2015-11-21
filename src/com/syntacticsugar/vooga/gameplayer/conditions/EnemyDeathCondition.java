package com.syntacticsugar.vooga.gameplayer.conditions;

import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.IObjectCollection;

public class EnemyDeathCondition extends AbstractCondition {

	public EnemyDeathCondition() {
		super(ConditionType.WINNING);
	}

	private int enemiesAlive;

	@Override
	public boolean checkCondition(IObjectCollection universe) {
		
		Collection<IGameObject> theLiving = universe.getGameObjects();
		enemiesAlive = 0;
		for (IGameObject object : theLiving) {
			if (object.getType().equals(GameObjectType.ENEMY)) {
				enemiesAlive++;
			}
		}
		return enemiesAlive <= 0;
	}

}
