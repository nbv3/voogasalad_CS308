package com.syntacticsugar.vooga.gameplayer.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;

public class GameInformation implements IGameInformation {

	private List<IGameStat> myStats;
	
	public GameInformation() {
		myStats = new ArrayList<IGameStat>();
	}

	@Override
	public void updateGameInformation(Collection<IGameObject> universe) {
		for (IGameStat stat : myStats) {
			for (IGameObject obj : universe) {
				stat.receiveObject(obj);
			}
		}

	}

	@Override
	public void getObservableStats() {
		// TODO Auto-generated method stub

	}

}
