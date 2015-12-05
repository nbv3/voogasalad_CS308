package com.syntacticsugar.vooga.gameplayer.attribute;

import java.util.Collection;
import java.util.ListIterator;
import java.util.Observable;

import com.syntacticsugar.vooga.authoring.parameters.DoubleParameter;
import com.syntacticsugar.vooga.authoring.parameters.IEditableParameter;
import com.syntacticsugar.vooga.gameplayer.event.implementations.ObjectDespawnEvent;
import com.syntacticsugar.vooga.gameplayer.universe.IEventPoster;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.IObjectDespawner;

import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class HealthAttribute extends AbstractAttribute {

	private double myHealth;
	private double myMaxHealth;
	private int myInvincibleFrames;
	
	/**
	 * Construct a health attribute with the specified starting health 
	 * and a null parent object
	 * @param startingHealth
	 */
	public HealthAttribute(Double maxHealth) {
		super(new DoubleParameter(maxHealth, "Health: "));
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
	
	private void setHealth(Double health)
	{
		myMaxHealth = health;
	}
	
	// test code here
	public Double getHealth() {
		return myMaxHealth;
	}

	@Override
	public void update(Observable o, Object arg) {
		setHealth((Double) arg);
		setChanged();
		notifyObservers(this);
	}


}
