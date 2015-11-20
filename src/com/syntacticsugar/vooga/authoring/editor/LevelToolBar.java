package com.syntacticsugar.vooga.authoring.editor;

import javafx.scene.control.Button;

public class LevelToolBar extends EditorToolbar{
	
	public LevelToolBar(){
		super("Level Tools");
		createAddLevelOption();
		createRemoveLevelOption();
		createChangeLevelOption();
	}
	
	private void createAddLevelOption() {
		Button add = createToolbarItem("Add");
	}

	private void createRemoveLevelOption() {

	}

	private void createChangeLevelOption() {
		Button remove = createToolbarItem("Change Level");
	}
	
	private void switchGridScene()
	{
		
	}

}
