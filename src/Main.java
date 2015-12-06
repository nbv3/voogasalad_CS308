import com.syntacticsugar.vooga.authoring.objectediting.sizing.ObjectResizer;
import com.syntacticsugar.vooga.authoring.parameters.ParameterInputFactory;
import com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.weapon.AbstractWeaponAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.weapon.BasicWeaponAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.weapon.StunWeaponAttribute;
import com.syntacticsugar.vooga.menu.MainMenu;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
//import xml.data.ObjectData;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage astage) {
		//new AllTests();
		//new ObjectEditor();
//		new MainMenu();
		//new SceneManager(stage);
		/*ObjectData data = new ObjectData();
		data.setImagePath("scenery_gray.png");
		String tileImagePath = "scenery_grass_2.png";*/
		StunWeaponAttribute health = new StunWeaponAttribute();
		BorderPane root = new BorderPane();
		root.setCenter(ParameterInputFactory.createInputFields(health));
		
		Stage stage = new Stage();
		Scene scene = new Scene(root, 300, 200);
		stage.setScene(scene);
		stage.showAndWait();
		
		
	}
}
	
