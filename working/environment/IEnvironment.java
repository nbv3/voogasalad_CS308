package environment;

import java.util.List;

import objects.AbstractGameObject;
import objects.IGameObject;

public interface IEnvironment {
	
	public void addToEnvironment(IGameObject g);
	
	public void removeFromEnvironment(IGameObject g);	

	public void updateObjects();

	List<IGameObject> getEnvironmentObjects();

	public List<String> validate();

}
