import com.syntacticsugar.vooga.authoring.objectediting.sizing.ObjectResizer;

import com.syntacticsugar.vooga.menu.SceneManager;

import javafx.application.Application;
import javafx.stage.Stage;
//import xml.data.ObjectData;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		//new AllTests();
		//new ObjectEditor();
		new SceneManager(stage);
		/*ObjectData data = new ObjectData();
		data.setImagePath("gray.png");
		String tileImaagePath = "scenery_grass_2.png";
		new ObjectResizer(data, tileImagePath);*/
	}
}
	
