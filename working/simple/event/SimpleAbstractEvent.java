package simple.event;

import java.util.Collection;

import simple.attribute.ISimpleAttribute;
import simple.obj.ISimpleObject;

public abstract class SimpleAbstractEvent implements ISimpleEvent {

	private SimpleEvents myType;
	private ISimpleObject myTarget;
	
	public SimpleAbstractEvent(SimpleEvents type, ISimpleObject target) {
		this.myType = type;
		this.myTarget = target;
	}
	
	@Override
	public Collection<ISimpleAttribute> getTargetAttributes() {
		return myTarget.getAttributes();
	}
	
	@Override
	public SimpleEvents getEventType() {
		return this.myType;
	}
	
	@Override
	public abstract void executeEvent();
	
}
