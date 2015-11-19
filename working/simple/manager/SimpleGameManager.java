package simple.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import simple.attribute.SimpleControlAttribute;
import simple.attribute.SimpleHealthAttribute;
import simple.conditions.ISimpleCondition;
import simple.conditions.PlayerDeathCondition;
import simple.conditions.SimpleConditions;
import simple.eng.SimpleEngine;
import simple.event.SimpleHealthChangeEvent;
import simple.obj.ISimpleObject;
import simple.obj.IViewableObject;
import simple.obj.SimpleObject;
import simple.obj.SimpleObjectType;
import simple.universe.ISimpleUniverse;
import simple.universe.SimpleUniverse;
import simple.utilities.GameInformation;
import simple.view.implementation.SimpleViewController;
import view.IViewable;
import view.ViewController;

public class SimpleGameManager implements ISimpleGameManager {

	private ISimpleUniverse myUniverse;
	// private ISimpleViewController myViewController;
	private List<ISimpleCondition> myConditions;
	private GameInformation myInformation;
	private SimpleViewController myViewController;

	public SimpleGameManager() {
		myUniverse = new SimpleUniverse();
		myConditions = new ArrayList<ISimpleCondition>();
		myConditions.add(new PlayerDeathCondition());

		myViewController = new SimpleViewController(600.0);
		String path = "enemy_dragon.png";

		// i changed ISimpleObject to SimpleObject, else addViewObject does not
		// work
		SimpleObject player = new SimpleObject(SimpleObjectType.PLAYER, new Point2D(0, 0), 50, 50, path, 1);
		player.addAttribute(new SimpleControlAttribute(player));
		player.addAttribute(new SimpleHealthAttribute(10, player));

		SimpleObject enemy = new SimpleObject(SimpleObjectType.ENEMY, new Point2D(200, 200), 100, 100, path, 2);

		enemy.addCollisionBinding(SimpleObjectType.PLAYER, new SimpleHealthChangeEvent(-10));
		myUniverse.addGameObject(player);
		myUniverse.addGameObject(enemy);
		myViewController.addViewObject(player);
		myViewController.addViewObject(enemy);

		updateGame();

	}

	@Override
	public void updateGame() {
		SimpleEngine.frameUpdate(myUniverse);

		// Object cleanup for now

		Collection<ISimpleObject> graveyard = myUniverse.getGraveYard();
		if (graveyard != null) {
			for (ISimpleObject obj : graveyard) {
				myUniverse.removeGameObject(obj);
				myViewController.removeViewObject((IViewableObject) obj);
			}

			myUniverse.clearGraveYard();

		}
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
			System.out.println("YOU LOSE");
		}

	}

	public void receiveKeyPressed(KeyCode code) {
		myUniverse.receiveKeyPress(code);
	}

	public void receiveKeyReleased(KeyCode code) {
		myUniverse.receiveKeyRelease(code);
	}

	public Pane getGameView() {
		return myViewController.getGameView();
	}

}
