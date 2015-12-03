package com.syntacticsugar.vooga.xml.data;

import java.util.Collection;

public class TowerData {
	
	private Collection<ObjectData> towers;
	
	public TowerData(Collection<ObjectData> data) {
		towers = data;
	}
	
	public Collection<ObjectData> getTowers() {
		return towers;
	}

}
