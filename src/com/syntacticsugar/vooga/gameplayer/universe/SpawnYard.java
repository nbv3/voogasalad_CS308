package com.syntacticsugar.vooga.gameplayer.universe;

import java.util.ArrayList;
import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.event.GameEventListener;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.ObjectSpawnEvent;
import com.syntacticsugar.vooga.gameplayer.manager.IEventManager;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.view.IViewAdder;

public class SpawnYard implements IYard<IViewAdder>, GameEventListener{

	private Collection<IGameObject> objectsInYard;
	private IObjectAdder myUniverse;

	public SpawnYard(IObjectAdder universe, IEventManager manager) {
		objectsInYard = new ArrayList<IGameObject>();
		myUniverse = universe;
		manager.registerListener(this);
	}

	@Override
	public void addToYard(IGameObject obj) {
		objectsInYard.add(obj);
	}

	@Override
	public void alterUniverse(IViewAdder adder) {
		for (IGameObject obj : objectsInYard) {
			myUniverse.addGameObject(obj);
			adder.addViewObject(obj);
		}
		objectsInYard.clear();
	}

	@Override
	public void onEvent(IGameEvent e) {
		try {
			ObjectSpawnEvent event = (ObjectSpawnEvent) e;
			addToYard(event.getObj());
		}
		catch (Exception ex){
			
		}
	}

}
