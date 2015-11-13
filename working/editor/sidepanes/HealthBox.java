package editor.sidepanes;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class HealthBox {
	private HBox myMin;
	private HBox myMax;
	private VBox myHealth;

	public HealthBox() {
		myHealth = new VBox();
		myHealth.setSpacing(5);
		myMin = new HBox();
		myMin.setSpacing(10);
		// myMin.setMaxWidth(250);
		myMax = new HBox();
		// myMax.setMaxWidth(250);
		myMax.setSpacing(10);
		Label minLabel = new Label("Minimum Health");
		minLabel.setPrefWidth(150);
		Label maxLabel = new Label("Maximum Health");
		maxLabel.setPrefWidth(150);
		TextField minHealth = new TextField();
		minHealth.setMaxWidth(100);
		TextField maxHealth = new TextField();
		maxHealth.setMaxWidth(100);
		Text healthTitle = new Text("Health");
		healthTitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));

		myMin.getChildren().addAll(minLabel, minHealth);
		myMax.getChildren().addAll(maxLabel, maxHealth);
		myHealth.getChildren().addAll(healthTitle,myMin, myMax);
	}

	public VBox getNode() {
		return myHealth;
	}
}
