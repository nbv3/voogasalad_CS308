package com.syntacticsugar.vooga.gameplayer;

import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;

public class Level {

	private IGameMap myMap;
	// private Collection<IGameObject> spawnQueue;

	public Level() {

	}

	public void setMap(IGameMap map) {
		myMap = map;
	}

}
