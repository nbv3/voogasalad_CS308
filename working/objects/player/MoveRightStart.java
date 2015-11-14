package objects.player;

import objects.attributes.IPlayer;

public class MoveRightStart implements KeyInput {

	@Override
	public void run(IPlayer comp) {
		double speed = comp.getSpeed();
		comp.setX(speed);
	}

}
