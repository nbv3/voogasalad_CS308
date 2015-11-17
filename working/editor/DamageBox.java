package editor;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class DamageBox {
	private VBox myDamage;
	private HBox damageValue;


	public DamageBox() {
		myDamage = new VBox();
		myDamage.setSpacing(5);
		
		damageValue = new HBox();

		Label damageLabel = new Label("Damange Inflicted");
		damageLabel.setPrefWidth(150);

		TextField value = new TextField();
		value.setMaxWidth(100);
		
		damageValue.getChildren().addAll(damageLabel,value);

		Text damageTitle = new Text("Damage");
		damageTitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));

		myDamage.getChildren().addAll(damageTitle, damageValue);
	}

	public VBox getNode() {
		return myDamage;
	}
}
