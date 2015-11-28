package com.syntacticsugar.vooga.gameplayer.attribute.control;

import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.IControlAction;
import com.syntacticsugar.vooga.gameplayer.universe.userinput.IKeyInputStorage;

import javafx.scene.input.KeyCode;

public interface IUserControlAttribute {
	
	public void updateKeyInput(IKeyInputStorage universeKeyInput);
	
	public void processKeyInput();
	
}

