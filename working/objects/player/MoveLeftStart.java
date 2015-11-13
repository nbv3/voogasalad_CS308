package objects.player;

import java.util.Vector;

import objects.components.IPlayer;

public class MoveLeftStart implements KeyInput {

	@Override
	public void run(IPlayer comp) {
		double speed = comp.getSpeed();
		Vector<Double> vel = new Vector<>();
		vel.add(-1 * speed);
		vel.add(0.0);
		comp.setVelocity(vel);
	}

}
