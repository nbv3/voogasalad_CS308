package com.syntacticsugar.vooga.gameplayer.conditions;

import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;

public class PlayerDeathCondition implements IGameCondition {

	private ConditionType type = ConditionType.LOSING;
	private int playersAlive;

	@Override
	public boolean isConditionMet() {
		return playersAlive <= 0;
	}

	@Override
	public boolean checkCondition(Collection<IGameObject> universe) {
		playersAlive = 0;
		for (IGameObject object : universe) {
			if (object.getType().equals(GameObjectType.PLAYER)) {
				playersAlive++;
				break;
			}
		}
		return isConditionMet();
	}

	@Override
	public ConditionType returnType() {
		return type;
	}

}
