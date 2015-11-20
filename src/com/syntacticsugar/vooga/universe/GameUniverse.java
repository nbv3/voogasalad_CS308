package com.syntacticsugar.vooga.universe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.syntacticsugar.vooga.objects.IGameObject;
import com.syntacticsugar.vooga.universe.map.IGameMap;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

public class GameUniverse implements IGameUniverse {

	private int myObjectCounter;
	private Collection<IGameObject> myGameObjects;
	private Collection<IGameObject> mySpawnYard;
	private Collection<IGameObject> myGraveYard;
	private IGameMap myGameMap;
	private Collection<KeyCode> myCurrentInput;

	public GameUniverse() {
		myObjectCounter = 0;
		myGameObjects = new ArrayList<IGameObject>();
		// myGameMap = new SimpleGameMap(width, height);
		myCurrentInput = new ArrayList<KeyCode>();
		myGraveYard = new ArrayList<IGameObject>();
	}

	@Override
	public int getNextID() {
		return myObjectCounter++;
	}

	@Override
	public Collection<IGameObject> getGameObjects() {
		return Collections.unmodifiableCollection(myGameObjects);
	}

	@Override
	public void addGameObject(IGameObject toAdd) {
		myGameObjects.add(toAdd);
	}

	@Override
	public void removeGameObject(IGameObject toRemove) {
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
	public void addToSpawnYard(IGameObject toAdd) {
		mySpawnYard.add(toAdd);
	}

	@Override
	public void addToGraveYard(IGameObject toRemove) {
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
	public Collection<IGameObject> getGraveYard() {
		return Collections.unmodifiableCollection(myGraveYard);
	}

	@Override
	public Collection<IGameObject> getSpawnYard() {
		return Collections.unmodifiableCollection(mySpawnYard);
	}
}
