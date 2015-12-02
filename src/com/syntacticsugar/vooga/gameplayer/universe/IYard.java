package com.syntacticsugar.vooga.gameplayer.universe;

import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;

public interface IYard {

	public void addToYard(IGameObject obj);

	public boolean containsType(GameObjectType type);

	public int countType(GameObjectType type);

}
