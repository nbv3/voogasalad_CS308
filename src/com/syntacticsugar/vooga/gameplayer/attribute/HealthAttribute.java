package com.syntacticsugar.vooga.gameplayer.attribute;

import java.util.Collection;
import java.util.ListIterator;
import java.util.Observable;

import com.syntacticsugar.vooga.authoring.parameters.DoubleParameter;
import com.syntacticsugar.vooga.gameplayer.event.implementations.ObjectDespawnEvent;
import com.syntacticsugar.vooga.gameplayer.universe.GameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.IEventPoster;

public class HealthAttribute extends AbstractAttribute {
	
	private static final String HEALTH_CHANGE_FREQ = "health_change_freq";

	private Double myHealth;
	private Double myMaxHealth;
	private int myInvincibleFrames;
	
	private int myHealthChangeFreq;
	
	/**
	 * Construct a health attribute with the specified starting health 
	 * and a null parent object
	 * @param startingHealth
	 */
	public HealthAttribute() {
		super(new DoubleParameter("Health: "));
		this.myHealth = 10.0;
		this.myMaxHealth = 50.0;
		this.myInvincibleFrames = 0;
	}

	@Override
	public void updateSelf(GameUniverse universe) {
		checkForDeath(universe);
		if (myInvincibleFrames > 0) {
			myInvincibleFrames -= 1;
		}
	}

	/**
	 * Change the value of this attribute's internal health.
	 * @param healthChange
	 */
	public void changeHealth(Double healthChange) {
		System.out.println("HealthChange = " + healthChange);
		if (healthChange >= 0) {
			restoreHealth(healthChange);
		}
		else {	
			takeDamage(healthChange);
		}
	}

	private void takeDamage(Double damage) {
		if (myInvincibleFrames > 0) {
			return;
		}
		this.myHealth += damage;
		setInvincibile(myHealthChangeFreq);
	}

	private void restoreHealth(Double healthInc) {
		if (myHealth + healthInc >= myMaxHealth) {
			myHealth = myMaxHealth;
			return;
		}
		myHealth += healthInc;
	}

	private void checkForDeath(IEventPoster killer) {
		if (isDead()) {
			ObjectDespawnEvent event = new ObjectDespawnEvent(getParent());
			killer.postEvent(event);
		}
	}

	private void setInvincibile(int numFrames) {
		this.myInvincibleFrames = numFrames;
	}

	private boolean isDead() {
		return this.myHealth <= 0;
	}
	
	public void setHealth(Double health)
	{
		myMaxHealth = health;
	}
	
	// test code here
	public Double getHealth() {
		return myHealth;
	}

	@Override
	public void update(Observable o, Object arg) {
		setHealth((Double) arg);
		setChanged();
		notifyObservers(this);
	}


}
