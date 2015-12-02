package com.syntacticsugar.vooga.gameplayer.event.implementations;

import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.event.CollisionEvent;
import com.syntacticsugar.vooga.gameplayer.event.CollisionEventType;
import com.syntacticsugar.vooga.util.ResourceManager;

public class HealthChangeEvent extends CollisionEvent {

	private final String TARGET_ATTRIBUTE = ResourceManager.getString("HealthAttribute");
	private double myDeltaHealth;
	
	public HealthChangeEvent(double deltaHealth) {
		super(CollisionEventType.HealthChange);
		this.myDeltaHealth = deltaHealth;
	}
	
	@Override
	public void executeEvent(Map<String, IAttribute> targetAttributes) {
		HealthAttribute health = (HealthAttribute) targetAttributes.get(TARGET_ATTRIBUTE);
		health.changeHealth(myDeltaHealth);
	}
	
	public double getDeltaHealth() {
		return this.myDeltaHealth;
	}

}
