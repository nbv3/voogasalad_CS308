package player;

import com.syntacticsugar.vooga.gameplayer.engine.GameEngine;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.event.IGameEventListener;
import com.syntacticsugar.vooga.gameplayer.game.Game;
import com.syntacticsugar.vooga.gameplayer.manager.EventManager;
import com.syntacticsugar.vooga.gameplayer.manager.IEventManager;
import com.syntacticsugar.vooga.gameplayer.universe.GameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.menu.IVoogaApp;
import com.syntacticsugar.vooga.xml.data.UniverseData;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class GamePlayManager implements IVoogaApp, IGameEventListener {

	private static final double FRAME_RATE = 1/60.0;
	
	private Stage myStage;
	private Game myGame;
	
	private GamePlayEngine myGameEngine;
	private GameViewController myViewController;
	private IEventManager myEventManager;
	private IGameUniverse myCurrentLevel;
	private Timeline myTimeline;
	
	public GamePlayManager(Game game) {
		myStage = new Stage();
		myTimeline = new Timeline();
		myGame = game;
		myViewController = new GameViewController();
		myGameEngine = new GamePlayEngine();
		myGameEngine.registerViewAdder(myViewController);
		myGameEngine.registerViewRemover(myViewController);
		myEventManager = new EventManager();
		myEventManager.registerListener(this);
		initializeTimeline();
		initNextLevel();
	}
	
	private void initializeTimeline(){
		KeyFrame frame = new KeyFrame(Duration.seconds(FRAME_RATE), e -> myGameEngine.update(myCurrentLevel));
		myTimeline.setCycleCount(Timeline.INDEFINITE);
		myTimeline.getKeyFrames().add(frame);
	}
	
	private void initNextLevel() {
		myCurrentLevel = myGame.nextLevel();
		myViewController.displayLevel(myCurrentLevel);
	}
	
	private void restartLevel() {

	}
	
	@Override
	public void assignCloseHandler(EventHandler<WindowEvent> onclose) {
		myStage.setOnCloseRequest(onclose);
	}

	@Override
	public void onEvent(IGameEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
