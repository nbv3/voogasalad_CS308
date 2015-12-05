package com.syntacticsugar.vooga.gameplayer.manager;

import com.syntacticsugar.vooga.gameplayer.event.GameEventListener;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

public interface IGameManager extends ILevelSwitcher, GameEventListener {
	
	/**
	 * Method to update a single frame of the game universe.
	 */
	public void updateGame();


	
	/**
	 * 
	 */
	public void restartGame(IGameUniverse universe);

	public void startGame();

}
