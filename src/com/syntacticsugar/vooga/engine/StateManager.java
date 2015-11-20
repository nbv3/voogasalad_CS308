package com.syntacticsugar.vooga.engine;

import com.syntacticsugar.vooga.objects.IGameObject;
import com.syntacticsugar.vooga.universe.IGameUniverse;

public class StateManager {

	public static void updateState(IGameUniverse universe) {
		for (IGameObject object : universe.getGameObjects()) {
			object.updateSelf(universe);
		}
	}

}
