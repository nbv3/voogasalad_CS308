package com.syntacticsugar.vooga.gameplayer.attribute;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import com.syntacticsugar.vooga.authoring.parameters.AbstractParameter;
import com.syntacticsugar.vooga.authoring.parameters.IEditableParameter;
import com.syntacticsugar.vooga.authoring.parameters.IParameterContainer;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

public abstract class AbstractAttribute extends Observable implements IAttribute, IParameterContainer, Observer {

	private IGameObject myParent;
	private Collection<IEditableParameter<?>> myParams;
	
	/**
	 * Construct a new SimpleAttribute object with a null parent.
	 * @param parent
	 */
	public AbstractAttribute(AbstractParameter<?>... params) {
		myParams = new ArrayList<IEditableParameter<?>>();
		addParameters(params);
		this.myParent = null;
	}
	
	private void addParameters(AbstractParameter<?>... params)
	{
		for (int i=0; i<params.length; i++) {
			myParams.add(params[i]);
			params[i].addObserver(this);
		}
	}
	
	@Override
	public abstract void updateSelf(IGameUniverse universe);

	@Override
	public IGameObject getParent() {
		return this.myParent;
	}
	
	@Override
	public void setParent(IGameObject parent) {
		myParent = parent;
	}
	
	public Collection<IEditableParameter<?>> getParams()
	{
		return myParams;
	}
}
