package objects.events;

import objects.IGameObject;

public class ObjectSpawnEvent extends AbstractEvent {
	
	private String myPath;

	public ObjectSpawnEvent(IGameObject obj, String filepath) {
		super(EEventType.ObjectSpawnEvent);
		mySource = obj;
		myPath = filepath;
	}
	
	public String getPath() {
		return myPath;
	}
	
}
