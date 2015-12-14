package com.syntacticsugar.vooga.gameplayer.manager;

import com.syntacticsugar.vooga.gameplayer.event.GameEventListener;

public interface IGameManager extends GameEventListener {
	
	/**
	 * Updates a single frame of the game universe.
	 */
	public void updateGame();


}
