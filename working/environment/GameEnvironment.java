package environment;

import java.util.ArrayList;
import java.util.List;

import objects.AbstractGameObject;

public class GameEnvironment implements IEnvironment {

	private List<AbstractGameObject> environmentObjects;

	public GameEnvironment() {
		environmentObjects = new ArrayList<AbstractGameObject>();
	}

	@Override
	public void addToEnvironment(AbstractGameObject g) {
		environmentObjects.add(g);
	}

	@Override
	public List<AbstractGameObject> returnEnvironmentObjects() {
		return environmentObjects;
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

}
