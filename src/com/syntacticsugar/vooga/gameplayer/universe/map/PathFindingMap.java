package com.syntacticsugar.vooga.gameplayer.universe.map;

import java.awt.Point;
import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.IGameTile;

public interface PathFindingMap {
	
	public Map<Point, IGameTile> getPathFindingMap();
	
}
