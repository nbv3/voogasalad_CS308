package com.syntacticsugar.vooga.xml.data;

public class UniverseData {
	
	private SpawnerData spawns;
	private TowerData towers;
	private MapData map;
	
	public UniverseData(SpawnerData a, TowerData b, MapData c) {
		spawns = a;
		towers = b;
		map = c;
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
}
