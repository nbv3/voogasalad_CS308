package com.syntacticsugar.vooga.gameplayer.conditions;

import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.event.GameEventListener;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.LevelChangeEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.ObjectDespawnEvent;
import com.syntacticsugar.vooga.gameplayer.manager.IEventManager;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.GraveYard;
import com.syntacticsugar.vooga.gameplayer.universe.IEventPoster;
import com.syntacticsugar.vooga.gameplayer.universe.IObjectCollection;

public class PlayerDeathCondition extends AbstractCondition {

	public PlayerDeathCondition(IEventPoster manager) {
		super(ConditionType.LOSING, manager);
	}

	@Override
	public void onEvent(IGameEvent e) {
		try {
			System.out.println(e);
			ObjectDespawnEvent event = (ObjectDespawnEvent) e;
			if (event.getObj().getType().equals(GameObjectType.PLAYER)) {
				postEvent(new LevelChangeEvent(ConditionType.LOSING));
			}

		} catch (ClassCastException ce) {

		}

	}

}
