package com.syntacticsugar.vooga.gameplayer.objects.towers;

import com.syntacticsugar.vooga.gameplayer.objects.GameObject;
import com.syntacticsugar.vooga.xml.data.ObjectData;

public class Tower extends GameObject implements ITower {
	
	private int myCost;
	
	public Tower(ObjectData data) {
		super(data);
	}
	
	public int getCost() {
		return myCost;
	}

}
