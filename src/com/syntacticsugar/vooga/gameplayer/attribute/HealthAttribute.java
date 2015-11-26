package com.syntacticsugar.vooga.gameplayer.attribute;

import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.IObjectDespawner;

public class HealthAttribute extends AbstractAttribute {

	private double myHealth;
	private double myMaxHealth;
	private int myInvincibleFrames;
	
	/**
	 * Construct a health attribute with the specified starting health 
	 * and a null parent object
	 * @param startingHealth
	 */
	public HealthAttribute(double maxHealth) {
		this(maxHealth, null);
	}

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
			myInvincibleFrames -= 1;
		}
	}

	/**
	 * Change the value of this attribute's internal health.
	 * @param healthChange
	 */
	public void changeHealth(double healthChange) {
		if (healthChange >= 0) {
			restoreHealth(healthChange);
		}
		else {	
			takeDamage(healthChange);
		}
	}

	private void takeDamage(double damage) {
		if (myInvincibleFrames > 0) {
			return;
		}
		System.out.println("OLD HEALTH: " + myHealth);
		this.myHealth += damage;
		System.out.println("NEW HEALTH: " + myHealth);
		setInvincibile(25);
	}

	private void restoreHealth(double healthInc) {
		if (myHealth + healthInc >= myMaxHealth) {
			myHealth = myMaxHealth;
			return;
		}
		myHealth += healthInc;
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

}
