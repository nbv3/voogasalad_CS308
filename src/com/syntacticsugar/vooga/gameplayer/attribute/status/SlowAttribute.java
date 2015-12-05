package com.syntacticsugar.vooga.gameplayer.attribute.status;

import com.syntacticsugar.vooga.gameplayer.attribute.movement.AbstractMovementAttribute;
import com.syntacticsugar.vooga.util.ResourceManager;

public class SlowAttribute extends StatusEffectAttribute {

	private Double mySlow;
	
	AbstractMovementAttribute move;
	
	public SlowAttribute(Integer time, Double slow) {
		super(time);
		move = null;
		mySlow = slow;
	}
	
	protected void startStatus() {
		try {
			move = (AbstractMovementAttribute) getParent().getAttributes().get(ResourceManager.getString(AbstractMovementAttribute.class.getSimpleName()));
			move.setSpeed(move.getSpeed() * mySlow);
		}
		catch (Exception ex) {
			
		}
	}
	
	protected void endStatus() {
		if (move != null) {
			move.setSpeed(move.getSpeed() / mySlow);
		}
	}
	
}
