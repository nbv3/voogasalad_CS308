package com.syntacticsugar.vooga.objects;

import java.util.Collection;

import com.syntacticsugar.vooga.attribute.IAttribute;

public interface IAttributeCollection {

	/**
	 * Returns a Collection of ISimpleAttribute objects contained
	 * by the specific SimpleGameObject instance.
	 * @return
	 */
	public Collection<IAttribute> getAttributes();
	
	/**
	 * Adds an attribute to this SimpleAttributeContainer.
	 */
	public void addAttribute(IAttribute attribute);
	
}
