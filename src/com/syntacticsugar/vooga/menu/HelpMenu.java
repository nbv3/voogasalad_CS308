package com.syntacticsugar.vooga.menu;

import com.syntacticsugar.vooga.util.browser.BrowserManager;
import com.syntacticsugar.vooga.util.properties.PropertiesManager;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class HelpMenu extends AbstractMenu {
	
	private PropertiesManager myPropertiesManager;

	public HelpMenu() {
		super("Help");
		myPropertiesManager = new PropertiesManager("com/syntacticsugar/vooga/resources/Help");
	}

	@Override
	protected void initializeOptions(BorderPane pane) {
		Button engineHelp = createButton("Engine Help", e -> launchEngineHelp());
		Button authoringHelp = createButton("Authoring Help", e -> launchAuthoringHelp());
		Button socialHelp = createButton("Social Center Help", e -> launchSocialHelp());
		generateOptions(pane, engineHelp, authoringHelp, socialHelp);
	}

	private void launchEngineHelp() {
		BrowserManager.open(myPropertiesManager.getProperty("enginehelp"));
	}

	private void launchAuthoringHelp() {
		BrowserManager.open(myPropertiesManager.getProperty("authoringhelp"));
	}

	private void launchSocialHelp() {
		BrowserManager.open(myPropertiesManager.getProperty("socialhelp"));
	}
}
