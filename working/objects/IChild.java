package objects;

import engine.EventPoster;
import objects.events.IEvent;

public interface IChild {

	//Gets the object immediately above the component
	public IGameObject getParent();
	
	//Gets the root object (same as getParent unless the parent is an item attached to another object)
	public IGameObject getRootObj();
	
	public EventPoster getPoster();
	
	public void receiveEvent(IEvent e);
	
	public void update();
	
}
