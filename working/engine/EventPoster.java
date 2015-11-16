package engine;

import objects.events.IEvent;

public interface EventPoster {

	public void postEvent(IEvent e);
	
}
