package com.syntacticsugar.vooga.gameplayer.manager;

import com.syntacticsugar.vooga.gameplayer.universe.IEventPoster;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

public interface IGameManager extends ILevelSwitcher {
	
	/**
	 * Method to update a single frame of the game universe.
	 */
	public void updateGame();


	
	/**
	 * 
	 */
	public void restartGame();

	public void startGame();

}
