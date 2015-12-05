package com.syntacticsugar.vooga.gameplayer.universe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observer;

import com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.conditions.Conditions;
import com.syntacticsugar.vooga.gameplayer.conditions.implementation.EnemyDeathCondition;
import com.syntacticsugar.vooga.gameplayer.conditions.implementation.PlayerDeathCondition;
import com.syntacticsugar.vooga.gameplayer.event.ICollisionEvent;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.HealthChangeEvent;
import com.syntacticsugar.vooga.gameplayer.manager.IEventManager;
import com.syntacticsugar.vooga.gameplayer.objects.GameObject;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.objects.towers.Tower;
import com.syntacticsugar.vooga.gameplayer.universe.map.GameMap;
import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;
import com.syntacticsugar.vooga.gameplayer.universe.score.IScore;
import com.syntacticsugar.vooga.gameplayer.universe.score.Score;
import com.syntacticsugar.vooga.gameplayer.universe.spawner.ISpawner;
import com.syntacticsugar.vooga.gameplayer.universe.spawner.Spawner;
import com.syntacticsugar.vooga.gameplayer.view.IViewAdder;
import com.syntacticsugar.vooga.gameplayer.view.IViewRemover;
import com.syntacticsugar.vooga.xml.XMLHandler;
import com.syntacticsugar.vooga.xml.data.GlobalSettings;
import com.syntacticsugar.vooga.xml.data.LevelSettings;
import com.syntacticsugar.vooga.xml.data.MapData;
import com.syntacticsugar.vooga.xml.data.ObjectData;
import com.syntacticsugar.vooga.xml.data.SpawnerData;
import com.syntacticsugar.vooga.xml.data.TowerData;
import com.syntacticsugar.vooga.xml.data.UniverseData;

import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

public class GameUniverse implements IGameUniverse {

	private Collection<IGameObject> myGameObjects;
	private Collection<IGameObject> myTowers;
	private SpawnYard mySpawnYard;
	private GraveYard myGraveYard;
	private Conditions myConditions;
	private ISpawner mySpawner;
	private IGameMap myGameMap;
	private IScore myScore;

	private Collection<KeyCode> myCurrentInput;

	private IEventManager myPoster;

	public GameUniverse(UniverseData data, GlobalSettings settings, IEventManager manager) {

		myPoster = manager;
		myScore = new Score(manager, data.getSettings());
		myConditions = new Conditions(manager);
		myGameObjects = new ArrayList<IGameObject>();
		myGameMap = new GameMap(data.getMap());
		mySpawner = new Spawner(data.getSpawns().getWaves(), this, settings.getSpawnRate());
		myTowers = new ArrayList<>();
		Collection<ObjectData> towerdata = data.getTowers().getTowers();
		for (ObjectData d : towerdata) {
			myTowers.add(new Tower(d));
		}
		myGraveYard = new GraveYard(this, manager);
		mySpawnYard = new SpawnYard(this, manager);
		myCurrentInput = new ArrayList<KeyCode>();
		myConditions.addCondition(new PlayerDeathCondition());
		myConditions.addCondition(new EnemyDeathCondition(3));
	}


	@Override
	public Collection<IGameObject> getGameObjects() {
		return Collections.unmodifiableCollection(myGameObjects);
	}

	@Override
	public void addGameObject(IGameObject toAdd) {
		System.out.println("ADD");
		myGameObjects.add(toAdd);
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
		mySpawnYard.addToYard(toAdd);
	}

	@Override
	public void addToGraveYard(IGameObject toRemove) {
		myGraveYard.addToYard(toRemove);
	}

	@Override
	public void removeFromUniverse(IViewRemover remover) {
		myGraveYard.alterUniverse(remover);

	}

	@Override
	public void addToUniverse(IViewAdder adder) {
		mySpawnYard.alterUniverse(adder);
	}

	@Override
	public IGameMap getMap() {
		return this.myGameMap;
	}

	@Override
	public void removeGameObject(IGameObject obj) {
		System.out.println("HERE");
		myGameObjects.remove(obj);
	}

	@Override
	public SpawnYard getSpawnYard() {
		return mySpawnYard;
	}

	@Override
	public GraveYard getGraveYard() {
		return myGraveYard;
	}

	@Override
	public ISpawner getSpawner() {
		return mySpawner;
	}

	@Override
	public void postEvent(IGameEvent event) {
		myPoster.postEvent(event);
	}

//	TODO : THIS WON'T WORK
	@Override
	public UniverseData saveGame() {
		SpawnerData spawn = mySpawner.saveGame();
		TowerData towers = saveTowers();
		MapData map = new MapData(myGameMap);
		LevelSettings settings = new LevelSettings(myScore.getScoreThreshold());
		UniverseData data = new UniverseData(spawn, towers, map, settings);
		return data;
	}

	private TowerData saveTowers() {
		Collection<ObjectData> data = new ArrayList<>();
		for (IGameObject o : myTowers) {
			data.add(new ObjectData(o));
		}
		return new TowerData(data);
	}

	@Override
	public Collection<ObjectData> getAvailableTowers() {
		List<ObjectData> towerData = new ArrayList<ObjectData>();
		for (IGameObject tower : myTowers) {
			towerData.add(new ObjectData(tower));
		}
		return towerData;
	}

	@Override
	public IScore getScore() {
		return myScore;
	}

	@Override
	public void observeScore(Observer observer) {
		myScore.addObserver(observer);
	}
}
