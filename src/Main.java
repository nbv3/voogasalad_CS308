import com.syntacticsugar.vooga.authoring.objectediting.sizing.ObjectResizer;
import com.syntacticsugar.vooga.authoring.objecteditor.ObjectEditor;
import com.syntacticsugar.vooga.menu.SceneManager;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		//new ObjectEditor();
		new SceneManager(stage);
//		ObjectData data = new ObjectData();
//		data.setImagePath("gray.png");
//		String tileImagePath = "scenery_grass_2.png";
//		new ObjectResizer(data, tileImagePath);
	}
}
	
