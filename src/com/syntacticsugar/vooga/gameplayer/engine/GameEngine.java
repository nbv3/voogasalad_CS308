package com.syntacticsugar.vooga.gameplayer.engine;

import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

public class GameEngine {
	
	public static void frameUpdate(IGameUniverse universe) {
		CollisionEngine.checkCollisions(universe.getGameObjects());
		StateManager.updateState(universe);
	}


}
