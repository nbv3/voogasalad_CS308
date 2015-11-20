package com.syntacticsugar.vooga.authoring.editor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class WeaponBox {

	private VBox weaponBox;

	public WeaponBox() {
		ObservableList<String> options = FXCollections.observableArrayList("Weapon 1", "Weapon 2", "Weapon 3");
		ComboBox<String> myWeapons = new ComboBox<String>(options);
		weaponBox = new VBox();
		HBox weaponChoice = new HBox();

		Label weaponLabel = new Label("Select Weapon");
		weaponLabel.setPrefWidth(150);

		weaponChoice.getChildren().addAll(weaponLabel, myWeapons);
		Text damageTitle = new Text("Weapon");
		damageTitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		weaponBox.getChildren().addAll(damageTitle, weaponChoice);

	}

	public VBox getNode() {
		return weaponBox;
	}

}
