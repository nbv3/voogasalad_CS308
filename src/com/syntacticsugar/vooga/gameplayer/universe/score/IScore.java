package com.syntacticsugar.vooga.gameplayer.universe.score;

import java.util.Observer;

import com.syntacticsugar.vooga.gameplayer.event.GameEventListener;

public interface IScore extends GameEventListener {

	public void update();
	
	public int getScoreThreshold();
	
	public void addObserver(Observer observer);
	
}
