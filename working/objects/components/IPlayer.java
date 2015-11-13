package objects.components;

import java.util.Vector;

public interface IPlayer {

	//What functions can a player do?
	
	public void setVelocity(Vector<Double> vel);
	
	public double getSpeed();
	
	public void useItem(int itemNum);
}
