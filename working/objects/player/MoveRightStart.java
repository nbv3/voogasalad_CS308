package objects.player;

import java.util.Vector;

import objects.attributes.IPlayer;

public class MoveRightStart implements KeyInput {

	@Override
	public void run(IPlayer comp) {
		double speed = comp.getSpeed();
		Vector<Double> vel = new Vector<>();
		vel.add(speed);
		vel.add(0.0);
		comp.setVelocity(vel);
	}

}
