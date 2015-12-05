package com.syntacticsugar.vooga.gameplayer.attribute.status;

import java.util.Observable;

import com.syntacticsugar.vooga.gameplayer.attribute.movement.AbstractMovementAttribute;
import com.syntacticsugar.vooga.util.ResourceManager;

public class StunAttribute extends StatusEffectAttribute {
	
	AbstractMovementAttribute move;
	
	public StunAttribute(Integer time) {
		super(time);
		move = null;
	}

	@Override
	protected void startStatus() {
		try {
			move = (AbstractMovementAttribute) getParent().getAttributes().get(ResourceManager.getString(AbstractMovementAttribute.class.getSimpleName()));
			move.setSpeed(move.getSpeed() * .000001);
		}
		catch (Exception ex) {
			
		}
	}

	@Override
	protected void endStatus() {
		if (move != null) {
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
