package com.syntacticsugar.vooga.universe;

import java.util.Collection;

import com.syntacticsugar.vooga.objects.IGameObject;

public interface IObjectDespawner {

	public void addToGraveYard(IGameObject toRemove);
	
	public void clearGraveYard();
	
	public Collection<IGameObject> getGraveYard();

}
