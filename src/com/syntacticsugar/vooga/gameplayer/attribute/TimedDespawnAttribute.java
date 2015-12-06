package com.syntacticsugar.vooga.gameplayer.attribute;

import com.syntacticsugar.vooga.authoring.parameters.EditableField;
import com.syntacticsugar.vooga.authoring.parameters.InputParser;
import com.syntacticsugar.vooga.authoring.parameters.InputTypeException;
import com.syntacticsugar.vooga.gameplayer.event.implementations.ObjectDespawnEvent;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

public class TimedDespawnAttribute extends AbstractAttribute {
	
	private int myFrameCount;
	private int timeHere;
	
	public TimedDespawnAttribute() {
		myFrameCount = 0;
	}
	
	@Override
	protected void setDefaults() {
		this.myFrameCount = 180;
	}
	
	public void setTimeHere (int time) {
		timeHere = time;
	}

	@Override
	public void updateSelf(IGameUniverse universe) {
		if (myFrameCount >= timeHere) {
			ObjectDespawnEvent event = new ObjectDespawnEvent(getParent());
			universe.postEvent(event);
		}
		myFrameCount++;
	}
	
	
	/**		  	      EDIT TAGS	     		    **/
	/** *************************************** **/
	
	@EditableField (	
		inputLabel = "Duration (Frames)",
		defaultVal = "180"
		)
	private void editFrameCount(String arg) {
		try {
			this.myFrameCount = InputParser.parseAsInt(arg);
		} catch (InputTypeException e) { 	}
	}
}
