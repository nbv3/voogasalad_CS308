package engine;

import java.util.List;

import objects.IGameObject;
import view.BoundingBox;

public class CollisionManager implements ICollisionManager {

	@Override
	public void checkCollisions(List<IGameObject> list) {
		for (IGameObject object : list) {

			for (IGameObject other : list) {
				if (other.equals(object)) {
					continue;
				}
				if (intersects(object, other)) {

					System.out.println("INTERSECTING");
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

		Boolean doesIntersect = false;

		Boolean aInsideBX = (ax + aw >= bx && ax <= bx + bw);
		Boolean aInsideBY = (ay + ah >= by && ay <= by + bh);
		Boolean bInsideAX = (bx + bw >= ax && bx <= ax + aw);
		Boolean bInsideAY = (by + bh >= ay && by <= ay + ah);
		if ((aInsideBX && aInsideBY) || (bInsideAX && bInsideAY)) {
			doesIntersect = true;
		}

		return doesIntersect;
	}

}
