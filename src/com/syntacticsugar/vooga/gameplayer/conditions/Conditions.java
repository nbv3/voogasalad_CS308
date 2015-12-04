package com.syntacticsugar.vooga.gameplayer.conditions;

import java.util.ArrayList;
import java.util.List;

import com.syntacticsugar.vooga.gameplayer.manager.IEventManager;

public class Conditions implements IConditions {

	private List<IGameCondition> myConditions;
	private IEventManager myManager;

	public Conditions(IEventManager manager) {
		myConditions = new ArrayList<IGameCondition>();
		myManager = manager;
	}

	@Override
	public void addCondition(IGameCondition condition) {
		condition.registerManager(myManager);
		myManager.registerListener(condition);
		myConditions.add(condition);

	}

}
