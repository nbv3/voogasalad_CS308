package simple.conditions;

import simple.obj.ISimpleObject;
import simple.obj.SimpleObjectType;

public interface ISimpleCondition{

	public boolean isConditionMet(ISimpleObject object);
	
	public boolean checkObject(ISimpleObject object);
	
	public SimpleConditions returnType();
	
	

}
