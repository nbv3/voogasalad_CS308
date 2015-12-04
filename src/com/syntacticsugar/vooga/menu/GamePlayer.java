package com.syntacticsugar.vooga.menu;

public class GamePlayer extends AbstractGameMenu{

	public GamePlayer(SceneManager manager, double width, double height, String title) {
		super(manager, width, height, title);
		generateOptions(createButton("Open Game", e -> this.gameChooser()));
	}

	private Object gameChooser() {
		
		return null;
	}


}
