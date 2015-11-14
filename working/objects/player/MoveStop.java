package objects.player;

import objects.attributes.IPlayer;

public class MoveStop implements KeyInput {

	@Override
	public void run(IPlayer comp) {
		comp.setVelocity(0, 0);
	}

}
