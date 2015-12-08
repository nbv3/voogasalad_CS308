package com.syntacticsugar.vooga.gameplayer.attribute;

import com.syntacticsugar.vooga.authoring.parameters.EditableClass;
import com.syntacticsugar.vooga.authoring.parameters.EditableField;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

@EditableClass (
		className = "Score Value"
		)
public class ScoreAttribute extends AbstractAttribute {

	private Integer myScore;

	public ScoreAttribute() {
		super();
	}

	@Override
	protected void setDefaults() {
		myScore = 100;
	}

	@Override
	public void updateSelf(IGameUniverse universe) {	}

	public void setScore(Integer score) {
		myScore = score;
	}

	public Integer getScore() {
		return myScore;
	}

	
	/**		  	      EDIT TAGS	     		    **/
	/** *************************************** **/
	
	@EditableField (
			inputLabel="Score Value",
			defaultVal = "100", getClassType = int.class	
			)
	private void editMaxHealth(String arg) {
		try {
			this.myScore = Integer.parseInt(arg);
		} catch (NumberFormatException e) {	}
	}
}

