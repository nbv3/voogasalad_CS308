package com.syntacticsugar.vooga.gameplayer.engine.modules;

import java.util.ArrayList;
import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.objects.IBoundingBox;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

public class CollisionEngine {

	public static void checkCollisions(IGameUniverse universe) {
		Collection<IGameObject> objectsToCheck = new ArrayList<IGameObject>();
		objectsToCheck.addAll(universe.getGameObjects());
		objectsToCheck.addAll(universe.getPlayers());
		for (IGameObject a : objectsToCheck) {
			for (IGameObject b : objectsToCheck) {
				if (b.equals(a)) {
					continue;
				}
				if (intersects(a, b)) {
					a.onCollision(b);
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
