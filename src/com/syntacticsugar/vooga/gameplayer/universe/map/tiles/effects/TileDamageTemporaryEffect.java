package com.syntacticsugar.vooga.gameplayer.universe.map.tiles.effects;

import java.io.Serializable;

import com.syntacticsugar.vooga.gameplayer.event.implementations.HealthChangeEvent;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;

public class TileDamageTemporaryEffect extends AbstractTileEffect implements Serializable {

private Double myDamage;
	
	public TileDamageTemporaryEffect(Double d) {
		myDamage = d;
	}

	@Override
	protected void doEffect(IGameUniverse universe) {
		IGameMap map = universe.getMap();
		for (IGameObject obj: universe.getGameObjects()){
			if (map.getTile(obj.getBoundingBox().getPoint()).equals(myTile)) {
				HealthChangeEvent health = new HealthChangeEvent(myDamage);
				health.executeEvent(obj);
			}
		}
		myTile.setTileEffect(null);
	}

	@Override
	public String getEffectName() {
		return this.getClass().getSimpleName().substring(4, this.getClass().getSimpleName().length() - 6);
	}

}
