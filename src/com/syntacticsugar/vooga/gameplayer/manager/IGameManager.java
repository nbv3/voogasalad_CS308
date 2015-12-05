package com.syntacticsugar.vooga.gameplayer.manager;

import com.syntacticsugar.vooga.gameplayer.event.IGameEventListener;

public interface IGameManager extends ILevelSwitcher, IGameEventListener {
	
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
