package com.syntacticsugar.vooga.menu;

import com.syntacticsugar.vooga.authoring.AuthoringScreenManager;
import com.syntacticsugar.vooga.authoring.fluidmotion.ParallelTransitionWizard;
import com.syntacticsugar.vooga.authoring.fluidmotion.mixandmatchmotion.DirectionalFadeWizard;
import com.syntacticsugar.vooga.social.SocialCenter;
import com.syntacticsugar.vooga.util.properties.PropertiesManager;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainMenu {

	private Stage myStage;
	private Scene myScene;
	private PropertiesManager myPropertiesManager;

	public MainMenu() {
		// Windows 10 - Bug Fix for JavaFX
		System.setProperty("glass.accessible.force", "false");
		myPropertiesManager = new PropertiesManager("com/syntacticsugar/vooga/resources/View");
		myStage = new Stage();
		myStage.setTitle(myPropertiesManager.getProperty("WindowTitle"));

		Parent scenenode = buildView();
		myScene = new Scene(scenenode);

		myStage.setScene(myScene);
		animatedShowStage();
	}

	private Parent buildView() {
		BorderPane pane = initializePane();
		initializeOptions(pane);
		return pane;

	}

	private void initializeOptions(BorderPane pane) {
		Button launchGame = createButton("Play Game", e -> launch(new GameChooser()));
		Button launchEditor = createButton("Launch Editor", e -> launch(new AuthoringScreenManager()));
		Button launchSocial = createButton("Be Social", e -> launch(new SocialCenter()));
		VBox box = new VBox(10);
		box.getChildren().addAll(launchGame, launchEditor, launchSocial, new HBox());
		box.setMaxWidth(myPropertiesManager.getDoubleProperty("ButtonWidth"));
		BorderPane.setAlignment(box, Pos.CENTER);
		pane.setCenter(box);
	}

	private BorderPane initializePane() {
		BorderPane pane = new BorderPane();
		pane.setPrefWidth(myPropertiesManager.getDoubleProperty("DefaultWidth"));
		pane.getStylesheets().add("/com/syntacticsugar/vooga/gameplayer/css/menu.css");
		Label title = new Label(myPropertiesManager.getProperty("ProgramTitle"));
		BorderPane.setAlignment(title, Pos.CENTER);
		pane.setTop(title);
		return pane;
	}

	private void launch(IVoogaApp app) {
		app.assignCloseHandler(e -> animatedShowStage());
		myStage.hide();
	}

	private void animatedShowStage() {
		DirectionalFadeWizard
			.applyEffect(myStage.getScene().getRoot())
			.play();
		myStage.show();
	}

	private Button createButton(String name, EventHandler<ActionEvent> onAction) {
		Button button = new Button(name);
		button.setMaxWidth(Double.MAX_VALUE);
		button.setOnAction(onAction);
		return button;
	}

}
