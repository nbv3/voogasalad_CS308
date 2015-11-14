package objects.attributes;

import objects.IGameObject;
import objects.events.IEvent;

public class TimerAttribute extends AbstractAttribute {
	
	int tickLength; //How many frames per tick
	int frameCount;
	
	int timer;
	
	
	
	
	public TimerAttribute(IGameObject parent) {
		super(parent);
	}

	@Override
	public void receiveEvent(IEvent e) {
		
	}

	@Override
	public void update() {
		frameCount++;
		if (frameCount % tickLength == 0) {
			timer --;
			//Run all the events we are supposed to
		}
		
		if (timer <= 0) {
			//Run all the events we are supposed to
		}
	}

}
