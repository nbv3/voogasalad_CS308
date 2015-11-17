package simple.obj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import simple.attribute.ISimpleAttribute;
import simple.event.ISimpleEvent;
import simple.universe.ISimpleUniverse;

public class SimpleObject implements ISimpleObject {

	private SimpleObjectType myType;
	private Collection<ISimpleAttribute> myAttributes;
	private Map<SimpleObjectType, Collection<ISimpleEvent>> myCollisionEventMap;

	public SimpleObject(SimpleObjectType type) {
		myType = type;
		myAttributes = new ArrayList<ISimpleAttribute>();
		myCollisionEventMap = new HashMap<SimpleObjectType, Collection<ISimpleEvent>>();
	}
	
	@Override
	public void updateSelf(ISimpleUniverse universe) {
		for (ISimpleAttribute attribute : myAttributes) {
			attribute.updateSelf(universe);
		}
	}

	@Override
	public Collection<ISimpleEvent> getEventsFromCollision(SimpleObjectType type) {
		return myCollisionEventMap.get(type);
	}

	@Override
	public SimpleObjectType getType() {
		return myType;
	}

	@Override
	public Collection<ISimpleAttribute> getAttributes() {
		return myAttributes;
	}

}
