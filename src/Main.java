import com.syntacticsugar.vooga.authoring.editor.AuthoringEnvironment;
import com.syntacticsugar.vooga.gameplayer.view.implementation.StartingScreenManager;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		new StartingScreenManager(stage);
	}
	
}
