package environment;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import objects.GameEventListener;
import objects.IGameObject;
import objects.events.EEventType;
import objects.events.IEvent;
import objects.events.PlayerControlEvent;
import objects.player.Player;

public class GameEnvironment implements IEnvironment, EventPoster {

	private List<IGameObject> environmentObjects;
	private List<IGameObject> haveMoved;
	
	private List<GameEventListener> myListeners;

	public GameEnvironment() {
		environmentObjects = new ArrayList<IGameObject>();
		myListeners = new ArrayList<>();
		haveMoved = new ArrayList<>();
		
		
		//TEMP CODE
		//TODO: REMOVE THIS
		IGameObject obj = new Player(new Point(10,10), this);
		addToEnvironment(obj);
	}

	@Override
	public void addToEnvironment(IGameObject g) {
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
