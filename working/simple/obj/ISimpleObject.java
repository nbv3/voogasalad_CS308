package simple.obj;

import java.util.Collection;

import simple.attribute.ISimpleAttribute;
import simple.event.ISimpleEvent;
import simple.universe.ISimpleUniverse;
import view.BoundingBox;
import view.ObjectView;

public interface ISimpleObject extends ISimpleAttributeContainer {

	/**
	 * Update this object within the context of the whole universe.
	 * @param universe
	 */
	public void updateSelf(ISimpleUniverse universe);
	
	/**
	 * Returns a Collection of Events associated with colliding with a specific type
	 * of object.
	 * @param type
	 * @return
	 */
	public Collection<ISimpleEvent> getEventsFromCollision(SimpleObjectType type);
	
	/**
	 * Returns the Type of this object as specified by the SimpleObjectType enum.
	 * @return
	 */
	public SimpleObjectType getType();

	
	// ISimpleAttributeContainer methods
	@Override
	public Collection<ISimpleAttribute> getAttributes();
	
	
	/**
	 * Sets the ID of this object.
	 * @param id
	 * @return
	 */
	public void setID(int id);
	
	/**
	 * Returns the ID of this object
	 * @return id
	 */
	public int getID();
	
	/**
	 * 
	 * @param o
	 */
	public void registerObserver(ObjectView o);
	
	public BoundingBox getBoundingBox();

}