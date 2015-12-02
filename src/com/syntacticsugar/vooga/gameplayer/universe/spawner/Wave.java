package com.syntacticsugar.vooga.gameplayer.universe.spawner;

import java.util.LinkedList;
import java.util.Queue;

import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;

public class Wave implements IWave {
	
	private Queue<IGameObject> objs;
	
	private int myWaveNum;
	
	public Wave (WaveData data) {
		objs = new LinkedList<>();
		for(ObjectData o: data.getObjs()) {
			objs.add(new IGameObject(o));
		}
	}

	@Override
	public IGameObject getObj() {
		return objs.poll();
	}
	
	@Override
	public int getWaveSize() {
		return objs.size();
	}
	
	@Override
	public int getWaveNum() {
		return myWaveNum;
	}

}
