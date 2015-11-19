package simple.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import simple.attribute.SimpleControlAttribute;
import simple.attribute.SimpleHealthAttribute;
import simple.conditions.ISimpleCondition;
import simple.conditions.SimpleConditions;
import simple.eng.SimpleEngine;
import simple.event.SimpleHealthChangeEvent;
import simple.obj.ISimpleObject;
import simple.obj.SimpleObject;
import simple.obj.SimpleObjectType;
import simple.universe.ISimpleUniverse;
import simple.universe.SimpleUniverse;
import simple.utilities.GameInformation;

public class SimpleGameManager implements ISimpleGameManager {

	private ISimpleUniverse myUniverse;
	// private ISimpleViewController myViewController;
	private List<ISimpleCondition> myConditions;
	private GameInformation myInformation;

	public SimpleGameManager() {
		myUniverse = new SimpleUniverse();
		myConditions = new ArrayList<ISimpleCondition>();

		ISimpleObject player = new SimpleObject(SimpleObjectType.PLAYER);
		player.addAttribute(new SimpleControlAttribute(player));
		player.addAttribute(new SimpleHealthAttribute(10, player));

		ISimpleObject enemy = new SimpleObject(SimpleObjectType.ENEMY);
		enemy.addCollisionBinding(SimpleObjectType.PLAYER, new SimpleHealthChangeEvent(10));

		myUniverse.addGameObject(player);
		myUniverse.addGameObject(enemy);

		updateGame();

	}

	@Override
	public void updateGame() {
		SimpleEngine.frameUpdate(myUniverse);
		checkConditions();
		updateStats();

	}

	private void updateStats() {
		// TODO Auto-generated method stub

	}

	@Override
	public void checkConditions() {
		Collection<ISimpleObject> unmodifiableUniverse = myUniverse.getGameObjects();

		for (ISimpleCondition condition : myConditions) {
			if (condition.checkObject(unmodifiableUniverse)) {
				switchLevel(condition.returnType());
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
