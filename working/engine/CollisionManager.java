package engine;

import java.util.List;

import objects.IGameObject;
import objects.events.IEvent;
import view.BoundingBox;

public class CollisionManager implements ICollisionManager {

	public CollisionManager() {
		
	}
	
	@Override
	public void checkCollisions(List<IGameObject> list) {
		for (IGameObject a : list) {
			for (IGameObject b : list) {
				if (b.equals(a)) {
					continue;
				}
				if (intersects(a, b)) {
					for (IEvent e: a.getEventsFromCollision(b)) {
						b.sendEventToChildren(e);
					}
					for (IEvent e: b.getEventsFromCollision(a)) {
						a.sendEventToChildren(e);
					}
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

}
