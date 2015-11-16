package engine;

import java.util.ArrayList;
import java.util.List;

import environment.GameEnvironment;
import environment.GameMap;
import environment.IEnvironment;
import environment.IGameMap;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyEvent;
import objects.GameEventListener;
import objects.IGameObject;
import objects.events.IEvent;
import tiles.DecoratorTile;
import view.ViewController;

public class GameEngine implements IGameEngine {
	
	private ViewController myViewController;

	private IEnvironment myGameEnvironment;

	private ICollisionManager myCollisionManager;
	
	private List<GameEventListener> myListeners;
	//This one is all the listeners we will remove after finishing listener iteration
	private List<GameEventListener> myRemovedListeners;


	public GameEngine(int numCellsWide, int numCellsHigh, ViewController controller) {
		myListeners = new ArrayList<>();
		myRemovedListeners = new ArrayList<>();
		
		myViewController = controller;
		myGameEnvironment = new GameEnvironment(numCellsWide, numCellsHigh, this);
		myCollisionManager = new CollisionManager(this);
	}

	public void update() {
		updateListeners();
		myGameEnvironment.updateObjects();
		myCollisionManager.update();
	}
	
	public void postEvent(IEvent e) {

		for (GameEventListener obj: myListeners) {
			obj.onEvent(e);
		}
		
		updateListeners();
		
	}
	
	private void updateListeners() {
		//Make sure we aren't trying to modify the list as we iterate over it
		for(GameEventListener obj: myRemovedListeners) {
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
	
	public void addListener(GameEventListener obj) {
		myListeners.add(obj);
	}
	
	public void removeListener(GameEventListener obj) {
		myRemovedListeners.add(obj);
	}

}
