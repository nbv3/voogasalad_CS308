package engine.objectives;

import engine.environment.GameEnvironment;

@FunctionalInterface
public interface IObjectiveAction {

	public void objectiveTakeAction(GameEnvironment environment);
	
}
