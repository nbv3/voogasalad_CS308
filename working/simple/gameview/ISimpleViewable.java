package simple.gameview;

import java.util.Observer;

import simple.obj.ISimpleBoundingBox;

public interface ISimpleViewable extends Observer {

	public ISimpleBoundingBox getBoundingBox();
	
	public void registerView(SimpleObjectView view);
	
}
