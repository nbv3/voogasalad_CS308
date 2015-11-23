package com.syntacticsugar.vooga.gameplayer.universe;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.map.GameMap;
import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.IGameTile;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

public class GameUniverse implements IGameUniverse {

	private Collection<IGameObject> myGameObjects;
	private Collection<IGameObject> mySpawnYard;
	private Collection<IGameObject> myGraveYard;
	private Collection<IGameObject> myTowers;
	private IGameMap myGameMap;
	private Collection<KeyCode> myCurrentInput;

	public GameUniverse() {
		myGameObjects = new ArrayList<IGameObject>();
		myGameMap = new GameMap(500, 500, 5, 5);
		myCurrentInput = new ArrayList<KeyCode>();
		myGraveYard = new ArrayList<IGameObject>();
		myTowers = new ArrayList<IGameObject>();
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

	@Override
	public IGameTile[][] getTiles() {
		return myGameMap.getTiles();
	}

	@Override
	public boolean[][] isWalkable() {
		return myGameMap.isWalkable();
	}

	@Override
	public boolean[][] isPlaceable() {
		return myGameMap.isPlaceable();
	}

	@Override
	public IGameTile getTile(Point p) {
		return myGameMap.getTile(p);
	}
	
	public void setSpawnYard(Collection<IGameObject> spawnyard){
		mySpawnYard = spawnyard;
	}
	
	public void setTowers(Collection<IGameObject> towers){
		mySpawnYard = towers;
	}
}
