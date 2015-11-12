package environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import objects.AbstractGameObject;

public class GameEnvironment implements Observer, IEnvironment {

	private List<AbstractGameObject> environmentObjects;
	private List<AbstractGameObject> haveMoved;

	public GameEnvironment() {
		environmentObjects = new ArrayList<AbstractGameObject>();
	}

	@Override
	public void addToEnvironment(AbstractGameObject g) {
		environmentObjects.add(g);
	}


	@Override
	public void removeFromEnvironment(AbstractGameObject g) {
		environmentObjects.remove(g);

	}

	@Override
	public void updateObjects() {
		for(AbstractGameObject g: environmentObjects){
			g.update();
		}
		
	}


	@Override
	public List<AbstractGameObject> getEnvironmentObjects() {
		return environmentObjects;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
