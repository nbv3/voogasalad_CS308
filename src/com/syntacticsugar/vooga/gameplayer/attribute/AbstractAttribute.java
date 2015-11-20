package com.syntacticsugar.vooga.gameplayer.attribute;

import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

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
