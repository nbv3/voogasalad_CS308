package com.syntacticsugar.vooga.engine;

import com.syntacticsugar.vooga.universe.IGameUniverse;

public class GameEngine {
	
	public static void frameUpdate(IGameUniverse universe) {
		CollisionEngine.checkCollisions(universe.getGameObjects());
		StateManager.updateState(universe);
	}


}
