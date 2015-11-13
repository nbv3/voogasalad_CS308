package objects.player;

import java.util.Vector;

import objects.attributes.IPlayer;

public class MoveDownStart implements KeyInput {

	@Override
	public void run(IPlayer comp) {
		double speed = comp.getSpeed();
		Vector<Double> vel = new Vector<>();
		vel.add(0.0);
		vel.add(-1 * speed);
		comp.setVelocity(vel);
	}

}
