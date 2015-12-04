package com.syntacticsugar.vooga.authoring.level;

import com.syntacticsugar.vooga.gameplayer.conditions.LosingConditionOption;
import com.syntacticsugar.vooga.gameplayer.conditions.WinningConditionOption;
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
	private ComboBox<WinningConditionOption> myWin;
	private ComboBox<LosingConditionOption> myLose;
	private WinningConditionOption mySelectedWin;
	private LosingConditionOption mySelectedLose;
	private double mySelectedWinValue;
	private double mySelectedLoseValue;

	public LevelConditionManager() {
		mySelectedWin = null;
		mySelectedLose = null;
		myView = new GridPane();
		ObservableList<WinningConditionOption> winOptions = FXCollections
				.observableArrayList(WinningConditionOption.values());

		myWin = new ComboBox<WinningConditionOption>(winOptions);

		ObservableList<LosingConditionOption> loseOptions = FXCollections
				.observableArrayList(LosingConditionOption.values());

		myWin.setPrefWidth(200);
		myLose = new ComboBox<LosingConditionOption>(loseOptions);
		myLose.setPrefWidth(200);

		myWin.valueProperty().addListener((o, s1, s2) -> updateSelectedWin(s2));
		myLose.valueProperty().addListener((o, s1, s2) -> updateSelectedLose(s2));

		Label win = new Label("My Winning Condition");
		win.setAlignment(Pos.CENTER);
		Label lose = new Label("My Losing Condition");
		lose.setAlignment(Pos.CENTER);

		myView.add(win, 0, 0, 1, 1);
		myView.add(lose, 0, 2, 1, 1);
		myView.add(myWin, 0, 1, 1, 1);
		myView.add(myLose, 0, 3, 1, 1);
		myView.setPadding(new Insets(10, 10, 10, 10));
		myView.setVgap(10);
		// ColumnConstraints column1 = new ColumnConstraints();
		//
		// column1.setPercentWidth(75);
		// myView.getColumnConstraints().addAll(column1);
		myView.setAlignment(Pos.CENTER);
	}

	private void updateSelectedWin(WinningConditionOption w) {
		mySelectedWin = w;
		MsgInputBoxFactory msgBox = new MsgInputBoxFactory("Select Winning Requirement:");
		mySelectedWinValue = msgBox.getValue();
		System.out.println(mySelectedWin);
	}

	private void updateSelectedLose(LosingConditionOption l) {
		mySelectedLose = l;
		MsgInputBoxFactory msgBox = new MsgInputBoxFactory("Select Losing Requirement:");
		mySelectedLoseValue = msgBox.getValue();
		System.out.println(mySelectedLose);

	}

	public LosingConditionOption getLosingCondition() {
		return mySelectedLose;
	}

	public WinningConditionOption getWinningCondition() {
		return mySelectedWin;
	}

	public Node getView() {
		return myView;
	}
}
