package gui.factory;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertBoxFactory {

	public AlertBoxFactory() {
		
	}

	public Alert createObject(String id) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText(id);
		alert.showAndWait();
		return alert;
	}
	
}
