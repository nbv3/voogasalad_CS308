package com.syntacticsugar.vooga.authoring.level;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import com.syntacticsugar.vooga.authoring.objectediting.IVisualElement;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.gui.factory.MsgInputBoxFactory;
import com.syntacticsugar.vooga.xml.data.LevelSettings;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LevelConditionManager implements IVisualElement {

	private GridPane myView;
	private ComboBox<String> myWins;
	private ComboBox<String> myLose;
	private TextField mySpawnInput;
	private TextField myCash;

	private List<Double> myWinParameters;
	private List<Double> myLoseParameters;

	private String mySelectedWin;
	private String mySelectedLose;
	private int mySavedSpawnRate;
	private int mySetCash;

	public LevelConditionManager() {
		myView = new GridPane();

		mySpawnInput = new TextField();
		mySpawnInput.getStyleClass().add("textfield");
		mySpawnInput.setPromptText(ResourceManager.getString("int_SpawnRate"));

		myCash = new TextField();
		myCash.setPromptText(ResourceManager.getString("int_InitialCash"));
		myCash.getStyleClass().add("textfield");
		
		ObservableList<String> winOptions = FXCollections.observableArrayList(ResourceManager.getString("enemy_death"));
		myWins = new ComboBox<String>(winOptions);
		myWins.setPrefWidth(200);
		myWins.getStyleClass().add("combobox");
		myWinParameters = new ArrayList<Double>();

		ObservableList<String> loseOptions = FXCollections.observableArrayList(ResourceManager.getString("destination"),
				ResourceManager.getString("player_death"));
		myLose = new ComboBox<String>(loseOptions);
		myLose.setPrefWidth(200);
		myLose.getStyleClass().add("combobox");
		myLoseParameters = new ArrayList<Double>();

		myWins.valueProperty().addListener((o, s1, s2) -> updateSelectedWin(s2));
		myLose.valueProperty().addListener((o, s1, s2) -> updateSelectedLose(s2));

		Label win = new Label(ResourceManager.getString("win_condition"));
		win.setAlignment(Pos.CENTER);
		Label lose = new Label(ResourceManager.getString("lose_condition"));
		lose.setAlignment(Pos.CENTER);

		myView.add(win, 0, 0, 1, 1);
		myView.add(lose, 0, 2, 1, 1);
		myView.add(myWins, 0, 1, 1, 1);
		myView.add(myLose, 0, 3, 1, 1);
		myView.add(mySpawnInput, 0, 4, 1, 1);
		myView.add(myCash, 0, 5, 1, 1);

		myView.setPadding(new Insets(10, 10, 10, 10));
		myView.setVgap(10);
		myView.setAlignment(Pos.CENTER);
	}

	private void updateSelectedWin(String w) {
		mySelectedWin = w;
		String classPath = String.format("%s%s%s", ResourceManager.getString("conditions"),
				mySelectedWin.replace(" ", ""), "Condition");

		try {
			Class<?> c = Class.forName(classPath);
			Constructor<?>[] constr = c.getDeclaredConstructors();
			Class<?>[] parameterTypes = constr[0].getParameterTypes();

			for (int i = 0; i < parameterTypes.length; i++) {
				MsgInputBoxFactory msgBox = new MsgInputBoxFactory(String.format("Set %s Value", mySelectedWin));
				myWinParameters.add(msgBox.getInputValue());
			}

		} catch (SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void updateSelectedLose(String l) {
		mySelectedLose = l;
		String classPath = String.format("%s%s%s", ResourceManager.getString("conditions"),
				mySelectedLose.replace(" ", ""), "Condition");
		try {
			Class<?> c = Class.forName(classPath);
			Constructor<?>[] constr = c.getDeclaredConstructors();
			Class<?>[] parameterTypes = constr[0].getParameterTypes();

			for (int i = 0; i < parameterTypes.length; i++) {
				MsgInputBoxFactory msgBox = new MsgInputBoxFactory(String.format("Set %s Value", mySelectedLose));
				myLoseParameters.add(msgBox.getInputValue());
			}
		} catch (SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String getLosingCondition() {
		return mySelectedLose;
	}

	public List<Double> getWinParameters() {
		return myWinParameters;
	}

	public List<Double> getLoseParameters() {
		return myLoseParameters;
	}

	public String getWinningCondition() {
		return mySelectedWin;
	}

	public void saveSpawnRate() {
		try {
			mySavedSpawnRate = Integer.parseInt(mySpawnInput.getText());
		} catch (Exception e) {
			AlertBoxFactory.createObject(ResourceManager.getString("not_integer"));
		}
	}

	public void saveCash() {
		try {
			mySetCash = Integer.parseInt(myCash.getText());

		} catch (Exception e) {
			AlertBoxFactory.createObject(ResourceManager.getString("not_integer"));
		}
	}

	public Node getView() {
		return myView;
	}

	public LevelSettings getConditions() {
		saveSpawnRate();
		saveCash();
		LevelSettings settings = new LevelSettings(mySelectedWin, myWinParameters, mySelectedLose, myLoseParameters,
				mySavedSpawnRate, mySetCash);
		return settings;
	}
}
