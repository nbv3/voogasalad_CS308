package com.syntacticsugar.vooga.menu;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.authoring.fluidmotion.mixandmatchmotion.DirectionalFadeWizard;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.dirview.IConverter;
import com.syntacticsugar.vooga.util.dirview.IDirectoryViewer;
import com.syntacticsugar.vooga.xml.XMLFileFilter;
import com.syntacticsugar.vooga.xml.XMLHandler;
import com.syntacticsugar.vooga.xml.data.GameData;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GameChooser implements IVoogaApp, IDirectoryViewer<String> {

	private static final File myDirectory = new File(ResourceManager.getString("game_data"));
	private Stage myStage;
	private ObservableList<String> myGameNames;
	private ListView<String> myView;
	private Map<String, GameData> stringToGameData;
	private Scene myScene;
	private GameData selectedGameData;
	private Button startButton;

	public GameChooser() {
		myStage = new Stage();
		stringToGameData = new HashMap<String, GameData>();
		myGameNames = FXCollections.observableArrayList();
		showDirectoryContents(myDirectory, e -> getGameDescriptions(myDirectory));
		myView = new ListView<String>(myGameNames);
		myView.setOnMouseClicked(e -> {
			if (myView.getSelectionModel().getSelectedItem() != null) {
				startButton.setDisable(false);
			}
			selectedGameData = stringToGameData.get(myView.getSelectionModel().getSelectedItem());
		});

		myView.getItems().add("HEY");
		myView.getItems().add("LOLCANO");

		myScene = new Scene(buildScene());
		myStage.setScene(myScene);
		myStage.show();

	}

	private VBox buildScene() {
		VBox box = new VBox();
		startButton = createButton("Start", e -> startGame());
		startButton.setDisable(true);
		box.getChildren().addAll(myView, startButton);
		return box;
	}

	private void startGame() {
		//SimpleFileChooser.saveGame(makeEmptyData(), new Stage());
		myStage.hide();
		GameData data = selectedGameData;
		System.out.println(data);
		System.out.println(data.getName());
		launchGame(new GameMenu(data));
	}

	private void launchGame(IVoogaApp app) {
		app.assignCloseHandler(e -> animatedShowStage());
		myStage.hide();
	}

	protected void animatedShowStage() {
		DirectionalFadeWizard.applyEffect(myStage.getScene().getRoot()).play();
		myStage.show();
	}

	@Override
	public void assignCloseHandler(EventHandler<WindowEvent> onclose) {
		myStage.setOnCloseRequest(onclose);

	}

	@Override
	public void showDirectoryContents(File directory, IConverter<String> fileConverter) {
		myGameNames.clear();
		myGameNames.addAll(fileConverter.getContents(directory));
	}

	private Collection<String> getGameDescriptions(File directory) {
		// System.out.println(directory);
		File[] files = directory.listFiles(new XMLFileFilter());
		XMLHandler<GameData> xml = new XMLHandler<>();
		Collection<String> names = new ArrayList<String>();
		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			GameData data = xml.read(f);
			String gamename = data.getName();
			names.add(gamename);
			System.out.println(stringToGameData);
			stringToGameData.put(gamename, data);
		}

		return names;

	}

	protected Button createButton(String name, EventHandler<ActionEvent> onAction) {
		Button button = new Button(name);
		button.setFont(new Font(30));
		button.setMaxWidth(Double.MAX_VALUE);
		button.setOnAction(onAction);
		return button;
	}	

}
