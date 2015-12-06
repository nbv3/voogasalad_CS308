package com.syntacticsugar.vooga.menu;

import com.syntacticsugar.vooga.help.HelpManager;
import com.syntacticsugar.vooga.util.properties.PropertiesManager;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
		launch(myPropertiesManager.getProperty("enginehelp"));
	}

	private void launchAuthoringHelp() {
		launch(myPropertiesManager.getProperty("authoringhelp"));
	}

	private void launchSocialHelp() {
		launch(myPropertiesManager.getProperty("socialhelp"));
	}
	
	private void launch(String url) {
		Stage stage = new Stage();
		stage.setTitle("Web View");
        Scene scene = new Scene(new HelpManager(url),750,500);
        stage.setScene(scene);
        stage.show();
	}
}
