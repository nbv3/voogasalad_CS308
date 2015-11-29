package com.syntacticsugar.vooga.menu;

public class EngineGameMenu extends AbstractGameMenu {

	public EngineGameMenu(SceneManager manager, double width, double height, String title) {
		super(manager, width, height, title);
		generateOptions(createButton("New Game", e -> manager.launchNewEngine()),
				createButton("Load Game", e -> manager.launchLoadEngine()), 
				createButton("Help", null),
				createButton("Main Menu", e -> manager.initFirstGameMenu()));
	}
}
