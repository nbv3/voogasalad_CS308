package com.syntacticsugar.vooga.gameplayer.universe;

import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;

public interface IObjectDespawner {

	public void addToGraveYard(IGameObject toRemove);
	
	public void clearGraveYard();

}
