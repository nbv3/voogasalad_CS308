// This entire file is part of my masterpiece.
// Nicholas von Turkovich (nbv3)

package com.syntacticsugar.vooga.gameplayer.manager;

import com.syntacticsugar.vooga.gameplayer.event.GameEventType;
import com.syntacticsugar.vooga.gameplayer.view.gameview.GameView;
import com.syntacticsugar.vooga.menu.GameOver;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class ViewManager implements IViewManager{
	
	private Stage myStage;
	private Scene myScene;
	private EventHandler<WindowEvent> onClose;

	public ViewManager() {
		myStage = new Stage();
	}

	@Override
	public void initializeView(GameView gv, EventHandler<KeyEvent> presshandle, EventHandler<KeyEvent> releasehandle) {
		myScene = new Scene(gv);
		myScene.setOnKeyPressed(presshandle);
		myScene.setOnKeyReleased(releasehandle);
		myStage.setScene(myScene);
		myStage.show();
	}

	@Override
	public void assignCloseHandler(EventHandler<WindowEvent> onclose) {
		onClose = onclose;
		myStage.setOnCloseRequest(onclose);
	}

	@Override
	public void createGameOver(GameEventType type) {
		myStage.close();
		new GameOver(onClose, type);
		
	}

}
