package com.syntacticsugar.vooga.gameplayer.universe.money;

import java.util.Observer;

import com.syntacticsugar.vooga.gameplayer.event.GameEventListener;

public interface IMoney extends GameEventListener{
	
	public int getMoney();
	
	public void addObserver(Observer observer);

}
