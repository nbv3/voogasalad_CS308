package editor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import editor.sidepanes.HealthBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EnemyEditor {
	private VBox enemyPane;
	private GridPane iconPane;
	private ResourceBundle enemyIconBundle;
	private final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	private final int NUMBER_ROW_ICON_PANEL = 5;
	private final int NUMBER_COLUMN_ICON_PANEL = 3;
	private final double WIDTH_ICON_PANEL = 300.1;
	private final double HEIGHT_ICON_PANEL = 500.1;
	private Button okButton;

	public EnemyEditor() {
		enemyPane = new VBox();
		VBox h = new HealthBox().getNode();
//		HBox image = new ImageSelector().getNode();
		iconPane = new GridPane();
		iconPane.setPrefSize(WIDTH_ICON_PANEL, HEIGHT_ICON_PANEL);
		showImageOptions();
		okButton = new Button("OK");
		okButton.setPrefHeight(30);
		okButton.setPrefWidth(80);
		enemyPane.getChildren().add(iconPane);
		enemyPane.getChildren().add(h);
		enemyPane.getChildren().add(okButton);

		
	}

	public VBox getNode() {
		return enemyPane;
	}
	
	private void showImageOptions() {
		enemyIconBundle = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "EnemyIcon");
		String[] enemyIconPath = enemyIconBundle.getString("Enemy").split(",");	
		iconPane.getChildren().clear();
		for (int i = 0; i < enemyIconPath.length; i++) {
			ImageView img = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(enemyIconPath[i])));
			//img.setOnMouseClicked(e -> addToEnemyList(img));
			img.setFitWidth(iconPane.getPrefWidth() / NUMBER_COLUMN_ICON_PANEL);
			img.setFitHeight(iconPane.getPrefHeight() / NUMBER_ROW_ICON_PANEL);
			iconPane.add(img, i % NUMBER_COLUMN_ICON_PANEL, i / NUMBER_COLUMN_ICON_PANEL, 1, 1);
		}
		return;
	}
	
	

}
