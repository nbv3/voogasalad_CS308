package com.syntacticsugar.vooga.gameplayer.universe.score;

import java.util.Observer;

import com.syntacticsugar.vooga.gameplayer.event.IGameEventListener;
import com.syntacticsugar.vooga.gameplayer.universe.IEventPoster;

public interface IScore extends IGameEventListener{

	public void update();
	
	public int getScoreThreshold();
	
	public void addObserver(Observer observer);
	
}
