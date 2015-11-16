package engine.score;

import engine.EventPoster;
import engine.IGameEngine;
import objects.events.EEventType;
import objects.events.GoalScoreEvent;
import objects.events.IEvent;
import objects.events.ScoreChangeEvent;

public class ScoreManager implements IScoreManager {
	
	private double myScore;
	private double myScoreThreshold;
	
	private EventPoster myPoster;
	
	public ScoreManager(IGameEngine engine) {
		engine.addListener(this);
		myPoster = engine;
		myScore = 0;
		
		//TODO:Remove this
		myScoreThreshold = 100;
	}

	@Override
	public void onEvent(IEvent e) {
		if (e.getType().equals(EEventType.ScoreChangeEvent)) {
			ScoreChangeEvent event = (ScoreChangeEvent) e;
			myScore += event.getAmount();
		}
	}

	@Override
	public void update() {
		if (myScore >= myScoreThreshold) {
			GoalScoreEvent event = new GoalScoreEvent();
			myPoster.postEvent(event);;
		}
	}

}
