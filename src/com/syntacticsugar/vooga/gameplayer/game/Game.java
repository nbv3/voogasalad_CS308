package com.syntacticsugar.vooga.gameplayer.game;

import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

public class Game implements IGame {
	
	private IGameUniverse myUniverse;
	
	private int myWave;
	
	public Game(GameData data) {
		myUniverse = data.getUniverse();
	}

	@Override
	public void runWave() {
		// TODO Auto-generated method stub
		
	}

}
