package com.syntacticsugar.vooga.gameplayer.conditions;

import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.IObjectCollection;

public class PlayerDeathCondition extends AbstractCondition {

	public PlayerDeathCondition() {
		super(ConditionType.LOSING);
	}

	private int playersDead;

	@Override
	public boolean checkCondition(IObjectCollection universe) {
		Collection<IGameObject> theDead = universe.getGraveYard();

		playersDead = 0;
		for (IGameObject object : theDead) {
			if (object.getType().equals(GameObjectType.PLAYER)) {
				playersDead++;
				break;
			}
		}
		return playersDead > 0;
	}

}
