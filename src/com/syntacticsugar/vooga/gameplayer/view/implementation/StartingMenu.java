package com.syntacticsugar.vooga.gameplayer.view.implementation;

import com.syntacticsugar.vooga.gameplayer.view.AbstractGameMenu;
import com.syntacticsugar.vooga.gameplayer.view.IViewManager;

import javafx.scene.Node;
import javafx.scene.control.Button;

/**
 * 
 * Menu implementation, allows choice Game/Editor
 * 
 */

public class StartingMenu extends AbstractGameMenu {

	public StartingMenu(IViewManager manager, double width, double height, String title) {
		super(manager, width, height, title);
		generateOptions(createLaunchGameButton(), createLaunchEditorButton());
	}

	private Node createLaunchEditorButton() {
		Button edit = createButton("Let's edit");
		edit.setOnAction(e -> launchEditor());
		return edit;
	}

	private Node createLaunchGameButton() {
		Button launch = createButton("Play!");
		launch.setOnAction(e -> launchGame());
		return launch;
	}

}
