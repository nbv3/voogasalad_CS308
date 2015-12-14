package com.syntacticsugar.vooga.menu;

import com.syntacticsugar.vooga.gameplayer.event.GameEventType;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GameOver implements IVoogaApp {

	private Stage myStage;
	private String image;

	public GameOver(EventHandler<WindowEvent> onclose, GameEventType type){
		if(type.equals(GameEventType.Winning)){
			image = "winning.gif";
		}
		else
			image = "gameover.gif";
		
		myStage = new Stage();
		this.assignCloseHandler(onclose);
		ImageView parent = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(image)));
		Scene scene = new Scene(new Pane(parent));
		myStage.setScene(scene);
		myStage.show();
	}

	@Override
	public void assignCloseHandler(EventHandler<WindowEvent> onclose) {
		myStage.setOnCloseRequest(onclose);

	}

}
