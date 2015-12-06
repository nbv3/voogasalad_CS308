package com.syntacticsugar.vooga.gameplayer.attribute;

import com.syntacticsugar.vooga.authoring.parameters.EditableField;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;

public class MoneyAttribute extends AbstractAttribute {

	private int myMoney;

	public MoneyAttribute() {
		myMoney = 0;
	}

	@EditableField(
			inputLabel = "Max Health",
			defaultVal = "0"
			)
	private void editMoney(String arg) {
		try {
			String input = arg.trim();
			int money = Integer.parseInt(input);
			this.myMoney = money;
			AlertBoxFactory.createObject("Assignment successful!");
		} catch (NumberFormatException e) {
			AlertBoxFactory.createObject("Please enter a double.");
		}
	}

	public int getMoney() {
		return myMoney;
	}

	@Override
	public void updateSelf(IGameUniverse universe) {

	}

}
