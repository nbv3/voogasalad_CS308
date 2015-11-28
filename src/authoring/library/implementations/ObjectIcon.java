package authoring.library.implementations;

import authoring.objectediting.ObjectData;
import javafx.scene.control.Label;

public class ObjectIcon extends AbstractIcon {

	private Label myLabel;
	
	public ObjectIcon(ObjectData data, double dimension) {
		super(data.getImagePath(), dimension);
		myLabel = new Label(data.getObjectName());
		this.getChildren().add(myLabel);
	}

}