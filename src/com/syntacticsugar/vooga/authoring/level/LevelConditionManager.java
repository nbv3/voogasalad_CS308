// This entire file is part of my masterpiece.
// Elsie Ling

package com.syntacticsugar.vooga.authoring.level;

import com.syntacticsugar.vooga.authoring.objectediting.IVisualElement;
import com.syntacticsugar.vooga.authoring.parameters.ParameterInputFactory;
import com.syntacticsugar.vooga.gameplayer.conditions.IGameCondition;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.gui.factory.TextFieldFactory;
import com.syntacticsugar.vooga.util.reflection.Reflection;
import com.syntacticsugar.vooga.util.reflection.ReflectionException;
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
	private TextField myCashInput;

	private IGameCondition mySelectedWin;
	private IGameCondition mySelectedLose;
	private int mySetCash;

	public LevelConditionManager() {
		myView = new GridPane();

		myCashInput = TextFieldFactory.buildStylizedField(ResourceManager.getString("int_InitialCash"),
				ResourceManager.getString("textfield"));

		ObservableList<String> winOptions = FXCollections.observableArrayList(ResourceManager.getString("enemy_death"),
				ResourceManager.getString("score"));
		myWins = ComboBoxFactory.buildStylizedComboBox(winOptions, ResourceManager.getString("combobox"), 200);
		myWins.valueProperty().addListener((o, s1, s2) -> updateSelectedCondition(mySelectedWin, s2));

		ObservableList<String> loseOptions = FXCollections.observableArrayList(ResourceManager.getString("destination"),
				ResourceManager.getString("player_death"));
		myLose = ComboBoxFactory.buildStylizedComboBox(loseOptions, ResourceManager.getString("combobox"), 200);
		myLose.valueProperty().addListener((o, s1, s2) -> updateSelectedCondition(mySelectedLose, s2));

		Label win = new Label(ResourceManager.getString("win_condition"));
		win.setAlignment(Pos.CENTER);
		Label lose = new Label(ResourceManager.getString("lose_condition"));
		lose.setAlignment(Pos.CENTER);

		myView.add(win, 0, 0, 1, 1);
		myView.add(lose, 0, 2, 1, 1);
		myView.add(myWins, 0, 1, 1, 1);
		myView.add(myLose, 0, 3, 1, 1);
		myView.add(myCashInput, 0, 4, 1, 1);

		myView.setPadding(new Insets(10, 10, 10, 10));
		myView.setVgap(10);
		myView.setAlignment(Pos.CENTER);
	}

	private void updateSelectedCondition(IGameCondition c, String conditionName) {
		String classPath = String.format("%s%s%s", ResourceManager.getString("conditions"),
				conditionName.replace(" ", ""), "Condition");
		try {
			c = (IGameCondition) Reflection.createInstance(classPath);
			if (c == null) {
				AlertBoxFactory.createObject("");
				return;
			}
			ParameterInputFactory.createInputFields(c);
		} catch (ReflectionException e) {
			AlertBoxFactory.createObject(e.getMessage());
		}
	}

	private void saveCash() {
		try {
			mySetCash = Integer.parseInt(myCashInput.getText());

		} catch (Exception e) {
			AlertBoxFactory.createObject(ResourceManager.getString("not_integer"));
		}
	}

	public IGameCondition getLosingCondition() {
		return mySelectedLose;
	}

	public IGameCondition getWinningCondition() {
		return mySelectedWin;
	}

	public void setLosingCondition(IGameCondition cond) {
		this.mySelectedLose = cond;
	}

	public void setWinningCondition(IGameCondition cond) {
		this.mySelectedWin = cond;
	}

	public Node getView() {
		return myView;
	}

	public LevelSettings getConditions() {
		saveCash();
		return new LevelSettings(mySelectedWin, mySelectedLose, mySetCash);
	}
}
