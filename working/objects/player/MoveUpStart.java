package objects.player;

import java.util.Vector;

import objects.components.IPlayer;

public class MoveUpStart implements KeyInput {

	@Override
	public void run(IPlayer comp) {
		double speed = comp.getSpeed();
		Vector<Double> vel = new Vector<>();
		vel.add(0.0);
		vel.add(speed);
		comp.setVelocity(vel);
	}

}
