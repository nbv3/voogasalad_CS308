import com.syntacticsugar.vooga.authoring.objectediting.sizing.ObjectResizer;
import com.syntacticsugar.vooga.gameplayer.view.DirectionArrows;
import com.syntacticsugar.vooga.menu.MainMenu;
import com.syntacticsugar.vooga.xml.data.ObjectData;

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
		new MainMenu();
		//new SceneManager(stage);
		ObjectData data = new ObjectData();
		data.setImagePath("scenery_gray.png");
		String tileImagePath = "scenery_grass_2.png";
		new ObjectResizer(data, tileImagePath);
	}
}
	
