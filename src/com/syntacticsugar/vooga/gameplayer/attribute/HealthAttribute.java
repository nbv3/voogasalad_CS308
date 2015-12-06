package com.syntacticsugar.vooga.gameplayer.attribute;

import com.syntacticsugar.vooga.authoring.parameters.EditableField;
import com.syntacticsugar.vooga.gameplayer.event.implementations.ObjectDespawnEvent;
import com.syntacticsugar.vooga.gameplayer.universe.IEventPoster;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;

public class HealthAttribute extends AbstractAttribute {
	
	private static final String HEALTH_CHANGE_FREQ = "health_change_freq";

	private double myMaxHealth;
	
	private double myHealth;
	private int myInvincibleFrames;
	private int myHealthChangeFreq;
	
	/**
	 * Construct a health attribute with the specified starting health 
	 * and a null parent object
	 * @param startingHealth
	 */
	public HealthAttribute() {
		super();
		this.myInvincibleFrames = Integer.parseInt(ResourceManager.getString(HEALTH_CHANGE_FREQ));
	}

	public void getHealth() {
		System.out.println(myHealth);
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
	public void changeHealth(Double healthChange) {
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
		setInvincible(myHealthChangeFreq);
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

	private void setInvincible(int numFrames) {
		this.myInvincibleFrames = numFrames;
	}

	private boolean isDead() {
		return this.myHealth <= 0;
	}
	
	
	@EditableField(
		inputLabel = "Max Health",
		defaultVal = "100"
	)
	private void editMaxHealth(String maxHealthString) {
		try {
			String input = maxHealthString.trim();
			double arg = Double.parseDouble(input);
			this.myHealth = arg;
			this.myMaxHealth = arg;
			AlertBoxFactory.createObject("Assignment successful!");
		} catch (NumberFormatException e) {
			AlertBoxFactory.createObject("Please enter a double.");
		}
	}

}
