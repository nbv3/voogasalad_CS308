package com.syntacticsugar.vooga.gameplayer.attribute.status;

import com.syntacticsugar.vooga.gameplayer.attribute.AbstractAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.AbstractMovementAttribute;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.util.ResourceManager;

public abstract class StatusEffectAttribute extends AbstractAttribute {
	
	private Integer timeLeft;
	
	AbstractMovementAttribute move;
	
	Boolean isStarted;
	
	public StatusEffectAttribute(Integer time) {
		timeLeft = time;
	}

	@Override
	public void updateSelf(IGameUniverse universe) {
		if (!isStarted) {
			startStatus();
			isStarted = true;
		}
		if (timeLeft <= 0) {
			endStatus();
			getParent().removeAttribute(this);
		}
		
		timeLeft--;
	}
	
	protected abstract void startStatus();
	
	protected abstract void endStatus();

}
