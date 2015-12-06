package com.syntacticsugar.vooga.gameplayer.attribute;

import com.syntacticsugar.vooga.authoring.parameters.EditableField;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;

public class ScoreAttribute extends AbstractAttribute {

	private Integer myScore;

	public ScoreAttribute() {
		super();
		myScore = 0;
	}

	@EditableField
	(	inputLabel="Score Value",
		defaultVal = "100"	)
	private void editMaxHealth(String arg) {
		try {
			String input = arg.trim();
			int score = Integer.parseInt(input);
			this.myScore = score;
			AlertBoxFactory.createObject("Assignment successful!");
		} catch (NumberFormatException e) {
			AlertBoxFactory.createObject("Please enter an integer.");
		}
	}

	@Override
	public void updateSelf(IGameUniverse universe) {
		// TODO Auto-generated method stub

	}

	public void setScore(Integer score)
	{
		myScore = score;
	}

	public Integer getScore() {
		return myScore;
	}

}

