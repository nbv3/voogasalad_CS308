package com.syntacticsugar.vooga.gameplayer.universe;

import java.util.ArrayList;
import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.event.GameEventListener;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.view.IViewRemover;

public class GraveYard implements IYard<IViewRemover>, GameEventListener {

	private Collection<IGameObject> objectsInYard;
	private IObjectRemover myUniverse;

	public GraveYard(IObjectRemover universe) {
		objectsInYard = new ArrayList<IGameObject>();
		myUniverse = universe;
	}

	@Override
	public void alterUniverse(IViewRemover remover) {
		for (IGameObject obj : objectsInYard) {
			myUniverse.removeGameObject(obj);
			remover.removeViewObject(obj);
		}
		objectsInYard.clear();
	}

	@Override
	public void addToYard(IGameObject obj) {
		objectsInYard.add(obj);

	}

	@Override
	public boolean containsType(GameObjectType type) {
		boolean ret = false;
		if(countType(type) > 0){
			ret = true;
		}
		return ret;
	}

	@Override
	public int countType(GameObjectType type) {
		int ret = 0;
		for(IGameObject obj : objectsInYard){
			if(obj.getType().equals(type)){
				ret ++;
			}
		}
		return ret;
	}

	@Override
	public void onEvent(IGameEvent e) {
		// TODO Auto-generated method stub
		
	}

}
