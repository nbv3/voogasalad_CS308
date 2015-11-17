package engine;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.input.KeyEvent;
import objects.IGameEventListener;
import objects.events.IEvent;
import engine.environment.GameEnvironment;
import engine.environment.IEnvironment;
import engine.score.IScoreManager;
import engine.score.ScoreManager;
import engine.winconditions.IWinConditionManager;
import engine.winconditions.WinConditionManager;
import view.ViewController;

public class GameEngine implements IGameEngine {
	
	private ViewController myViewController;

	private IEnvironment myGameEnvironment;
	private ICollisionManager myCollisionManager;
	private IScoreManager myScoreManager;
	private IWinConditionManager myWinManager;
	
	private List<IGameEventListener> myListeners;
	//This one is all the listeners we will remove after finishing listener iteration
	private List<IGameEventListener> myRemovedListeners;


	public GameEngine(int numCellsWide, int numCellsHigh, ViewController controller) {
		myListeners = new ArrayList<>();
		myRemovedListeners = new ArrayList<>();
		
		myViewController = controller;
		myGameEnvironment = new GameEnvironment(numCellsWide, numCellsHigh, this);
		myCollisionManager = new CollisionManager();
		myScoreManager = new ScoreManager(this);
		myWinManager = new WinConditionManager(this);
	}

	public void update() {
		updateListeners();
		myGameEnvironment.updateObjects();
		myCollisionManager.checkCollisions(myGameEnvironment.getEnvironmentObjects());
		myScoreManager.update();
		myWinManager.update();
	}
	
	public void postEvent(IEvent e) {

		for (IGameEventListener obj: myListeners) {
			obj.onEvent(e);
		}
		
		updateListeners();
		
	}
	
	private void updateListeners() {
		//Make sure we aren't trying to modify the list as we iterate over it
		for(IGameEventListener obj: myRemovedListeners) {
			myListeners.remove(obj);
		}
		myRemovedListeners = new ArrayList<>();
	}

	@Override
	public void handleKeyPressed(KeyEvent e) {
		myGameEnvironment.handleKeyPressed(e);

	}

	@Override
	public void handleKeyReleased(KeyEvent e) {
		myGameEnvironment.handleKeyReleased(e);

	}

	@Override
	public void handleMouseInput(double x, double y) {
		myGameEnvironment.handleMouseInput(x, y);

	}

	@Override
	public IEnvironment getEnvironment() {
		return myGameEnvironment;
	}
	
	public ViewController getViewController() {
		return myViewController;
	}
	
	public void addListener(IGameEventListener obj) {
		myListeners.add(obj);
	}
	
	public void removeListener(IGameEventListener obj) {
		myRemovedListeners.add(obj);
	}

}
