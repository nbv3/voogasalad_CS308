package com.syntacticsugar.vooga.menu;

import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GameChooser implements IVoogaApp {
	
	private Stage myStage;
	
	public GameChooser(){
		myStage = new Stage();
	}

	@Override
	public void assignCloseHandler(EventHandler<WindowEvent> onclose) {
		myStage.setOnCloseRequest(onclose);

	}

}
