package com.syntacticsugar.vooga.gameplayer.view.implementation;

import com.syntacticsugar.vooga.gameplayer.view.AbstractGameMenu;
import com.syntacticsugar.vooga.gameplayer.view.IViewManager;


/**
 * 
 * Organizes and manages the game window, including starting/pausing and displaying menu. 
 *
 */

public class GameMenu extends AbstractGameMenu {

	public GameMenu(IViewManager manager, double width, double height, String title) {
		super(manager, width, height, title);
		generateOptions(createButton("New Game", e -> manager.launchGame()),
						createButton("Load Game", null), 
						createButton("Help", null),
						createButton("Main Menu", null));
	}

}
