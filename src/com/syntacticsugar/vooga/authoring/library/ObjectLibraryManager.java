package com.syntacticsugar.vooga.authoring.library;

import java.util.ArrayList;
import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;

import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;

public class ObjectLibraryManager {

	private TabPane myLibraryTabs;
	private Collection<ObjectLibrary> myLibraries;

	public ObjectLibraryManager() {		
		myLibraryTabs = new TabPane();
		myLibraryTabs.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		myLibraries = new ArrayList<>();
		populateLibraryTabs();
	}

	private GameObjectType[] getObjectTypes(){
		return GameObjectType.values();
	}
	
	private void populateLibraryTabs() {
		for (GameObjectType type: getObjectTypes()){
			ObjectLibrary lib = new ObjectLibrary(type);
			myLibraryTabs.getTabs().add(lib);
			myLibraries.add(lib);
		}
	}
	
	public TabPane getTabPane() {
		return myLibraryTabs;
	}
	
	public void refresh(){
		for (ObjectLibrary lib : myLibraries) {
			lib.refresh();
		}
	}
}
