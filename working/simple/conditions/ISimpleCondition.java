package simple.conditions;

import java.util.Collection;

import simple.obj.ISimpleObject;

public interface ISimpleCondition{

	public boolean isConditionMet();
	
	public boolean checkObject(Collection<ISimpleObject> unmodifiableUniverse);
	
	public SimpleConditions returnType();
	
	

}
