package environment;

import java.util.List;

import objects.AbstractGameObject;

public interface IEnvironment {
	
	public void addToEnvironment(AbstractGameObject g);
	
	public void removeFromEnvironment(AbstractGameObject g);
	
	public List<AbstractGameObject> returnEnvironmentObjects();
	
	public void updateObjects();


}
