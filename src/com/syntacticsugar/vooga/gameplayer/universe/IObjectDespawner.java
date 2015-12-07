package com.syntacticsugar.vooga.gameplayer.universe;

import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.view.IViewRemover;

public interface IObjectDespawner {

	/**
	 * Add a GameObject to the Graveyard (ie. mark it for despawn)
	 * 
	 * @param toRemove
	 */
	public void addToGraveYard(IGameObject toRemove);

	public void removeFromUniverse(IViewRemover remover);

	public GraveYard getGraveYard();

}
