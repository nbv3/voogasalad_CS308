package com.syntacticsugar.vooga.gameplayer.utilities;

import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;

public class EnemyCountStat implements IGameStat{
	
	@SuppressWarnings("unused")
	private int enemyCount;

	public EnemyCountStat(){
		enemyCount = 0;
	}

	@Override
	public void receiveObject(IGameObject object) {
		if(object.getType().equals(GameObjectType.ENEMY)){
			enemyCount++;
		}		
	}

}
