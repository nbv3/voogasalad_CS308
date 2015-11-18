package simple.manager;

import java.util.Collection;
import java.util.List;

import simple.conditions.ISimpleCondition;
import simple.conditions.SimpleConditions;
import simple.eng.SimpleEngine;
import simple.obj.ISimpleObject;
import simple.universe.ISimpleUniverse;

public class SimpleGameManager implements ISimpleGameManager {

	private ISimpleUniverse myUniverse;
	// private ISimpleViewController myViewController;
	private List<ISimpleCondition> myConditions;

	@Override
	public void updateGame() {
		SimpleEngine.frameUpdate(myUniverse);
		checkConditions();

	}

	@Override
	public void checkConditions() {
		Collection<ISimpleObject> unmodifiableUniverse = myUniverse.getGameObjects();

		for (ISimpleCondition condition : myConditions) {
			for (ISimpleObject object : unmodifiableUniverse) {
				// Check for conditions
				if (condition.checkObject(object)) {
					switchLevel(condition.returnType());
				}

			}
		}

	}

	@Override
	public void switchLevel(SimpleConditions type) {
		if (type.equals(SimpleConditions.WINNING)) {
			// go forward
		} else if (type.equals(SimpleConditions.LOSING)) {
			// go backward?
		}

	}

}
