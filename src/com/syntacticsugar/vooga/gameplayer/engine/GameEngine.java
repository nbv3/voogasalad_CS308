package com.syntacticsugar.vooga.gameplayer.engine;

import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.engine.modules.*;

public class GameEngine {
	
	public static void frameUpdate(IGameUniverse universe) {
		CollisionEngine.checkCollisions(universe);
		StateEngine.updateState(universe);
	}


}
