package com.syntacticsugar.vooga.utilities;

import com.syntacticsugar.vooga.objects.GameObjectType;
import com.syntacticsugar.vooga.objects.IGameObject;

public class EnemyCountStat implements IGameStat{
	
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
