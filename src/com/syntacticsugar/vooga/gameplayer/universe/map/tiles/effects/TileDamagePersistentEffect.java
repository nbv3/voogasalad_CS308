package com.syntacticsugar.vooga.gameplayer.universe.map.tiles.effects;

import com.syntacticsugar.vooga.gameplayer.event.implementations.HealthChangeEvent;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;

public class TileDamagePersistentEffect extends AbstractTileEffect {

	private Double myDamage;

	public TileDamagePersistentEffect(Double d) {
		myDamage = d;
	}

	@Override
	protected void doEffect(IGameUniverse universe) {
		IGameMap map = universe.getMap();
		for (IGameObject obj : universe.getGameObjects()) {
			if (map.getTile(obj.getBoundingBox().getPoint()).equals(myTile)) {
				HealthChangeEvent health = new HealthChangeEvent(myDamage);
				health.executeEvent(obj);
			}
		}
	}

	@Override
	public String getEffectName() {
		// TODO Auto-generated method stub
		return this.getClass().getSimpleName();
	}

}
