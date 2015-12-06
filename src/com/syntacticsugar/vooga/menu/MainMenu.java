package com.syntacticsugar.vooga.menu;

import com.syntacticsugar.vooga.authoring.AuthoringScreenManager;
import com.syntacticsugar.vooga.social.SocialCenter;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class MainMenu extends AbstractMenu{

	public MainMenu() {
		super("Synctactic Sugar");
	}

	@Override
	protected void initializeOptions(BorderPane pane) {
		Button launchGame = createButton("Play Game", e -> launch(new GameChooser()));
		Button launchEditor = createButton("Launch Editor", e -> launch(new AuthoringScreenManager()));
		Button launchSocial = createButton("Be Social", e -> launch(new SocialCenter()));
		Button launchHelp = createButton("Help", e -> launch(new HelpMenu()));
		generateOptions(pane, launchGame, launchEditor, launchSocial, launchHelp);
	}
	
	private void launch(IVoogaApp app) {
		app.assignCloseHandler(e -> animatedShowStage());
		hideStage();
	}
	
}
