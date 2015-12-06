package com.syntacticsugar.vooga.gameplayer.attribute;

import java.util.Observable;

import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

public class MoneyAttribute extends AbstractAttribute {
	
	private int myMoney;
	
	public MoneyAttribute() {
		myMoney = 0;
	}
	
	public void setMoney(int money) {
		myMoney = money;
	}
	
	public int getMoney() {
		return myMoney;
	}

	@Override
	public void update(Observable o, Object arg) {
		setMoney((Integer) arg);
		
	}

	@Override
	public void updateSelf(IGameUniverse universe) {

	}

}
