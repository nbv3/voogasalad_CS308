package objects.events;

import java.util.EventListener;

public interface ICollisionListener extends EventListener {

	public void onCollision(CollisionEvent e);
}
