package simple.universe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import simple.obj.ISimpleObject;
import simple.universe.map.ISimpleGameMap;

public class SimpleUniverse implements ISimpleUniverse {

	private Collection<ISimpleObject> myGameObjects;
	private ISimpleGameMap myGameMap;
	private Collection<KeyCode> myCurrentInput;

	public SimpleUniverse() {
		myGameObjects = new ArrayList<ISimpleObject>();
//		myGameMap = new SimpleGameMap(width, height);
		myCurrentInput = new ArrayList<KeyCode>();
	}
	
	@Override
	public Collection<ISimpleObject> getGameObjects() {
		return Collections.unmodifiableCollection(myGameObjects);
	}

	@Override
	public void addGameObject(ISimpleObject toAdd) {
		myGameObjects.add(toAdd);
	}

	@Override
	public void removeGameObject(ISimpleObject toRemove) {
		myGameObjects.remove(toRemove);
	}

	@Override
	public boolean[][] retrievePath() {
		return myGameMap.retrievePath();
	}

	@Override
	public void receiveKeyPress(KeyCode code) {
		if (!myCurrentInput.contains(code)) {
			myCurrentInput.add(code);
		}
	}

	@Override
	public void receiveKeyRelease(KeyCode code) {
		if (myCurrentInput.contains(code)) {
			myCurrentInput.remove(code);
		}
	}

	@Override
	public void receiveMouseEvent(MouseEvent mouseEvent) {
		// TODO handle mouse input??????
	}

	@Override
	public Collection<KeyCode> getCurrentKeyInput() {
		return Collections.unmodifiableCollection(myCurrentInput);
	}

}
