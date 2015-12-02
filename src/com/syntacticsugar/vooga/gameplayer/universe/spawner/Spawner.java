package com.syntacticsugar.vooga.gameplayer.universe.spawner;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

import com.syntacticsugar.vooga.gameplayer.event.implementations.ObjectSpawnEvent;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.IEventPoster;

public class Spawner implements ISpawner {
	
	private Queue<Wave> myWaves;
	private Wave myCurrentWave;
	
	IEventPoster myPoster;
	
	private int myFrameCount;
	private int mySpawnRate;
	
	public Spawner (Collection<WaveData> data, IEventPoster poster) {
		myWaves = new LinkedList<>();
		for (WaveData d: data) {
			myWaves.add(new Wave(d));
		}
		if (myWaves.peek().getWaveNum() == 0) {
			myCurrentWave = myWaves.poll();
		}
		
		myPoster = poster;
	}

	@Override
	public void nextWave() {
		Wave myCurrentWave = myWaves.poll();
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
		
		if (myFrameCount % mySpawnRate == 0 && myCurrentWave.getWaveSize() != 0) {
			spawn();
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
	
	

}
