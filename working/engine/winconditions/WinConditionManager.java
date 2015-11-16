package engine.winconditions;

import engine.IGameEngine;
import objects.events.EEventType;
import objects.events.IEvent;

public class WinConditionManager implements IWinConditionManager {
	
	Boolean ScoreGoalMet;
	
	public WinConditionManager(IGameEngine engine) {
		engine.addListener(this);
		ScoreGoalMet = false;
	}
	
	public void setScoreGoal(Boolean cond) {
		ScoreGoalMet = cond;
	}

	@Override
	public void onEvent(IEvent e) {
		if (e.getType().equals(EEventType.GoalScoreEvent)) {
			ScoreGoalMet = true;
		}
	}

	@Override
	public void update() {
		if (ScoreGoalMet) {
			System.out.println("YOU WIN!!!");
			while (true) {
				
			}
		}
	}

}
