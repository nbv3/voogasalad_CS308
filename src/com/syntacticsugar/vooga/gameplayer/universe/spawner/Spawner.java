package com.syntacticsugar.vooga.gameplayer.universe.spawner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.ObjectSpawnEvent;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.IEventPoster;
import com.syntacticsugar.vooga.xml.data.ObjectData;
import com.syntacticsugar.vooga.xml.data.SpawnerData;
import com.syntacticsugar.vooga.xml.data.WaveData;

public class Spawner implements ISpawner {
	
	private Queue<Wave> myWaves;
	private Wave myCurrentWave;
	
	IEventPoster myPoster;
	
	private int myFrameCount;
	private int mySpawnRate;
	
	public Spawner (Collection<WaveData> data, IEventPoster poster, int spawnRate) {
		myWaves = new LinkedList<>();
		for (WaveData d: data) {
			myWaves.add(new Wave(d));
		}
		if (myWaves.size() != 0 && myWaves.peek().getWaveNum() == 0) {
			myCurrentWave = myWaves.poll();
		}
		
		myPoster = poster;
		mySpawnRate = spawnRate;
	}

	@Override
	public void nextWave() {
		myCurrentWave = myWaves.poll();
	}
	
	@Override
	public int getWaveNum() {
		return myCurrentWave.getWaveNum();
	}

	@Override
	public void update() {
		if (myCurrentWave == null) {
			return;
		}
		
		if (mySpawnRate == 0) {
			while (myCurrentWave.getWaveSize() != 0) {
				spawn();
			}
			return;
		}
		
		if (myFrameCount >= mySpawnRate && myCurrentWave.getWaveSize() != 0) {
			spawn();
			myFrameCount = 0;
		}
		myFrameCount++;
	}
	
	@Override
	public Wave getCurrentWave() {
		return myCurrentWave;
	}
	
	private void spawn() {
		IGameObject obj = myCurrentWave.getObj();
		ObjectSpawnEvent event = new ObjectSpawnEvent(obj);
		myPoster.postEvent(event);
	}

	@Override
	public void onEvent(IGameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SpawnerData saveGame() {
		Collection<WaveData> waves = new ArrayList<>();
		for (Wave w: myWaves) {
			Collection<ObjectData> objs = new ArrayList<>();
			for (IGameObject o: w.getAllObjs()) {
				objs.add(new ObjectData(o));
			}
			waves.add(new WaveData(objs));
		}
		return new SpawnerData(waves);
	}
	
	

}
