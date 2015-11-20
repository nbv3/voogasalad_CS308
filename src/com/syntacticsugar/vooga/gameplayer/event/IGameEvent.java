package com.syntacticsugar.vooga.gameplayer.event;

import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;


public interface IGameEvent {
	
	/**
	 * Return the enum type of this event.
	 * @return
	 */
	public GameEventType getEventType();
	
	/**
	 * Execute this event on the specified Target attributes.
	 */
	public void executeEvent(Collection<IAttribute> targetAttributes);

}
