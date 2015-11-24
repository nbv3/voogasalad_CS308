package com.syntacticsugar.vooga.gameplayer.event;

import java.util.Collection;
import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;

public class HealthChangeEvent extends AbstractGameEvent {

	private double myDeltaHealth;
	
	public HealthChangeEvent(double deltaHealth) {
		super(GameEventType.HealthChange);
		this.myDeltaHealth = deltaHealth;
	}
	
	@Override
	public void executeEvent(Map<String, IAttribute> targetAttributes) {
		HealthAttribute health = (HealthAttribute) targetAttributes.get("health");
		health.changeHealth(myDeltaHealth);
	}
	
	public double getDeltaHealth() {
		return this.myDeltaHealth;
	}

}
