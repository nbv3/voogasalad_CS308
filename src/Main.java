import com.syntacticsugar.vooga.gameplayer.view.implementation.StartingScreenManager;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		//new ObjectEditor();
//		new StartingScreenManager(stage);
//		LevelTab level1Tab = null;
//		TabPane pane = new TabPane();
//		
//		try {
//			level1Tab = new LevelTab();
//			pane.getTabs().add(level1Tab.getTab());
//			Scene scene = new Scene(pane, 650, 650);
//			stage.setScene(scene);
//			stage.show();
//		} catch (Exception e) {
//			AlertBoxFactory.createObject(e.getMessage());
//		}
//		new AuthoringScreenManager();
		new StartingScreenManager(stage);
	}
}
	
