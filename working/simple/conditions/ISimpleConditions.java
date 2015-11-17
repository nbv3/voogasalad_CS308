package simple.conditions;

import java.util.Observer;

public interface ISimpleConditions extends Observer{
	
	public boolean isConditionMet();
	
	public void act();

}
