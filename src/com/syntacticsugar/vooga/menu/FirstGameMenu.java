package com.syntacticsugar.vooga.menu;

public class FirstGameMenu extends AbstractGameMenu {

	public FirstGameMenu(SceneManager manager, double width, double height, String title) {
		super(manager, width, height, title);
		generateOptions(createButton("Play Game", e -> manager.launchEngineMenu()), 
						createButton("Edit Game", e -> manager.launchAuthoringMenu()),
						createButton("Social Center", e -> manager.launchSocialCenter()));
	}
}
