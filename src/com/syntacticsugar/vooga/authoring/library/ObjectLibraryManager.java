package com.syntacticsugar.vooga.authoring.library;

import java.io.File;
import java.util.List;

import com.sun.deploy.uitoolkit.impl.fx.ui.resources.ResourceManager;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.Region;

public class ObjectLibraryManager {

	private TabPane myLibraryTabs;

	public ObjectLibraryManager() {		
		myLibraryTabs = new TabPane();
		myLibraryTabs.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
//		populateLibraryTabs();
	}

	private GameObjectType[] getObjectTypes(){
		return GameObjectType.values();
	}
	
	private void populateLibraryTabs() {
		for (GameObjectType type: getObjectTypes()){
			myLibraryTabs.getTabs().add(makeTab(type));
		}
	}
	
	private ObjectLibrary makeLibrary(GameObjectType objectType){
//		return new ObjectLibrary(objectType);
		return null;
	}
	
	private Tab makeTab(GameObjectType objectType){
		Tab tab = new Tab(objectType.toString());
		tab.setContent(makeLibrary(objectType).getContent());
		return tab;
	}

	public TabPane getTabPane() {
		return myLibraryTabs;
	}
}
