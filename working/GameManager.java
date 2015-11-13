import engine.GameEngine;
import environment.GameEnvironment;
import environment.IEnvironment;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameManager {
	
	private Group myRoot;
	
	private IEnvironment myEnvironment;
	private GameEngine myEngine; // Holds the different "sections" of the application. Currently there is just the library/text_input/drawing board section.
	private Scene myScene;
	private Stage myStage;
	private Timeline myAnimation;
	
	
	public Scene init(Stage stage, int width, int height){

		myRoot = new Group();	
		this.myScene = new Scene(myRoot,width,height,Color.WHITE);
		
		this.myStage = stage;
		this.myEnvironment = new GameEnvironment();
		this.myEngine = new GameEngine(myEnvironment);

		this.myScene.setOnKeyPressed(e -> handleKeyPressed(e));
		this.myScene.setOnKeyReleased(e -> handleKeyReleased(e));
		this.myScene.setOnMouseClicked(e -> handleMouseInput(e.getSceneX(), e.getSceneY()));
		return myScene;
	}
	
	public Stage getStage(){
		return this.myStage;
	}

	public void addToRoot(Node node) {
		myRoot.getChildren().add(node);
	}
	
	public void setAnimation(Timeline animation){
		this.myAnimation = animation;
	}
	
	private void handleKeyReleased(KeyEvent e){
		this.myEngine.handleKeyReleased(e);
	}
	
	private void handleKeyPressed(KeyEvent e){
		this.myEngine.handleKeyPressed(e);
	}
	
	private void handleMouseInput (double x, double y){
		this.myEngine.handleMouseInput(x, y);
	}
	
	public void update(){
		this.myEngine.update();
	}
	
	public void setStageWidth(double width){
		this.myStage.setWidth(width);
	}
	
	public void setStageHeight(double height){
		this.myStage.setHeight(height);
	}
	
	public void resetTime(double secondsDelay){
		KeyFrame frame = new KeyFrame(Duration.seconds(secondsDelay),
                e -> this.update());
		this.myAnimation.stop();
		this.myAnimation.getKeyFrames().clear();
		this.myAnimation.getKeyFrames().add(frame);
		this.myAnimation.play();
	}

}
