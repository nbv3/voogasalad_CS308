package com.syntacticsugar.vooga.xml.data;

import com.syntacticsugar.vooga.gameplayer.objects.towers.ITower;

public class TowerData extends ObjectData {
	
	private int cost;
	
	private static final long serialVersionUID = 2L;
	
	public TowerData(ITower o) {
		super(o);
		cost = o.getCost();
	}
	
	public TowerData() {
		
	}

	public int getCost() {
		return cost;
	}
	
	public void setCost(int c) {
		cost = c;
	}

}
