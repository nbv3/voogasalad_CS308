package com.syntacticsugar.vooga.gameplayer.objects.towers;

import com.syntacticsugar.vooga.gameplayer.objects.GameObject;
import com.syntacticsugar.vooga.xml.data.ObjectData;
import com.syntacticsugar.vooga.xml.data.TowerData;

public class Tower extends GameObject implements ITower {
	
	private int myCost;
	
	public Tower(TowerData data) {
		super(data);
	}
	
	public int getCost() {
		return myCost;
	}

}
