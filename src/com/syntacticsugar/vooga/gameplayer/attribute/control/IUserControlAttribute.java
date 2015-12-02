package com.syntacticsugar.vooga.gameplayer.attribute.control;

import com.syntacticsugar.vooga.gameplayer.universe.userinput.IKeyInputStorage;

public interface IUserControlAttribute {
	
	public void updateKeyInput(IKeyInputStorage universeKeyInput);
	
	public void processKeyInput();
	
}

