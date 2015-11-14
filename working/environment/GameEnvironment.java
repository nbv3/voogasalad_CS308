package environment;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import tiles.DecoratorTile;
import view.ViewController;
import javafx.scene.input.KeyEvent;
import objects.GameEventListener;
import objects.IGameObject;
import objects.events.EEventType;
import objects.events.IEvent;
import objects.events.ObjectSpawnEvent;
import objects.events.PlayerControlEvent;
import objects.player.Player;

public class GameEnvironment implements IEnvironment, EventPoster {

	private ViewController myViewController;
	private int currentViewID;
	private IGameMap myGameMap;
	private List<IGameObject> environmentObjects;
	private List<GameEventListener> myListeners;

	public GameEnvironment() {
		this(20, 20);
	}
	
	
	public GameEnvironment(int numCellsWide, int numCellsHigh) {
		currentViewID = 0;
		myViewController = new ViewController();
		buildGameMap(numCellsWide, numCellsHigh);
		environmentObjects = new ArrayList<IGameObject>();
		myListeners = new ArrayList<>();
		
		//TEMP CODE
		//TODO: REMOVE THIS
		IGameObject obj = new Player(new Point2D(10,10), this);
		addToEnvironment(obj, null);
	}
	
	private void buildGameMap(int w, int h) {
		myGameMap = new GameMap(w, h);
		double tileWidth = 1000.0/((double) w);
		double tileHeight = 1000.0/((double) h);

		for (int i=0; i<w; i++) {
			for (int j=0;j<h; j++) {
				Point2D p = new Point2D((tileWidth*i + tileWidth/2.0), (tileHeight*j + tileHeight/2.0));
				DecoratorTile dt = new DecoratorTile(currentViewID++, p, tileWidth, tileHeight);
				myGameMap.setTile(p, dt);
				}
		}
	}
	
	@Override
	public void addToEnvironment(IGameObject g, String path) {
		environmentObjects.add(g);
		addListener(g);
	}


	@Override
	public void removeFromEnvironment(IGameObject g) {
		environmentObjects.remove(g);
		removeListener(g);

	}

	@Override
	public void updateObjects() {
		for(IGameObject g: environmentObjects){
			g.update();
		}
		
	}


	@Override
	public List<IGameObject> getEnvironmentObjects() {
		return environmentObjects;
	}
	
	public void postEvent(IEvent e) {
		
		//Figure out if the environment cares about the event
		Boolean processed = processEvent(e);
		if (processed) {
			return;
		}
		
		for (GameEventListener obj: myListeners) {
			obj.onEvent(e);
		}
		
	}
	
	public Boolean processEvent(IEvent e) {
		//Returns true if the environment does something with this event
		Boolean isProcessed = false;
		if (e.getType().equals(EEventType.ObjectDespawnEvent)){
			isProcessed = true;
			removeFromEnvironment(e.getSource());
		}
		
		if (e.getType().equals(EEventType.ObjectSpawnEvent)) {
			ObjectSpawnEvent event = (ObjectSpawnEvent) e;
			addToEnvironment(event.getSource(), event.getPath());
		}
		
		return isProcessed;
	}
	
	public void addListener(GameEventListener obj) {
		myListeners.add(obj);
	}
	
	public void removeListener(GameEventListener obj) {
		myListeners.remove(obj);
	}

	@Override
	public List<String> validate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void handleKeyPressed(KeyEvent e) {
		PlayerControlEvent event = new PlayerControlEvent(e, e.getCode());
		postEvent(event);
	}

	@Override
	public void handleKeyReleased(KeyEvent e) {
		PlayerControlEvent event = new PlayerControlEvent(e, e.getCode());
		postEvent(event);
	}

	@Override
	public void handleMouseInput(double x, double y) {
		// TODO Auto-generated method stub
		
	}

}
