package com.syntacticsugar.vooga.xml.data;

import java.util.Collection;

public class WaveData {

	private Collection<ObjectData> objs;
	
	public WaveData(Collection<ObjectData> data) {
		objs = data;
	}
	
	public Collection<ObjectData> getObjs () {
		return objs;
	}
	
}
