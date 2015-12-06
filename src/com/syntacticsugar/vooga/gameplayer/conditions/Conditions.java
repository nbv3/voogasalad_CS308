package com.syntacticsugar.vooga.gameplayer.conditions;

import com.syntacticsugar.vooga.gameplayer.manager.IEventManager;
import com.syntacticsugar.vooga.gameplayer.universe.score.IEventListener;

public class Conditions implements IConditions, IEventListener {

	private IGameCondition myWinCondition;
	private IGameCondition myLossCondition;
	
	private IEventManager myManager;

	public Conditions(IGameCondition win, IGameCondition loss) {
		myWinCondition = win;
		myLossCondition = loss;
	}
	
	@Override
	public IGameCondition getWinCondition() {
		return myWinCondition;
	}

	@Override
	public IGameCondition getLossCondition() {
		return myLossCondition;
	}

	@Override
	public void registerEventManager(IEventManager eventmanager) {
		myManager = eventmanager;
		register(myWinCondition, myManager);
		register(myLossCondition, myManager);
	}		

	private void register(IGameCondition condition, IEventManager manager) {
		condition.registerManager(manager);
		manager.registerListener(condition);
	}

}
