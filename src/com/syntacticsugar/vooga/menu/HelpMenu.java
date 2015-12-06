package com.syntacticsugar.vooga.menu;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class HelpMenu extends AbstractMenu {

	public HelpMenu() {
		super("Help");
	}

	@Override
	protected void initializeOptions(BorderPane pane) {
		Button engineHelp = createButton("Engine Help", e -> launchEngineHelp());
		Button authoringHelp = createButton("Authoring Help", e -> launchAuthoringHelp());
		Button socialHelp = createButton("Social Center Help", e -> launchSocialHelp());
		generateOptions(pane, engineHelp, authoringHelp, socialHelp);
	}

	private void launchEngineHelp() {

	}

	private void launchAuthoringHelp() {

	}

	private void launchSocialHelp() {

	}
}
