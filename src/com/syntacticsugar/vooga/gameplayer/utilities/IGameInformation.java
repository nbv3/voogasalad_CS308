package com.syntacticsugar.vooga.gameplayer.utilities;

import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;

public interface IGameInformation {
	
	public void updateGameInformation(Collection<IGameObject> universe);
	
	public void getObservableStats();

}
