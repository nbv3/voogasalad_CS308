package objects.attributes;

public interface IPlayer {

	//What functions can a player do?
	
	public void setVelocity(double dx, double dy);
	
	public void setX(double dx);
	
	public void setY(double dy);
	
	public double getSpeed();
	
	public void useItem(int itemNum);
}
