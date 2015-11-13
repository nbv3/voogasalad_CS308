package environment;

import java.util.ArrayList;
import java.util.List;

import objects.GameEventListener;
import objects.IGameObject;
import objects.events.EEventType;
import objects.events.IEvent;

public class GameEnvironment implements IEnvironment, EventPoster {

	private List<IGameObject> environmentObjects;
	private List<IGameObject> haveMoved;
	
	private List<GameEventListener> myListeners;

	public GameEnvironment() {
		environmentObjects = new ArrayList<IGameObject>();
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
		processEvent(e);
		
		for (GameEventListener obj: myListeners) {
			obj.onEvent(e);
		}
		
	}
	
	private void processEvent(IEvent e) {
		if (e.getType().equals(EEventType.ObjectDespawnEvent)){
			removeFromEnvironment(e.getSource());
		}
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

}
