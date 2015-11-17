package engine;

import java.util.ArrayList;
import java.util.List;

import engine.environment.IEnvironment;
import objects.IGameObject;
import objects.events.IEvent;
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
				for (IEvent e: obj.onCollision(other)) {
					other.sendEventToChildren(e);
				}
				for (IEvent e: other.onCollision(obj)) {
					obj.sendEventToChildren(e);
				}
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
		
		double aw = abox.getWidth();
		double bw = bbox.getWidth();
		double ah = abox.getHeight();
		double bh = bbox.getHeight();
		
		Boolean aInsideBX = (ax + aw >= bx && ax <= bx + bw);
		Boolean aInsideBY = (ay + ah >= by && ay <= by + bh);
		Boolean bInsideAX = (bx + bw >= ax && bx <= ax + aw);
		Boolean bInsideAY = (by + bh >= ay && by <= ay + ah);
		return ((aInsideBX && aInsideBY) || (bInsideAX && bInsideAY));
	}
	
	private IEnvironment getEnvironment() {
		return myEngine.getEnvironment();
	}

}
