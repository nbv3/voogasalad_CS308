package editor;

import simple.event.ISimpleEvent;
import simple.obj.SimpleObjectType;

public interface IEditableObject {
	
	public void setObjectType(SimpleObjectType type);
	
	public void addCollisionEvent(SimpleObjectType type, ISimpleEvent e);
	
}
