package editor.sidepanes;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class SpawnerPropertyBox {
	private HBox spawnerHpBox;
    private HBox spawnerDmgBox;
	private HBox spawnNumBox;
	private VBox window;
	private TextField maxHpTF;
	private TextField dmgAmtTF;
	private TextField spawnNumTF;

	public SpawnerPropertyBox() {
		window = new VBox();
		window.setSpacing(5);
		spawnerHpBox = new HBox();
		spawnerHpBox.setSpacing(10);
		spawnerDmgBox = new HBox();
		spawnerDmgBox.setSpacing(10);
		spawnNumBox = new HBox();
		spawnNumBox.setSpacing(10);
		Label maxHpLabel = new Label("Maximum Health");
		maxHpLabel.setPrefWidth(150);
		Label dmgPowerLabel = new Label("Damage Power");
		dmgPowerLabel.setPrefWidth(150);
		Label spawnNumLabel = new Label("Spawn Number");
		spawnNumLabel.setPrefWidth(150);
		maxHpTF = new TextField();
		maxHpTF.setMaxWidth(100);
		dmgAmtTF = new TextField();
		dmgAmtTF.setMaxWidth(100);
		spawnNumTF = new TextField();
		spawnNumTF.setMaxWidth(100);
		Text spawnerTitle = new Text("Spawner properties");
		spawnerTitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		spawnerHpBox.getChildren().addAll(maxHpLabel,maxHpTF);
		spawnerDmgBox.getChildren().addAll(dmgPowerLabel,dmgAmtTF);
		spawnNumBox.getChildren().addAll(spawnNumLabel,spawnNumTF);
		window.getChildren().addAll(spawnerTitle,spawnerHpBox,spawnerDmgBox,spawnNumBox);
	}
	
	public int getMaxHP() throws NumberFormatException {
		if (maxHpTF.getText().isEmpty() || !isNumber(maxHpTF.getText())) {
			throw new NumberFormatException();
		}
		return 	Integer.parseInt(maxHpTF.getText());
	}
	
	public int getDamage() throws NumberFormatException {
		if (dmgAmtTF.getText().isEmpty() || !isNumber(dmgAmtTF.getText())) {
			throw new NumberFormatException();
		}
		return 	Integer.parseInt(dmgAmtTF.getText());
	}
	
	public int getSpawnNum() {
		return Integer.parseInt(spawnNumTF.getText());
	}

	public boolean isNumber(String string) {
	    try {
	        Integer.parseInt(string);
	    } catch (Exception e) {
	        return false;
	    }
	    return true;
	}
	
	public void clearInput() {
		maxHpTF.setText("");
		dmgAmtTF.setText("");
		spawnNumTF.setText("");
	}
	
	public VBox getNode() {
		return window;
	}
}
