package com.syntacticsugar.vooga.menu;

public class EnginePauseMenu extends AbstractGameMenu {

	public EnginePauseMenu(SceneManager manager, double width, double height, String title) {
		super(manager, width, height, title);
		generateOptions(createButton("Save Game", null ),
				createButton("Resume Game", e -> manager.launchUnpauseEngine()), 
				createButton("Help", null),
				createButton("Main Menu", e -> manager.launchFirstMenu()));
	}
}
