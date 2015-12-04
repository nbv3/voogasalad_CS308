package com.syntacticsugar.vooga.gameplayer.conditions;

import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.LevelChangeEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.ObjectDespawnEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.universe.IEventPoster;

public class EnemyDeathCondition extends AbstractCondition {

	private int enemiesDead;
	private int enemiesToDie;

	public EnemyDeathCondition(int numbertodie, IEventPoster manager) {
		super(ConditionType.WINNING, manager);
		enemiesToDie = numbertodie;
		enemiesDead = 0;
	}

	@Override
	public void onEvent(IGameEvent e) {
		try {
			ObjectDespawnEvent event = (ObjectDespawnEvent) e;
			if (event.getObj().getType().equals(GameObjectType.ENEMY)) {
				enemiesDead++;
				if (enemiesDead >= enemiesToDie) {
					postEvent(new LevelChangeEvent(this.returnType()));
				}
			}
			

		} catch (ClassCastException ce) {

		}

	}

}
