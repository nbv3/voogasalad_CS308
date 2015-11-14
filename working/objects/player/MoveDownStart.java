package objects.player;

import objects.attributes.IPlayer;

public class MoveDownStart implements KeyInput {

	@Override
	public void run(IPlayer comp) {
		double speed = comp.getSpeed();

		comp.setY(speed);
	}

}
