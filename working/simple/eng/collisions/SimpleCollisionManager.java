package simple.eng.collisions;

import java.util.Collection;

import objects.IGameObject;
import objects.events.IEvent;
import simple.obj.ISimpleObject;
import view.BoundingBox;

public class SimpleCollisionManager{

	public static void checkCollisions(Collection<ISimpleObject> objectsToCheck) {
		for (ISimpleObject a : objectsToCheck) {
			for (ISimpleObject b : objectsToCheck) {
				if (b.equals(a)) {
					continue;
				}
//				if (intersects(a, b)) {
//					for (ISimpleEvent e: a.getEventsFromCollision(b.getType())) {
//						b.sendEventToChildren(e);
//					}
//					for (ISimpleEvent e: b.getEventsFromCollision(a.getType())) {
//						a.sendEventToChildren(e);
//					}
//				}
			}
		}
	}
	
//	private static Boolean intersects(ISimpleObject obj, ISimpleObject other) {
//		BoundingBox abox = obj.getBoundingBox();
//		BoundingBox bbox = other.getBoundingBox();
//
//		double ax = abox.getPoint().getX();
//		double bx = bbox.getPoint().getX();
//		double ay = abox.getPoint().getY();
//		double by = bbox.getPoint().getY();
//
//		double aw = abox.getWidth();
//		double bw = bbox.getWidth();
//		double ah = abox.getHeight();
//		double bh = bbox.getHeight();
//
//		Boolean aInsideBX = (ax + aw >= bx && ax <= bx + bw);
//		Boolean aInsideBY = (ay + ah >= by && ay <= by + bh);
//		Boolean bInsideAX = (bx + bw >= ax && bx <= ax + aw);
//		Boolean bInsideAY = (by + bh >= ay && by <= ay + ah);
//		return ((aInsideBX && aInsideBY) || (bInsideAX && bInsideAY));
//	}

}
