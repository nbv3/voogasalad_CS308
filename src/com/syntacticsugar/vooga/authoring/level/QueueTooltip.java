package com.syntacticsugar.vooga.authoring.level;

import java.util.ArrayList;

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
import javafx.scene.layout.GridPane;

public class QueueTooltip extends CustomTooltip{
	private ObjectData myData;
	private Label myHealth;
	private Label myDestinationMarker;
	private ImageView currentImageView;
	
	public QueueTooltip(ObjectData data) {
		super();
		myData = data;
	}

	@Override
	protected Node buildContentNode() {
		GridPane infoGrid = new GridPane();
		myHealth = new Label();
//		myType.setFont(new Font(8));
		myDestinationMarker = new Label();
//		myDestinationMarker.setFont(new Font(8));
		currentImageView = new ImageView();
		currentImageView.setFitWidth(40);
		currentImageView.setFitHeight(40);
		infoGrid.setHgap(8);
		infoGrid.setAlignment(Pos.CENTER);
		infoGrid.add(myHealth, 0, 0, 1, 1);
		infoGrid.add(myDestinationMarker, 0, 1, 1, 1);
		infoGrid.add(currentImageView, 1, 0, 1, 2);
		return infoGrid;
	}	
	
	@Override
	protected void updateContent() {
		double db = ((HealthAttribute) ((ArrayList<IAttribute>) myData.getAttributes()).get(0)).getHealth();
		myHealth.setText(String.format("Health: %d", (int) db));
	}
}
