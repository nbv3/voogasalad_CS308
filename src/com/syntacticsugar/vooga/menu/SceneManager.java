package com.syntacticsugar.vooga.menu;

import java.util.ArrayList;
import java.util.Collection;

import com.syntacticsugar.vooga.authoring.AuthoringScreenManager;
import com.syntacticsugar.vooga.gameplayer.manager.GameManager;
import com.syntacticsugar.vooga.xml.data.GameData;
import com.syntacticsugar.vooga.xml.data.GlobalSettings;
import com.syntacticsugar.vooga.xml.data.MapData;
import com.syntacticsugar.vooga.xml.data.ObjectData;
import com.syntacticsugar.vooga.xml.data.SpawnerData;
import com.syntacticsugar.vooga.xml.data.TowerData;
import com.syntacticsugar.vooga.xml.data.UniverseData;
import com.syntacticsugar.vooga.xml.data.WaveData;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {
	private final double WIDTH = 600.0;
	private final double HEIGHT = 600.0;
	private final double GAME_SIZE = 600.0;
	private Stage myStage;
	private final String TITLE = "Vooga Salad";
	
	private final double FRAME_LENGTH = 1 / 60.0;
	
	public SceneManager(Stage stage) {
		// Windows 10 - Bug Fix for JavaFX
		System.setProperty("glass.accessible.force", "false");
		myStage = stage;
		myStage.setTitle(TITLE);
		launchFirstMenu();
	}
	
	private void viewScene(AbstractGameMenu screen) {
		Scene scene = new Scene(screen, WIDTH, HEIGHT);
		myStage.setScene(scene);
		myStage.show();
	}
	
	public void launchFirstMenu() {
		AbstractGameMenu screen = new FirstGameMenu(this, WIDTH, HEIGHT, TITLE);
		viewScene(screen);
	}
	
	public void launchAuthoringMenu() {	
		AbstractGameMenu screen = new AuthoringGameMenu(this, WIDTH, HEIGHT, TITLE);
		viewScene(screen);
	}
	
	public void launchEngineMenu() {
		AbstractGameMenu screen = new EngineGameMenu(this, WIDTH, HEIGHT, TITLE);
		viewScene(screen);
	}
	
	public void launchNewEditor() {
		myStage.hide();
		new AuthoringScreenManager(e -> launchFirstMenu());
	}
	
	public void launchLoadEditor() {
		myStage.hide();
		// TODO load from XML here or within GameManager?
		new AuthoringScreenManager(e -> launchFirstMenu());
	}
	
	public void launchNewEngine() {
		GameData data = makeEmptyData();
		new GameManager(e -> launchFirstMenu(), GAME_SIZE, data, FRAME_LENGTH);
		myStage.hide();
	}
	
	public void launchLoadEngine() {
		// TODO modify to do direct load instead of launch
		GameData data = makeEmptyData();
		new GameManager(e -> launchFirstMenu(), GAME_SIZE, data, FRAME_LENGTH);
		myStage.hide();
		// TODO load from XML here or within GameManager?
		
	}
	
	private GameData makeEmptyData() {
		SpawnerData spawn = new SpawnerData(new ArrayList<WaveData>());
		MapData map = new MapData(10, "gray.png");
		TowerData towers = new TowerData(new ArrayList<ObjectData>());
		Collection<UniverseData> uni = new ArrayList<>();
		uni.add(new UniverseData(spawn, towers, map));
		GlobalSettings settings = new GlobalSettings(1, 60);
		GameData data = new GameData(uni, settings);
		return data;
	}
	
}
