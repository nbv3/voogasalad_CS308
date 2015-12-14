package com.syntacticsugar.vooga.gameplayer.manager;

import com.syntacticsugar.vooga.menu.IVoogaApp;
import com.syntacticsugar.vooga.xml.data.GameData;

import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class ManagerController implements IVoogaApp{
	
	
	private IViewManager myView;
	private IGameManager myGame;
	
	public ManagerController(EventHandler<WindowEvent> onclose, double gameSize, GameData data, double frameRate){
		myView = new ViewManager();
		myGame = new GameManager(myView, onclose, gameSize, data, frameRate);
		myGame.initializeAnimation();
	}

	@Override
	public void assignCloseHandler(EventHandler<WindowEvent> onclose) {
		myView.assignCloseHandler(onclose);
	}


}
