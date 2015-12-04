package com.syntacticsugar.vooga.authoring.level;

import java.util.ArrayList;
import java.util.List;

import com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.xml.data.ObjectData;
import com.syntacticsugar.vooga.xml.data.TileData;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class QueueTooltip extends CustomTooltip{
	private ObjectData myData;
	private List<Label> myLabels;
	private ImageView currentImageView;
	private VBox box;
	
	public QueueTooltip(ObjectData data) {
		super();
		myData = data;
	}

	@Override
	protected Node buildContentNode() {
		box = new VBox();
		currentImageView = new ImageView();
		currentImageView.setFitWidth(40);
		currentImageView.setFitHeight(40);
		box.setAlignment(Pos.CENTER);
		GridPane infoGrid = new GridPane();
		ColumnConstraints c1 = new ColumnConstraints();
		c1.setPercentWidth(60);
		infoGrid.getColumnConstraints().add(c1);
		infoGrid.add(box, 0, 0, 1, 1);
		infoGrid.add(currentImageView, 1, 0, 1, 1);
		return infoGrid;
	}	
	
	@Override
	protected void updateContent() {
		System.out.println("HERE");
		currentImageView.setImage(new Image(getClass().getClassLoader().getResourceAsStream(myData.getImagePath())));
		box.getChildren().clear();
		for (IAttribute att: myData.getAttributes()) {
			Label label = new Label();
			label.setAlignment(Pos.CENTER);
			label.setText(att.getClass().getSimpleName());
			box.getChildren().add(label);
		}
	}
}
