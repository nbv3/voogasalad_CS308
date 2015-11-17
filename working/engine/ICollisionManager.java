package engine;

import java.util.List;

import objects.IGameObject;

public interface ICollisionManager {
	
	public void checkCollisions(List<IGameObject> list);

}
