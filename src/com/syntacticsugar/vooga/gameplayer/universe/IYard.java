package com.syntacticsugar.vooga.gameplayer.universe;

import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.view.IViewController;

public interface IYard<T extends IViewController> {

	public void addToYard(IGameObject obj);
	
	public void alterUniverse(T the);

}
