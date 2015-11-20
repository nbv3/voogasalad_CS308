package com.syntacticsugar.vooga.engine;

import java.util.Collection;

import com.syntacticsugar.vooga.event.IGameEvent;
import com.syntacticsugar.vooga.objects.BoundingBox;
import com.syntacticsugar.vooga.objects.IBoundingBox;
import com.syntacticsugar.vooga.objects.IGameObject;

public class CollisionEngine {

	public static void checkCollisions(Collection<IGameObject> collection) {
		for (IGameObject a : collection) {
			for (IGameObject b : collection) {
				if (b.equals(a)) {
					continue;
				}
				if (intersects(a, b)) {
					if (a.getEventsFromCollision(b.getType()) != null) {
						for (IGameEvent e : a.getEventsFromCollision(b.getType())) {
							e.executeEvent(b.getAttributes());
						}
					}
				}
			}
		}
	}

	private static Boolean intersects(IGameObject obj, IGameObject other) {
		IBoundingBox abox = obj.getBoundingBox();
		IBoundingBox bbox = other.getBoundingBox();

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
