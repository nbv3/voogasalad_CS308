package com.syntacticsugar.vooga.menu;

import com.syntacticsugar.vooga.authoring.AuthoringScreenManager;
import com.syntacticsugar.vooga.social.SocialCenter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu {

	private Stage myStage;
	private Scene myScene;

	public MainMenu() {
		myStage = new Stage();
		
		Parent scenenode = buildView();
		myScene = new Scene(scenenode);
		
		myStage.setScene(myScene);
		myStage.show();
	}

	private Parent buildView() {
		Button launchGame = createButton("Play Game", e -> launch(new GameChooser()));
		Button launchEditor = createButton("Launch Editor", e -> launch(new AuthoringScreenManager()));
		Button launchSocial = createButton("Be Social", e -> launch(new SocialCenter()));
		VBox box = new VBox(10);
		box.getChildren().addAll(launchGame, launchEditor, launchSocial);
		return box;
		
	}

	private void launch(IVoogaApp app) {
		app.assignCloseHandler(e -> myStage.show());
		myStage.hide();
	}

	private Button createButton(String name, EventHandler<ActionEvent> onAction) {
		Button button = new Button(name);
		button.setMaxWidth(Double.MAX_VALUE);
		button.setOnAction(onAction);
		return button;
	}

}
