package com.syntacticsugar.vooga.menu.fluidmenu;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class BackgroundCreator {
	public static Pane addBackground(ImageView imageView, Node node){
		StackPane stackPane = new StackPane();
		stackPane.getChildren().addAll(imageView, node);
		return stackPane;
	}
}
