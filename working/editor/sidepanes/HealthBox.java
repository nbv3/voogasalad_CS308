package editor.sidepanes;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HealthBox {
	private HBox myMin;
	private HBox myMax;
	private VBox myHealth;

	public HealthBox() {
		myHealth = new VBox();
		Label minLabel = new Label("Minimum Health");
		Label maxLabel = new Label("Maximum Health");
		TextField minHealth = new TextField();
		minHealth.setMaxWidth(100);
		TextField maxHealth = new TextField();
		maxHealth.setMaxWidth(100);
		myMin = new HBox();
		myMax = new HBox();
		myMin.getChildren().addAll(minLabel,minHealth);
		myMax.getChildren().addAll(maxLabel,maxHealth);
		myHealth.getChildren().addAll(myMin, myMax);
	}
	
	public VBox getNode() {
		return myHealth;
	}
}
