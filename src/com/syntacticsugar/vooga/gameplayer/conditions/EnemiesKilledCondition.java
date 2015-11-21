package com.syntacticsugar.vooga.gameplayer.conditions;

import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.IObjectCollection;

public class EnemiesKilledCondition extends AbstractCondition {

	private int enemiesKilled;
	private int enemiesNeeded;

	public EnemiesKilledCondition(int numtokill) {
		super(ConditionType.WINNING);
		enemiesKilled = 0;
		enemiesNeeded = numtokill;
	}

	@Override
	public boolean checkCondition(IObjectCollection universe) {

		Collection<IGameObject> theDead = universe.getGraveYard();

		for (IGameObject dead : theDead) {
			if (dead.getType().equals(GameObjectType.ENEMY)) {
				enemiesKilled++;
			}
		}

		return enemiesKilled >= enemiesNeeded;
	}

}
