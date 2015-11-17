package engine.objectives;

import java.util.Observer;

public interface IObjective extends Observer{
	
	public boolean hasAchieved();
	
	public void takeAction();

}
