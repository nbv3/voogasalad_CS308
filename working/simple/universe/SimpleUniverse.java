package simple.universe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import simple.obj.ISimpleObject;
import simple.universe.map.ISimpleGameMap;

public class SimpleUniverse implements ISimpleUniverse {

	private int myObjectCounter;
	private Collection<ISimpleObject> myGameObjects;
	private Collection<ISimpleObject> mySpawnYard;
	private Collection<ISimpleObject> myGraveYard;
	private ISimpleGameMap myGameMap;
	private Collection<KeyCode> myCurrentInput;

	public SimpleUniverse() {
		myObjectCounter = 0;
		myGameObjects = new ArrayList<ISimpleObject>();
		// myGameMap = new SimpleGameMap(width, height);
		myCurrentInput = new ArrayList<KeyCode>();
		myGraveYard = new ArrayList<ISimpleObject>();
	}

	@Override
	public int getNextID() {
		return myObjectCounter++;
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

	@Override
	public void addToSpawnYard(ISimpleObject toAdd) {
		mySpawnYard.add(toAdd);
	}

	@Override
	public void addToGraveYard(ISimpleObject toRemove) {
		myGraveYard.add(toRemove);
	}

	@Override
	public void clearSpawnYard() {
		mySpawnYard.clear();

	}

	@Override
	public void clearGraveYard() {
		myGraveYard.clear();

	}

	@Override
	public Collection<ISimpleObject> getGraveYard() {
		// TODO Auto-generated method stub
		return myGraveYard;
	}

}
