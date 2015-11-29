package com.syntacticsugar.vooga.menu;

public class FirstGameMenu extends AbstractGameMenu {

	public FirstGameMenu(SceneManager manager, double width, double height, String title) {
		super(manager, width, height, title);
		generateOptions(createButton("Let's Play!", e -> manager.initEngineGameMenu()), 
						createButton("Let's Edit!", e -> manager.initAuthoringGameMenu()));
	}
}
