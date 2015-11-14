package view;

public interface IViewable {

	public void setID(int id);
	
	public int getID();
	
	public void registerObserver(ObjectView o);
	
	public BoundingBox getBoundingBox();
	
}