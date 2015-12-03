package com.syntacticsugar.vooga.xml.data;

import java.util.Collection;

public class GameData {
	private Collection<UniverseData> universes;
	private GlobalSettings settings;
	
	public GameData(Collection<UniverseData> data, GlobalSettings s) {
		universes = data;
		settings = s;
	}
	
	public Collection<UniverseData> getUniverses() {
		return universes;
	}
	
	public GlobalSettings getSettings() {
		return settings;
	}
}
