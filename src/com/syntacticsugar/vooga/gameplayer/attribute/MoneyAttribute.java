package com.syntacticsugar.vooga.gameplayer.attribute;

import com.syntacticsugar.vooga.authoring.parameters.EditableClass;
import com.syntacticsugar.vooga.authoring.parameters.EditableField;
import com.syntacticsugar.vooga.authoring.parameters.InputParser;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

@EditableClass (
		className = "Monetary Value"
		)
public class MoneyAttribute extends AbstractAttribute {

	private int myMoney;

	public MoneyAttribute() {
		super();
	}

	@Override
	public void setDefaults() {
		this.myMoney = 100;
	}
	
	public int getMoney() {
		return myMoney;
	}

	@Override
	public void updateSelf(IGameUniverse universe) {

	}
	
	
	/**		  	      EDIT TAGS	     		    **/
	/** *************************************** **/
	
	@EditableField(
			inputLabel = "Money",
			defaultVal = "100", getClassType = int.class
			)
	private void editMoney(String arg) {
		try {
			this.myMoney = InputParser.parseAsInt(arg);
		} catch (NumberFormatException e) {	}
	}

}
