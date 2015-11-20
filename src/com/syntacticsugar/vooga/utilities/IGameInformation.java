package com.syntacticsugar.vooga.utilities;

import java.util.Collection;

import com.syntacticsugar.vooga.objects.IGameObject;

public interface IGameInformation {
	
	public void updateGameInformation(Collection<IGameObject> universe);
	
	public void getObservableStats();

}
