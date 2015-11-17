package objects.player;

import objects.attributes.IPlayer;

public class MoveLeftStart implements KeyInput {

	@Override
	public void run(IPlayer comp) {
		double speed = comp.getSpeed();
		comp.setXVel(-1*speed);
	}

}
