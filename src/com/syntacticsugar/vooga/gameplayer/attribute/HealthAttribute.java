package com.syntacticsugar.vooga.gameplayer.attribute;

import com.syntacticsugar.vooga.gameplayer.event.GameEventType;
import com.syntacticsugar.vooga.gameplayer.event.HealthChangeEvent;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.IObjectDespawner;

public class HealthAttribute extends AbstractAttribute {

	private double myHealth;
	
	/**
	 * Construct a health attribute with default 100 starting health 
	 * and the specified parent object.
	 * @param parent
	 */
	public HealthAttribute(IGameObject parent) {
		this(100, parent);
	}
	
	/**
	 * Construct a health attribute with the specified starting health 
	 * and parent object.
	 * @param startingHealth
	 * @param parent
	 */
	public HealthAttribute(double startingHealth, IGameObject parent) {
		super(parent);
		this.myHealth = startingHealth;
	}
	
	@Override
	public void updateSelf(IGameUniverse universe) {
		checkForDeath(universe);
	}
	
	/**
	 * Change the value of this attribute's internal health.
	 * @param healthChange
	 */
	public void changeHealth(double healthChange) {
		System.out.println("OLD HEALTH = " + myHealth);
		this.myHealth += healthChange;
		System.out.println("NEW HEALTH = " + myHealth);
	}
	
	private void checkForDeath(IObjectDespawner killer) {
		if (isDead()) {
			killer.addToGraveYard(getParent());
		}
	}
	
	private boolean isDead() {
		return this.myHealth <= 0;
	}

	@Override
	public void receiveEvent(IGameEvent event) {
//********************OPTION 1**************************
//		SimpleHealthChangeEvent healthEvent;
//		try {
//			healthEvent = (SimpleHealthChangeEvent) event;
//			changeHealth(healthEvent.getDeltaHealth());
//			return;
//		} catch (Exception e) { }
		
//********************OPTION 2**************************
		if (event.getEventType().equals(GameEventType.HealthChange)) {
			HealthChangeEvent healthEvent = (HealthChangeEvent) event;
			changeHealth(healthEvent.getDeltaHealth());
			return;
		}
	}

}
