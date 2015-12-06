package com.syntacticsugar.vooga.gameplayer.universe.map.tiles.effects;

import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.IGameTile;

public interface ITileEffect {

	public void update(IGameUniverse universe);
	
	public void setTile(IGameTile tile);
	
	public String getEffectName();
	
}
