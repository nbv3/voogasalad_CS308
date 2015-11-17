package simple.event;

import java.util.Collection;

import objects.attributes.AbstractAttribute;
import simple.attribute.ISimpleAttribute;
import simple.attribute.SimpleAbstractAttribute;

public interface ISimpleEvent {
	
	/**
	 * Return the list of ISimpleAttributes contained by the target of this event.
	 * @return
	 */
	public Collection<ISimpleAttribute> getTargetAttributes();
	
	/**
	 * Return the enum type of this event.
	 * @return
	 */
	public SimpleEvents getEventType();
	
	/**
	 * Execute this event on the specified Target.
	 */
	public void executeEvent();

}
