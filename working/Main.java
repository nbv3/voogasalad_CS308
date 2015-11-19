import javafx.application.Application;
import javafx.stage.Stage;
import simple.view.implementation.SimpleStartingScreenManager;

public class Main extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		new SimpleStartingScreenManager(arg0);
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
