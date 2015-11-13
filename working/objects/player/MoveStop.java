package objects.player;

import java.util.Vector;

import objects.components.IPlayer;

public class MoveStop implements KeyInput {

	@Override
	public void run(IPlayer comp) {
		Vector<Double> vel = new Vector<>();
		vel.add(0.0);
		vel.add(0.0);
		comp.setVelocity(vel);
	}

}
