package com.syntacticsugar.vooga.gameplayer.universe;

import java.util.ArrayList;
import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.attribute.ScoreAttribute;
import com.syntacticsugar.vooga.gameplayer.event.GameEventListener;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.ObjectDespawnEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.ScoreChangeEvent;
import com.syntacticsugar.vooga.gameplayer.manager.IEventManager;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.view.IViewRemover;
import com.syntacticsugar.vooga.util.ResourceManager;

public class GraveYard implements IYard<IViewRemover>, GameEventListener {

	private Collection<IGameObject> objectsInYard;
	private IObjectRemover myUniverse;
	
	private IEventPoster myPoster;

	public GraveYard(IObjectRemover universe, IEventManager manager) {
		objectsInYard = new ArrayList<IGameObject>();
		myUniverse = universe;
		manager.registerListener(this);
		myPoster = manager;
	}

	@Override
	public void alterUniverse(IViewRemover remover) {

		for (IGameObject obj : objectsInYard) {
			remover.removeViewObject(obj);
			myUniverse.removeGameObject(obj);
			
		}
		objectsInYard.clear();

	}

	@Override
	public void addToYard(IGameObject obj) {
		objectsInYard.add(obj);

	}


	@Override
	public void onEvent(IGameEvent e) {
		try {
			ObjectDespawnEvent event = (ObjectDespawnEvent) e;
			IGameObject obj = event.getObj();
			addToYard(obj);
			ScoreAttribute score = (ScoreAttribute) obj.getAttributes().get(ResourceManager.getString(ScoreAttribute.class.getSimpleName()));
			if (score != null) {
				int scoreNum = score.getScore();
				myPoster.postEvent(new ScoreChangeEvent(scoreNum));
			}
		}
		catch (ClassCastException ex) {
			
		}
	}

}
