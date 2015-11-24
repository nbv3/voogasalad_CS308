package com.syntacticsugar.vooga.gameplayer.attribute;

import com.syntacticsugar.vooga.gameplayer.event.GameEventType;
import com.syntacticsugar.vooga.gameplayer.event.HealthChangeEvent;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.IObjectDespawner;

public class HealthAttribute extends AbstractAttribute {

	private double myHealth;
	private double myMaxHealth;
	private int myInvincibleFrames;
	
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
	private HealthAttribute(double maxHealth, IGameObject parent) {
		super(parent);
		this.myHealth = maxHealth;
		this.myMaxHealth = maxHealth;
		this.myInvincibleFrames = 0;
	}
	
	@Override
	public void updateSelf(IGameUniverse universe) {
		checkForDeath(universe);
		if (myInvincibleFrames > 0) {
			myInvincibleFrames--;
		}
	}
	
	/**
	 * Change the value of this attribute's internal health.
	 * @param healthChange
	 */
	public void changeHealth(double healthChange) {
		if (healthChange > 0) {
			if (myHealth + healthChange <= myMaxHealth) {
				return;
			}
			else if (myInvincibleFrames > 0) {
				return;
			}
		}
		System.out.println("OLD HEALTH = " + myHealth);
		this.myHealth += healthChange;
		System.out.println("NEW HEALTH = " + myHealth);
		setInvincibile(30);
	}
	
	private void checkForDeath(IObjectDespawner killer) {
		if (isDead()) {
			killer.addToGraveYard(getParent());
		}
	}
	
	private void setInvincibile(int numFrames) {
		this.myInvincibleFrames = numFrames;
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
