package com.syntacticsugar.vooga.gameplayer.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


/**
 * Creates a main menu pane. generateOptions() allows to add menu options.
 * 
 */
public abstract class AbstractGameMenu extends BorderPane implements IGameMenu{
	
	private SceneManager myManager;
	
	public AbstractGameMenu(SceneManager manager, double width, double height, String title){
		this.getStylesheets().add("/com/syntacticsugar/vooga/gameplayer/css/menu.css");
		myManager = manager;
		setWidth(width); 
		setHeight(height);
		generateTitle(title);
	}
	
	private void generateTitle(String title){
		Label myTitle = new Label(title);
		//myTitle.setFont(new Font(40));
		BorderPane.setAlignment(myTitle, Pos.CENTER);
		setTop(myTitle);
	}
	
	protected void generateOptions(Node... options){
		VBox optionsList = new VBox(20);
		HBox mybox = new HBox();
		optionsList.getChildren().add(mybox);
		for(Node node: options){
			optionsList.getChildren().add(node);
		}
		BorderPane.setAlignment(optionsList, Pos.CENTER);
		optionsList.setMaxWidth(300.0);
		this.setCenter(optionsList);
	}
	
	protected Button createButton(String name, EventHandler<ActionEvent> onAction) {
		Button button = new Button(name);
		//button.setFont(new Font(30));
		button.setMaxWidth(Double.MAX_VALUE);
		button.setOnAction(onAction);
		return button;
	}
	
	protected void launchGame(){
		myManager.initFirstScene();
	}
	
	protected void launchEditor(){
		myManager.launchEditor();
	}
	

}
