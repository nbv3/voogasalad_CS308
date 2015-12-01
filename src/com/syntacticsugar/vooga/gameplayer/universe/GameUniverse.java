package com.syntacticsugar.vooga.gameplayer.universe;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.syntacticsugar.vooga.gameplayer.conditions.IGameCondition;
import com.syntacticsugar.vooga.gameplayer.conditions.PlayerDeathCondition;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.map.GameMap;
import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;

import authoring.data.MapData;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import xml.MapDataXML;

public class GameUniverse implements IGameUniverse {

	private Collection<IGameObject> myPlayers;
	private Collection<IGameObject> myGameObjects;
	private Collection<IGameObject> mySpawnYard;
	private Collection<IGameObject> myGraveYard;
	private List<IGameCondition> myConditions;
	// private Collection<IGameObject> myTowers;
	private IGameMap myGameMap;
	private Collection<KeyCode> myCurrentInput;

	public GameUniverse() {
		myPlayers = new ArrayList<IGameObject>();
		myGameObjects = new ArrayList<IGameObject>();
		MapDataXML xml = new MapDataXML();
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("XML Files", "*.xml"));
		fileChooser.setTitle("Choose Map XML");
		File selectedFile = fileChooser.showOpenDialog(new Stage());
		MapData data = null;
		if (selectedFile != null) {
			data = xml.loadFromFile(selectedFile);
		}
		myGameMap = new GameMap(data);
		myGraveYard = new ArrayList<IGameObject>();
		mySpawnYard = new ArrayList<IGameObject>();
		myConditions = new ArrayList<IGameCondition>();
		myConditions.add(new PlayerDeathCondition());
		myCurrentInput = new ArrayList<KeyCode>();
		// myTowers = new ArrayList<IGameObject>();
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
		} else {
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

	public void setSpawnYard(Collection<IGameObject> spawnyard) {
		mySpawnYard = spawnyard;
	}

	public void setTowers(Collection<IGameObject> towers) {
		mySpawnYard = towers;
	}

	@Override
	public IGameMap getMap() {
		return this.myGameMap;
	}

	@Override
	public Collection<IGameCondition> getConditions() {
		// TODO Auto-generated method stub
		return Collections.unmodifiableCollection(myConditions);
	}
}
