package editor;

import objects.EObjectType;
import objects.events.IEvent;

public interface IEditableObject {
	
	public void setObjectType(EObjectType type);
	
	public void addCollisionEvent(EObjectType type, IEvent e);
	
}
