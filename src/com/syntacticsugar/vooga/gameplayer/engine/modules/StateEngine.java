package com.syntacticsugar.vooga.gameplayer.engine.modules;

import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

public class StateEngine {

	public static void updateState(IGameUniverse universe) {
		for (IGameObject object : universe.getGameObjects()) {
			object.updateSelf(universe);
		}
	}

}
