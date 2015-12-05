package com.syntacticsugar.vooga.menu;

public class AuthoringGameMenu extends AbstractGameMenu {

	public AuthoringGameMenu(SceneManager manager, double width, double height, String title) {
		super(manager, width, height, title);
//		generateOptions(createButton("New Game", e -> manager.launchNewEditor()),
//				createButton("Load Game", e -> manager.launchLoadEditor()), 
//				createButton("Help", null),
//				createButton("Main Menu", e -> manager.launchFirstMenu()));
	}
}
