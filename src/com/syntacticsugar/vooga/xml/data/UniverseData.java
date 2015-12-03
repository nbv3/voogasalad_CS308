package com.syntacticsugar.vooga.xml.data;

public class UniverseData {
	
	private SpawnerData spawns;
	private TowerData towers;
	private MapData map;
	private LevelSettings settings;
	
	public UniverseData(SpawnerData a, TowerData b, MapData c, LevelSettings d) {
		spawns = a;
		towers = b;
		map = c;
		settings = d;
	}
	
	public SpawnerData getSpawns() {
		return spawns;
	}
	
	public TowerData getTowers() {
		return towers;
	}
	
	public MapData getMap() {
		return map;
	}
	
	public LevelSettings getSettings() {
		return settings;
	}
}
