package objects.player;

import objects.attributes.IPlayer;

public class MoveUpStart implements KeyInput {

	@Override
	public void run(IPlayer comp) {
		double speed = comp.getSpeed();
		comp.setVelocity(0, -1.0*speed);
	}

}
