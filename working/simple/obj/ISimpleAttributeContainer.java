package simple.obj;

import java.util.Collection;

import simple.attribute.ISimpleAttribute;

public interface ISimpleAttributeContainer {

	/**
	 * Returns a Collection of ISimpleAttribute objects contained
	 * by the specific SimpleGameObject instance.
	 * @return
	 */
	public Collection<ISimpleAttribute> getAttributes();
	
}
