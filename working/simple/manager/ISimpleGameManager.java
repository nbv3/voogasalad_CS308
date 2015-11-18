package simple.manager;

import simple.conditions.SimpleConditions;

public interface ISimpleGameManager {
	
	public void updateGame();
	
	public void checkConditions();
	
	public void switchLevel(SimpleConditions type);

}
