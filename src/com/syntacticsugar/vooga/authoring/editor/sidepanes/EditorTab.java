package com.syntacticsugar.vooga.authoring.editor.sidepanes;

import javafx.scene.Node;

public class EditorTab {
	
	private Node content;
	private String tabDescription;

	public Node getContent() {
		return content;
	}

	public String getTabDescription() {
		return tabDescription;
	}

	public void setContent(Node content) {
		this.content = content;
	}

	public void setTabDescription(String tabDescription) {
		this.tabDescription = tabDescription;
	}
	
}
