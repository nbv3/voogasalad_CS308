package authoring.icons.implementations;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import xml.data.ObjectData;

public class ObjectIcon extends AbstractIcon {

	private final GridPane myLayout;
	private final Label myLabel;
	
	public ObjectIcon(ObjectData data, double dimension) {
		super(data.getImagePath(), dimension);
		myLayout = new GridPane();
		myLabel = new Label(data.getObjectName());
	}
	
	public ObjectIcon(ObjectData data) {
		super(data.getImagePath(), 0);
		myLayout = new GridPane();
		myLabel = new Label(data.getObjectName());
		this.getChildren().add(myLabel);
	}

}