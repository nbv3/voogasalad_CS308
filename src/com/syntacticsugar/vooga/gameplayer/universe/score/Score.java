package com.syntacticsugar.vooga.gameplayer.universe.score;

import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.ScoreChangeEvent;
import com.syntacticsugar.vooga.gameplayer.manager.IEventManager;
import com.syntacticsugar.vooga.xml.data.LevelSettings;

public class Score implements IScore {
	
	int myScore;
	int myScoreThreshold;
	
	public Score (IEventManager manager, LevelSettings settings) {
		manager.registerListener(this);
		myScore = 0;
		myScoreThreshold = settings.getScoreThreshold();
	}
	
	@Override
	public void update() {
		if (myScoreThreshold > 0 && myScore > myScoreThreshold) {
			//TODO: Implement
		}
	}

	@Override
	public void onEvent(IGameEvent e) {
		try {
			ScoreChangeEvent event = (ScoreChangeEvent) e;
			changeScore(event);
		}
		catch (ClassCastException ex) {
			return;
		}
	}
	
	private void changeScore(ScoreChangeEvent event) {
		myScore += event.getScore();
		System.out.println(myScore);
	}
	
	@Override
	public int getScoreThreshold() {
		return myScoreThreshold;
	}

}
