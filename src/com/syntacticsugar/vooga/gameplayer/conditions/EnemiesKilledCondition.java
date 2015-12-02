package com.syntacticsugar.vooga.gameplayer.conditions;

import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.GraveYard;
import com.syntacticsugar.vooga.gameplayer.universe.IObjectCollection;
import com.syntacticsugar.vooga.gameplayer.universe.IObjectDespawner;

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
		GraveYard gy = universe.getGraveYard();
		enemiesKilled += gy.countType(GameObjectType.ENEMY);
		return enemiesKilled >= enemiesNeeded;
	}

}
