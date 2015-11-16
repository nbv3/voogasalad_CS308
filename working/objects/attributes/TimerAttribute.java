package objects.attributes;

import java.util.ArrayList;
import java.util.List;

import objects.IGameObject;
import objects.events.IEvent;

public class TimerAttribute extends AbstractAttribute {
	
	int tickLength; //How many frames per tick
	int frameCount;
	
	int timer;
	
	private List<IEvent> onTickLocalEvents;
	private List<IEvent> onTickGlobalEvents;
	private List<IEvent> onTimerEndLocalEvents;
	private List<IEvent> onTimerEndGlobalEvents;
	
	
	public TimerAttribute(IGameObject parent) {
		super(parent);
		onTickLocalEvents = new ArrayList<>();
		onTickGlobalEvents = new ArrayList<>();
		onTimerEndLocalEvents = new ArrayList<>();
		onTimerEndGlobalEvents = new ArrayList<>();
	}

	@Override
	public void receiveEvent(IEvent e) {
		
	}

	@Override
	public void update() {
		frameCount++;
		if (frameCount % tickLength == 0) {
			timer --;
			for (IEvent event: onTickLocalEvents) {
				getParent().sendEventToChildren(event);
			}
			
			for (IEvent event: onTickGlobalEvents) {
				getPoster().postEvent(event);
			}
		}
		
		if (timer <= 0) {
			for (IEvent event: onTimerEndLocalEvents) {
				getParent().sendEventToChildren(event);
			}
			
			for (IEvent event: onTimerEndGlobalEvents) {
				getPoster().postEvent(event);
			}
		}
	}
	
	public void addTickLocalEvent(IEvent event) {
		onTickLocalEvents.add(event);
	}
	
	public void addTickGlobalEvent(IEvent event) {
		onTickGlobalEvents.add(event);
	}
	
	public void addTimerEndLocalEvent(IEvent event) {
		onTimerEndLocalEvents.add(event);
	}
	
	public void addTimerEndGlobalEvent(IEvent event) {
		onTimerEndGlobalEvents.add(event);
	}

}
