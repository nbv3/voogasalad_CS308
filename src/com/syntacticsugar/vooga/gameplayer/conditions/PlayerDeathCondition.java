package com.syntacticsugar.vooga.gameplayer.conditions;

import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.GraveYard;
import com.syntacticsugar.vooga.gameplayer.universe.IObjectCollection;

public class PlayerDeathCondition extends AbstractCondition {

	public PlayerDeathCondition() {
		super(ConditionType.LOSING);
	}

	private int playersDead;

	@Override
	public boolean checkCondition(IObjectCollection universe) {
		GraveYard theDead = universe.getGraveYard();

		return theDead.containsType(GameObjectType.PLAYER);
	}

}
