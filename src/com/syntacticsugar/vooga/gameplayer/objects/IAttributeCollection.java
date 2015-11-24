package com.syntacticsugar.vooga.gameplayer.objects;

import java.util.Collection;
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
	 */
	public void addAttribute(IAttribute attribute);
	
}
