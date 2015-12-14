package com.syntacticsugar.vooga.gameplayer.manager;

import com.syntacticsugar.vooga.menu.IVoogaApp;
import com.syntacticsugar.vooga.xml.data.GameData;

import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class ManagerController implements IVoogaApp{
	
	private EventHandler<WindowEvent> onClose;
	private double myGameSize;
	private GameData myGameData;
	private double myFrameRate;
	private ViewManager myView;
	private GameManager myGame;
	
	public ManagerController(EventHandler<WindowEvent> onclose, double gameSize, GameData data, double frameRate){
		onClose = onclose;
		myGameSize = gameSize;
		myGameData = data;
		myFrameRate = frameRate;
		myGame = new GameManager(onclose, gameSize, data, frameRate);
		myView = new ViewManager();
	}

	@Override
	public void assignCloseHandler(EventHandler<WindowEvent> onclose) {
		// TODO Auto-generated method stub
		
	}


}
