package com.syntacticsugar.vooga.gameplayer.objects;

import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;

public interface IAttributeCollection {

	/**
	 * Returns a Collection of ISimpleAttribute objects contained
	 * by the specific SimpleGameObject instance.
	 * @return
	 */
	public Map<String, IAttribute> getAttributes();
	
	/**
	 * Adds an attribute to this SimpleAttributeContainer.
	 * @param attribute
	 */
	public void addAttribute(IAttribute attribute);
	
	/**
	 * Removes an attribute from this SimpleAttributeContainer
	 * @param attribute
	 */
	public void removeAttribute(IAttribute attribute);
	
}
