package com.syntacticsugar.vooga.gameplayer.attribute.status;

import java.util.Observable;

import com.syntacticsugar.vooga.gameplayer.attribute.movement.AbstractMovementAttribute;
import com.syntacticsugar.vooga.util.ResourceManager;

public class StunAttribute extends StatusEffectAttribute {
	
	AbstractMovementAttribute move;
	
	private boolean didStun;
	
	public StunAttribute(Integer time) {
		super(time);
		move = null;
		didStun = false;
	}

	@Override
	protected void startStatus() {
		try {
			move = (AbstractMovementAttribute) getParent().getAttributes().get(ResourceManager.getString(AbstractMovementAttribute.class.getSimpleName()));
			if (move.getSpeed() > .000001) {
				move.setSpeed(move.getSpeed() * .000001);
				didStun = true;
			}
		}
		catch (Exception ex) {
			
		}
	}

	@Override
	protected void endStatus() {
		if (move != null && didStun) {
			move.setSpeed(move.getSpeed() / .000001);
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		timeLeft = (Integer) arg;
		setChanged();
		notifyObservers(this);
	}

}
