package view;

public abstract class ViewableObject implements IViewable {

	private ObservableBoundingBox myBoundingBox;
	private int myID;
	
	public ViewableObject(int id, ObservableBoundingBox box) {
		this.myBoundingBox = box;
		this.myID = id;
	}

	@Override
	public void setID(int id) {
		this.myID = id;
	}
	
	@Override
	public int getID() {
		return this.myID;
	}
	
	@Override
	public void registerObserver(ObjectView obs) {
		myBoundingBox.addObserver(obs);
	}
	
}
