package objects.components;

import objects.IGameObject;
import objects.events.IEvent;

public abstract class AbstractComponent implements IComponent{

	private IGameObject myParent;
	
	public AbstractComponent(IGameObject parent) {
		myParent = parent;
	}
	
	@Override
	public IGameObject getParent() {
		return myParent;
	}

	@Override
	public IGameObject getRootObj() {
		// TODO Auto-generated method stub
		//Not sure how to do this yet
		return null;
	}

	public abstract void receiveEvent(IEvent e);

	public abstract void update();
	
	
	
}
