package com.syntacticsugar.vooga.authoring.level;

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
	private ComboBox myWin;
	private ComboBox myLose;

	public LevelConditionManager() {
		myView = new GridPane();
		ObservableList<String> winOptions = FXCollections.observableArrayList("Option 1", "Option 2", "Option 3");
		myWin = new ComboBox(winOptions);
		ObservableList<String> loseOptions = FXCollections.observableArrayList("Option 1", "Option 2", "Option 3");
		myWin.setPrefWidth(200);
		myLose = new ComboBox(loseOptions);
		myLose.setPrefWidth(200);

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
//		ColumnConstraints column1 = new ColumnConstraints();
//
//		column1.setPercentWidth(75);
//		myView.getColumnConstraints().addAll(column1);
		myView.setAlignment(Pos.CENTER);
	}

	public Node getView() {
		return myView;
	}
}
