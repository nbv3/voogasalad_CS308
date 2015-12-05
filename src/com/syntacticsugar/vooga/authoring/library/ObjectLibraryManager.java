package com.syntacticsugar.vooga.authoring.library;

import java.util.ArrayList;

import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;

public class ObjectLibraryManager {

	private TabPane myLibraryTabs;
	private ArrayList<ObjectLibrary> myLibraries;

	public ObjectLibraryManager() {
		myLibraryTabs = new TabPane();
		myLibraryTabs.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		myLibraries = new ArrayList<>();
		populateLibraryTabs();
	}

	private GameObjectType[] getObjectTypes() {
		return GameObjectType.values();
	}

	private void populateLibraryTabs() {
		for (GameObjectType type : getObjectTypes()) {
			ObjectLibrary lib = new ObjectLibrary(type);
			Tab tab = new Tab(type.toString());
			tab.setContent(lib.getContent().getView());
			myLibraryTabs.getTabs().add(tab);
			myLibraries.add(lib);
		}
	}

	public TabPane getTabPane() {
		return myLibraryTabs;
	}

	public void refresh() {
		for (ObjectLibrary lib : myLibraries) {
			lib.refresh();
		}
	}
	
	public ArrayList<ObjectLibrary> getLibraries() {
		return myLibraries;
	}
}
