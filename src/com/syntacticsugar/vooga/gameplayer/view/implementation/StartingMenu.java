package com.syntacticsugar.vooga.gameplayer.view.implementation;

import com.syntacticsugar.vooga.gameplayer.view.AbstractGameMenu;
import com.syntacticsugar.vooga.gameplayer.view.IViewManager;

/**
 * 
 * Menu implementation, allows choice Game/Editor
 * 
 */
public class StartingMenu extends AbstractGameMenu {

	public StartingMenu(IViewManager manager, double width, double height, String title) {
		super(manager, width, height, title);
		generateOptions(createButton("Let's Play!", e -> launchGame()), 
						createButton("Let's Edit!", e -> launchEditor()));
	}

}
