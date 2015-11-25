package com.syntacticsugar.vooga.authoring.editor;

import com.syntacticsugar.vooga.util.gui.factory.ButtonFactory;

import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

public abstract class EditorToolbar extends ToolBar{
	
	private String myTitle;
	
	public EditorToolbar(){ 
	}
	
	public EditorToolbar(String title){
		this.setOrientation(Orientation.VERTICAL);
		myTitle = title;
	}
	
	public String getToolName(){
		return myTitle;
	}
	
	protected Button createToolbarItem(String actionName) {
		Button action = new ButtonFactory().createObject(actionName,100,30);
		this.getItems().add(action);
		return action;
	}

}
