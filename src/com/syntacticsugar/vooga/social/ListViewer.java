package com.syntacticsugar.vooga.social;

import java.util.ArrayList;
import java.util.Collection;

import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public abstract class ListViewer {

	protected VBox myView;
	protected ListView<HBox> myListView;
	protected Insets myPadding = new Insets(10, 10, 10, 10);
	
	public ListViewer(){
		myView = new VBox();
	}

	protected Node makeContentBox() {
		myListView = new ListView<HBox>();
		return myListView;
	}

	protected void addElementToList(Node item) {
		myListView.getItems().add((HBox) item);
	}
	
	public VBox getView() {
		return myView;
	}
	
	

	
}
