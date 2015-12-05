package com.syntacticsugar.vooga.gameplayer.universe.score;

import java.util.Observer;

import com.syntacticsugar.vooga.gameplayer.event.GameEventListener;
import com.syntacticsugar.vooga.gameplayer.universe.IEventPoster;

public interface IScore extends GameEventListener{

	public int getScore();
	
	public void addObserver(Observer observer);
	
}
