package com.syntacticsugar.vooga.gameplayer.engine;

import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

public class StateManager {

	public static void updateState(IGameUniverse universe) {
		for (IGameObject object : universe.getGameObjects()) {
			object.updateSelf(universe);
		}
	}

}
