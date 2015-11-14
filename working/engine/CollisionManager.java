package engine;

import java.util.List;

import environment.IEnvironment;
import objects.IGameObject;
import view.BoundingBox;

public class CollisionManager implements ICollisionManager {
	
	private IGameEngine myEngine;
	
	public CollisionManager (IGameEngine engine) {
		myEngine = engine;
	}

	@Override
	public void update() {
		List<IGameObject> objs = getEnvironment().getEnvironmentObjects();
		for (IGameObject obj: objs) {
			checkCollision(obj, objs);
		}
		
	}
	
	private void checkCollision(IGameObject obj, List<IGameObject> objs) {
		for (IGameObject other: objs) {
			if (other.equals(obj)) {
				continue;
			}
			if (intersects(obj, other)) {
				System.out.println("INTERSECTING");
			}
		}
	}
	
	private Boolean intersects(IGameObject obj, IGameObject other) {
		BoundingBox abox = obj.getBoundingBox();
		BoundingBox bbox = other.getBoundingBox();
		double ax = abox.getPoint().getX();
		double bx = bbox.getPoint().getX();
		double ay = abox.getPoint().getY();
		double by = bbox.getPoint().getY();
		
		Boolean doesIntersect = false;
		
		Boolean aInsideBX = (ax + abox.getWidth() >= bx && ax <= bx + bbox.getWidth());
		Boolean aInsideBY = (ay + abox.getHeight() >= by && ay <= by + bbox.getHeight());
		Boolean bInsideAX = (bx + bbox.getWidth() >= ax && bx <= ax + abox.getWidth());
		Boolean bInsideAY = (by + bbox.getHeight() >= ay && by <= ay + abox.getHeight());
		if ((aInsideBX && aInsideBY) || (bInsideAX && bInsideAY)) {
			doesIntersect = true;
		}
		
		return doesIntersect;
	}
	
	private IEnvironment getEnvironment() {
		return myEngine.getEnvironment();
	}

}
