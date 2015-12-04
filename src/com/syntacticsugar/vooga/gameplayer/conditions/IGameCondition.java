package com.syntacticsugar.vooga.gameplayer.conditions;

import com.syntacticsugar.vooga.gameplayer.event.GameEventListener;
import com.syntacticsugar.vooga.gameplayer.universe.IObjectCollection;

public interface IGameCondition extends GameEventListener{
	
	
	/**
	 * Return the type of this game condition (ie. WINNING vs. LOSING). If a 
	 * WINNING condition has been triggered, the game manager moves on to the 
	 * next level. If the satisfied condition is a LOSING condition, the game 
	 * manager resets the current level to the last checkpoint.
	 * @return
	 */
	public ConditionType returnType();
	
	

}
