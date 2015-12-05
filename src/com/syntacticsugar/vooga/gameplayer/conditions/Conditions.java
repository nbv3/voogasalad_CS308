package com.syntacticsugar.vooga.gameplayer.conditions;

import java.util.ArrayList;
import java.util.List;

import com.syntacticsugar.vooga.gameplayer.manager.IEventManager;
import com.syntacticsugar.vooga.gameplayer.universe.score.IEventListener;

public class Conditions implements IConditions, IEventListener {

	private List<IGameCondition> myConditions;
	private IEventManager myManager;

	public Conditions() {
		myConditions = new ArrayList<IGameCondition>();

	}

	@Override
	public void addCondition(IGameCondition condition) {
		myConditions.add(condition);

	}

	@Override
	public void registerEventManager(IEventManager eventmanager) {
		myManager = eventmanager;
		for (IGameCondition cond : myConditions) {

			cond.registerManager(myManager);
			myManager.registerListener(cond);
		}

	}

}
