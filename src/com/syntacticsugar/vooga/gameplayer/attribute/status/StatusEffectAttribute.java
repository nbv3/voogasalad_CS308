package com.syntacticsugar.vooga.gameplayer.attribute.status;

import java.util.Observable;

import com.syntacticsugar.vooga.authoring.parameters.AbstractParameter;
import com.syntacticsugar.vooga.gameplayer.attribute.AbstractAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.AbstractMovementAttribute;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.util.ResourceManager;

public abstract class StatusEffectAttribute extends AbstractAttribute {
	
	protected Integer timeLeft;
	
	Boolean isStarted;
	
	public StatusEffectAttribute(Integer time) {
		timeLeft = time;
		isStarted = false;
	}

	@Override
	public void updateSelf(IGameUniverse universe) {
		if (!isStarted) {
			startStatus();
			isStarted = true;
		}
		if (timeLeft <= 0) {
			kill();
		}
		
		timeLeft--;
	}
	
	protected abstract void startStatus();
	
	protected abstract void endStatus();
	
	public abstract void update(Observable o, Object arg);
	
	public void kill() {
		endStatus();
		getParent().removeAttribute(this);
	}

}
