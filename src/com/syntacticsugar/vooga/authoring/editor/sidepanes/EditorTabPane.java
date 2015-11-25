package com.syntacticsugar.vooga.authoring.editor.sidepanes;

import java.util.HashMap;
import java.util.Map;

import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.util.Duration;

public class EditorTabPane extends TabPane {
	
	public EditorTabPane(EditorTab... tabs) {
        Map<Tab, Node> tabContent = new HashMap<>();

		for(EditorTab e:tabs) {
			Tab newTab = new Tab();
			newTab.setClosable(false);
			newTab.setText(e.getTabDescription());
			newTab.setContent(e.getContent());
			tabContent.put(newTab, e.getContent());
			this.getTabs().add(newTab);
		}
		
		this.getSelectionModel().selectedItemProperty().addListener(
				(obs, oldTab, newTab) -> {
					oldTab.setContent(null);
					Node oldContent = tabContent.get(oldTab);
					Node newContent = tabContent.get(newTab);

					newTab.setContent(oldContent);
					ScaleTransition fadeOut = new ScaleTransition(
							Duration.seconds(0.25), oldContent);
					fadeOut.setFromX(1);
					fadeOut.setFromY(1);
					fadeOut.setToX(0);
					fadeOut.setToY(0);

					ScaleTransition fadeIn = new ScaleTransition(
							Duration.seconds(0.25), newContent);
					fadeIn.setFromX(0);
					fadeIn.setFromY(0);
					fadeIn.setToX(1);
					fadeIn.setToY(1);

					fadeOut.setOnFinished(event -> {
						newTab.setContent(newContent);
					});

					SequentialTransition crossFade = new SequentialTransition(
							fadeOut, fadeIn);
					crossFade.play();
				});
	}

}
