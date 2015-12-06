package com.syntacticsugar.vooga.gameplayer.attribute;

import java.util.Observable;

import com.syntacticsugar.vooga.gameplayer.event.implementations.ObjectDespawnEvent;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

public class TimedDespawnAttribute extends AbstractAttribute {
	
	private int myFrameCount;
	private int timeHere;
	
	public TimedDespawnAttribute() {
		myFrameCount = 0;
	}
	
	public void setTimeHere (int time) {
		timeHere = time;
	}
	
	private void editTimeHere(int timeHere) {
		setTimeHere(timeHere);
	}

	@Override
	public void update(Observable o, Object arg) {

	}

	@Override
	public void updateSelf(IGameUniverse universe) {
		if (myFrameCount >= timeHere) {
			ObjectDespawnEvent event = new ObjectDespawnEvent(getParent());
			universe.postEvent(event);
		}

		myFrameCount++;
	}

}
