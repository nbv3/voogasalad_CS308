package com.syntacticsugar.vooga.gameplayer.universe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.map.GameMap;
import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.DecoratorTile;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.IGameTile;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

public class GameUniverse implements IGameUniverse {

	private Collection<IGameObject> myPlayers;
	private Collection<IGameObject> myGameObjects;
	private Collection<IGameObject> mySpawnYard;
	private Collection<IGameObject> myGraveYard;
//	private Collection<IGameObject> myTowers;
	private IGameMap myGameMap;
	private Collection<KeyCode> myCurrentInput;

	public GameUniverse() {
		myPlayers = new ArrayList<IGameObject>();
		myGameObjects = new ArrayList<IGameObject>();
		myGameMap = new GameMap(10);
		myCurrentInput = new ArrayList<KeyCode>();
		mySpawnYard = new ArrayList<IGameObject>();
		myGraveYard = new ArrayList<IGameObject>();
//		myTowers = new ArrayList<IGameObject>();
	}

	@Override
	public void addPlayer(IGameObject player) {
		if (player.getType().equals(GameObjectType.PLAYER))	
			myPlayers.add(player);
	}
	
	@Override
	public Collection<IGameObject> getPlayers() {
		return Collections.unmodifiableCollection(myPlayers);
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
		if (toRemove.getType().equals(GameObjectType.PLAYER)) {
			myPlayers.remove(toRemove);
		}
		else {
			myGameObjects.remove(toRemove);
		}
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
	public Collection<DecoratorTile> getTiles() {
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
	public IGameTile getTile(Point2D p) {
		return myGameMap.getTile(p);
	}
	
	public void setSpawnYard(Collection<IGameObject> spawnyard){
		mySpawnYard = spawnyard;
	}
	
	public void setTowers(Collection<IGameObject> towers){
		mySpawnYard = towers;
	}
}
