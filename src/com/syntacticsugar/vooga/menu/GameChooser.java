package com.syntacticsugar.vooga.menu;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

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

	public GameChooser() {
		myStage = new Stage();
		myGameNames = FXCollections.observableArrayList();
		showDirectoryContents(myDirectory, e -> getGameDescriptions(myDirectory));
		myView = new ListView<String>(myGameNames);
		
		
		buildScene();
		myScene = new Scene(myView);
		myStage.setScene(myScene);
		myStage.show();
	}

	private void buildScene() {
		VBox box = new VBox();
//		Button startGame = createButton("Start", e -> retrieveDataOnClick())
		
	}
	
	private GameData retrieveDataOnClick(){
		return null;
	}

	private void launchGame(IVoogaApp app) {
		// Create a gameManager and pass the xml file chosen
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
		System.out.println(directory);
		File[] files = directory.listFiles(new XMLFileFilter());
		XMLHandler<GameData> xml = new XMLHandler<>();
		Collection<String> names = new ArrayList<String>();
		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			GameData data = xml.read(f);
			String gamename = data.getName();
			names.add(gamename);
			stringToGameData.put(gamename, data);
		}
		
		return names;

	}
	
	
	private Button createButton(String name, EventHandler<ActionEvent> onAction) {
		Button button = new Button(name);
		button.setFont(new Font(30));
		button.setMaxWidth(Double.MAX_VALUE);
		button.setOnAction(onAction);
		return button;
	}

}
