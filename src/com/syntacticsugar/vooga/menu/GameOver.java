package com.syntacticsugar.vooga.menu;

import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.stage.WindowEvent;

public class GameOver extends AbstractMenu {
	
	public GameOver(EventHandler<WindowEvent> onclose){
		super("GAME OVER");
		this.assignCloseHandler(onclose);
	}

	@Override
	public void assignCloseHandler(EventHandler<WindowEvent> onclose) {
		

	}

	@Override
	protected void initializeOptions(BorderPane pane) {
		// TODO Auto-generated method stub
		
	}

}
