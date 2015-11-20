package com.syntacticsugar.vooga.utilities;

import java.util.Collection;

import com.syntacticsugar.vooga.objects.IGameObject;

import javafx.collections.ObservableList;

public class GameInformation implements IGameInformation {

	private ObservableList<IGameStat> myStats;

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
