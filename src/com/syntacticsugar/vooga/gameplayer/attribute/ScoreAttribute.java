package com.syntacticsugar.vooga.gameplayer.attribute;

import java.util.Collection;
import java.util.Observable;

import com.syntacticsugar.vooga.authoring.parameters.IEditableParameter;
import com.syntacticsugar.vooga.authoring.parameters.IntegerParameter;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

public class ScoreAttribute extends AbstractAttribute {
	
	private Integer myScore;
	
	public ScoreAttribute(Integer score) {
		super(new IntegerParameter(score, "Score: "));
		myScore = score;
	}

	@Override
	public void updateSelf(IGameUniverse universe) {
		// TODO Auto-generated method stub

	}
	
	private void setScore(Integer score)
	{
		myScore = score;
	}
	
	public Integer getScore() {
		return myScore;
	}

	@Override
	public void update(Observable o, Object arg) {
		setScore((Integer) arg);
		setChanged();
		notifyObservers(this);
		
	}


}

