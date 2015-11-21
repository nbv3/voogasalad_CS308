package com.syntacticsugar.vooga.gameplayer.conditions;

public abstract class AbstractCondition implements IGameCondition{
	
	private ConditionType myType;
	
	public AbstractCondition(ConditionType type){
		myType = type;
	}

	public ConditionType returnType(){
		return myType;
	}
	
}
