package objects;

import java.util.EventListener;

import objects.events.IEvent;

public interface GameEventListener extends EventListener{
	
	public void onEvent(IEvent e);

}
