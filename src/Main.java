
import com.syntacticsugar.vooga.menu.MainMenu;

import javafx.application.Application;
import javafx.stage.Stage;
//import xml.data.ObjectData;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage astage) {
		// new AllTests();
		// new ObjectEditor();
		new MainMenu();
		// new SceneManager(stage);
		/*
		 * ObjectData data = new ObjectData();
		 * data.setImagePath("scenery_gray.png"); String tileImagePath =
		 * "scenery_grass_2.png";
		 */

		// AbstractAttribute health = new SlowWeaponAttribute();
		//
		// ParameterInputFactory.createInputFields(health);

	}
}
