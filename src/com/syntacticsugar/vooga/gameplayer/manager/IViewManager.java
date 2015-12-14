package com.syntacticsugar.vooga.gameplayer.manager;

import com.syntacticsugar.vooga.gameplayer.event.GameEventType;
import com.syntacticsugar.vooga.gameplayer.view.gameview.GameView;
import com.syntacticsugar.vooga.menu.IVoogaApp;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public interface IViewManager extends IVoogaApp {
	
	public void initializeView(GameView gv, EventHandler<KeyEvent> presshandle, EventHandler<KeyEvent> releasehandle);

	public void createGameOver(GameEventType type);
	
}
