package com.syntacticsugar.vooga.authoring.level;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import com.syntacticsugar.vooga.util.gui.factory.MsgInputBoxFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class LevelConditionManager {

	private GridPane myView;
	private ComboBox<String> myWins;
	private ComboBox<String> myLose;
	private String mySelectedWin;
	private List<Double> myWinParameters;
	private String mySelectedLose;
	private List<Double> myLoseParameters;

	public LevelConditionManager() {
		myView = new GridPane();

		ObservableList<String> winOptions = FXCollections.observableArrayList("Enemy Death");
		myWins = new ComboBox<String>(winOptions);
		myWins.setPrefWidth(200);
		myWinParameters = new ArrayList<Double>();

		ObservableList<String> loseOptions = FXCollections.observableArrayList("Destination", "Player Death");
		myLose = new ComboBox<String>(loseOptions);
		myLose.setPrefWidth(200);
		myLoseParameters = new ArrayList<Double>();

		myWins.valueProperty().addListener((o, s1, s2) -> updateSelectedWin(s2));
		myLose.valueProperty().addListener((o, s1, s2) -> updateSelectedLose(s2));

		Label win = new Label("Winning Condition");
		win.setAlignment(Pos.CENTER);
		Label lose = new Label("Losing Condition");
		lose.setAlignment(Pos.CENTER);

		myView.add(win, 0, 0, 1, 1);
		myView.add(lose, 0, 2, 1, 1);
		myView.add(myWins, 0, 1, 1, 1);
		myView.add(myLose, 0, 3, 1, 1);

		myView.setPadding(new Insets(10, 10, 10, 10));
		myView.setVgap(10);
		myView.setAlignment(Pos.CENTER);
	}

	private void updateSelectedWin(String w) {
		mySelectedWin = w;
		String className = mySelectedWin.replace(" ", "");
		String classPath = String.format("%s%s%s", "com.syntacticsugar.vooga.gameplayer.conditions.implementation.",
				className, "Condition");
		// correct format
		// com.syntacticsugar.vooga.gameplayer.conditions.implementation.EnemyDeathCondition
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
		System.out.println(myWinParameters);
	}

	private void updateSelectedLose(String l) {
		mySelectedLose = l;
		String className = mySelectedLose.replace(" ", "");
		String classPath = String.format("%s%s%s", "com.syntacticsugar.vooga.gameplayer.conditions.implementation.",
				className, "Condition");
		// correct format
		// com.syntacticsugar.vooga.gameplayer.conditions.implementation.EnemyDeathCondition
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
		System.out.println(myLoseParameters);

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

	public Node getView() {
		return myView;
	}
}
