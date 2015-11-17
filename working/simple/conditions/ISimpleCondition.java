package simple.conditions;

import simple.obj.SimpleObjectType;

public interface ISimpleCondition{
	
	public void act(SimpleObjectType type);

	boolean isConditionMet(SimpleObjectType type);

}
