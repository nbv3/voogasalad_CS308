package simple.event;

import simple.attribute.ISimpleAttribute;
import simple.attribute.SimpleAbstractAttribute;
import simple.attribute.SimpleHealthAttribute;
import simple.obj.ISimpleObject;

public class SimpleHealthChangeEvent extends SimpleAbstractEvent {

	private double myDeltaHealth;
	
	public SimpleHealthChangeEvent(ISimpleObject target, double deltaHealth) {
		super(SimpleEvents.HealthChange, target);
		this.myDeltaHealth = deltaHealth;
	}
	
	@Override
	public void executeEvent() {
		for (ISimpleAttribute attribute : getTargetAttributes()) {
			attribute.receiveEvent(this);
		}
	}
	
	public double getDeltaHealth() {
		return this.myDeltaHealth;
	}

}
