import editor.AuthoringEnvironment;
import engine.GameEngine;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import simple.manager.SimpleGameManager;

public class Main extends Application {
	
	//These will eventually go in a properties file
	//TODO: DO THIS
	public static final String TITLE = "SYNTACTIC SUGAR";
	public static final double FRAME_LENGTH = 1.0/60.0;
	
	//THESE WILL BE READ IN FROM XML
	//TODO: DEFINITELY DO THIS
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	
	
	private GameManager myGameManager;

	@Override
	public void start(Stage arg0) throws Exception {
		
////		new AuthoringEnvironment();
//		
//		myGameManager = new GameManager();
//		
//		//FIX ALL THIS SHIT LATER
//		//TODO: REAL IMPLEMENTATION
//		
//		Scene scene = this.myGameManager.init(arg0, WIDTH,HEIGHT);
//		arg0.setTitle(TITLE);
//		arg0.setScene(scene);
//		arg0.show();
//		
//		KeyFrame frame = new KeyFrame(Duration.seconds(FRAME_LENGTH),
//                e -> this.myGameManager.update());
//		Timeline animation = new Timeline();
//		animation.setCycleCount(Timeline.INDEFINITE);
//		animation.getKeyFrames().add(frame);
//		this.myGameManager.setAnimation(animation);
//		animation.play();
		
		SimpleGameManager myGameManager = new SimpleGameManager();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
