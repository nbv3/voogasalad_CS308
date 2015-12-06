package com.syntacticsugar.vooga.gameplayer.universe.map.tiles.effects;

import com.syntacticsugar.vooga.gameplayer.event.implementations.SlowEvent;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.GameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;

public class TileSlowEffect extends AbstractTileEffect {
	
	private Double mySlow;
	private int myLength;
	
	public TileSlowEffect() {
		mySlow = 1.0;
		myLength = 15;
	}
	
	public void setSlow(double slow) {
		mySlow = slow;
	}
	
	protected void doEffect(GameUniverse universe) {
		IGameMap map = universe.getMap();
		for (IGameObject obj: universe.getGameObjects()){
			if (map.getTile(obj.getBoundingBox().getPoint()).equals(myTile)) {
				SlowEvent slow = new SlowEvent(mySlow, myLength);
				slow.executeEvent(obj);
			}
		}
	}

}
