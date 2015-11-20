package com.syntacticsugar.vooga.attribute;

import com.syntacticsugar.vooga.objects.IGameObject;
import com.syntacticsugar.vooga.universe.IGameUniverse;

public abstract class AbstractAttribute implements IAttribute {

	private IGameObject myParent;
	
	/**
	 * Construct a new SimpleAttribute object with a parent object.
	 * @param parent
	 */
	public AbstractAttribute(IGameObject parent) {
		this.myParent = parent;
	}
	
	@Override
	public abstract void updateSelf(IGameUniverse universe);

	@Override
	public IGameObject getParent() {
		return this.myParent;
	}
	
}
