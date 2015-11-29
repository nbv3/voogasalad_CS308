import com.syntacticsugar.vooga.authoring.objecteditor.ObjectEditor;
import com.syntacticsugar.vooga.menu.SceneManager;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		new ObjectEditor();
		new SceneManager(stage);
	}
}
	
