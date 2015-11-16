package objects.attributes;

import engine.EventPoster;
import objects.IGameObject;
import objects.events.IEvent;

public abstract class AbstractAttribute implements IAttribute{

	private IGameObject myParent;
	protected EventPoster myPoster;
	
	public AbstractAttribute(IGameObject parent) {
		myParent = parent;
		myPoster = myParent.getPoster();
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
	
	public EventPoster getPoster() {
		return myPoster;
	}

	public abstract void receiveEvent(IEvent e);

	public abstract void update();
	
	
	
}
