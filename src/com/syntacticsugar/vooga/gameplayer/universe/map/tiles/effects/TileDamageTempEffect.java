package com.syntacticsugar.vooga.gameplayer.universe.map.tiles.effects;

import com.syntacticsugar.vooga.gameplayer.event.implementations.HealthChangeEvent;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.GameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;

public class TileDamageTempEffect extends AbstractTileEffect {

private Double myDamage;
	
	public TileDamageTempEffect() {
		myDamage = 0.0;
	}

	@Override
	protected void doEffect(GameUniverse universe) {
		IGameMap map = universe.getMap();
		for (IGameObject obj: universe.getGameObjects()){
			if (map.getTile(obj.getBoundingBox().getPoint()).equals(myTile)) {
				HealthChangeEvent health = new HealthChangeEvent(myDamage);
				health.executeEvent(obj);
			}
		}
		myTile.setTileEffect(null);
	}

}
