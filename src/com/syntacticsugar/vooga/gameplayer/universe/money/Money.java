package com.syntacticsugar.vooga.gameplayer.universe.money;

import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.MoneyChangeEvent;

public class Money implements IMoney {
	
	private int myMoney;
	
	public Money() {
		myMoney = 0;
	}

	@Override
	public void onEvent(IGameEvent e) {
		try {
			MoneyChangeEvent event = (MoneyChangeEvent) e;
			changeMoney(event.getMoney());
		}
		catch (ClassCastException ex) {
			
		}
	}
	
	private void changeMoney(int money) {
		myMoney += money;
	}

	@Override
	public int getMoney() {
		return myMoney;
	}

}
