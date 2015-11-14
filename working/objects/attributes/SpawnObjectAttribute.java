package objects.attributes;

import objects.IGameObject;
import objects.events.EEventType;
import objects.events.IEvent;

public class SpawnObjectAttribute extends AbstractAttribute {
	
	Boolean isSpawning;

	public SpawnObjectAttribute(IGameObject parent) {
		super(parent);
		
	}

	@Override
	public void receiveEvent(IEvent e) {
		if (e.getSource().equals(getParent()) && e.getType().equals(EEventType.SpawnRequestEvent)){
			isSpawning = true;
		}
	}

	@Override
	public void update() {
		if (isSpawning) {
			//TODO: Spawn the object
		}
		
		isSpawning = false;
	}

}
