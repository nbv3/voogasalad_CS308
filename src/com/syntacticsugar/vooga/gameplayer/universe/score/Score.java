package com.syntacticsugar.vooga.gameplayer.universe.score;

import java.util.Observable;

import com.syntacticsugar.vooga.gameplayer.conditions.ConditionType;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.LevelChangeEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.ScoreChangeEvent;
import com.syntacticsugar.vooga.gameplayer.manager.IEventManager;
import com.syntacticsugar.vooga.gameplayer.universe.IEventPoster;
import com.syntacticsugar.vooga.xml.data.LevelSettings;

public class Score extends Observable implements IScore {

	int myScore;
	int myScoreThreshold;
	private IEventPoster myPoster;

	public Score(IEventManager manager, LevelSettings settings) {
		manager.registerListener(this);
		myScore = 0;
		myScoreThreshold = settings.getScoreThreshold();
		myPoster = manager;
	}

	@Override
	public void update() {
		if (myScoreThreshold > 0 && myScore > myScoreThreshold) {
			myPoster.postEvent(new LevelChangeEvent(ConditionType.WINNING));
		}
	}

	@Override
	public void onEvent(IGameEvent e) {
		try {
			ScoreChangeEvent event = (ScoreChangeEvent) e;
			changeScore(event);
		} catch (ClassCastException ex) {

		}
	}

	private void changeScore(ScoreChangeEvent event) {
		myScore += event.getScore();
		setChanged();
		notifyObservers(myScore);
		System.out.println(myScore);
	}

	@Override
	public int getScoreThreshold() {
		return myScoreThreshold;
	}


}
