import editor.AuthoringEnvironment;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		new AuthoringEnvironment();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
