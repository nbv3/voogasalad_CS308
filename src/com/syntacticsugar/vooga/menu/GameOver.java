package com.syntacticsugar.vooga.menu;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GameOver implements IVoogaApp {

	private Stage myStage;

	public GameOver(EventHandler<WindowEvent> onclose){
		myStage = new Stage();
		this.assignCloseHandler(onclose);
		ImageView parent = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("gameover.gif")));
		Scene scene = new Scene(new Pane(parent));
		myStage.setScene(scene);
		myStage.show();
	}

	@Override
	public void assignCloseHandler(EventHandler<WindowEvent> onclose) {
		myStage.setOnCloseRequest(onclose);

	}

}
