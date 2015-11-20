package com.syntacticsugar.vooga.event;

import java.util.Collection;

import com.syntacticsugar.vooga.attribute.IAttribute;

public class HealthChangeEvent extends AbstractGameEvent {

	private double myDeltaHealth;
	
	public HealthChangeEvent(double deltaHealth) {
		super(GameEventType.HealthChange);
		this.myDeltaHealth = deltaHealth;
	}
	
	@Override
	public void executeEvent(Collection<IAttribute> targetAttributes) {
		for (IAttribute attribute : targetAttributes) {
			attribute.receiveEvent(this);
		}
	}
	
	public double getDeltaHealth() {
		return this.myDeltaHealth;
	}

}
