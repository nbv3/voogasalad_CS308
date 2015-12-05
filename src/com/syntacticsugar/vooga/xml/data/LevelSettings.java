package com.syntacticsugar.vooga.xml.data;

import java.util.List;

import com.syntacticsugar.vooga.gameplayer.conditions.IGameCondition;
import com.syntacticsugar.vooga.util.reflection.Reflection;

public class LevelSettings {

	private IGameCondition winCond;
	private IGameCondition lossCond;

	private int mySpawnRate;
	
	private int scoreThreshold;
	
	public LevelSettings (int score) {
		setScoreThreshold(score);
		mySpawnRate = 0;
	}
	
	public LevelSettings (int score, int spawnRate) {
		setScoreThreshold(score);
		mySpawnRate = spawnRate;
	}

	public LevelSettings(String winClass, List<Double> winParam, String loseClass, List<Double> loseParam) {
		{
			String winName = winClass.replace(" ", "");
			// String winPath = String.format("%s%s%s",
			// "com.syntacticsugar.vooga.gameplayer.conditions.implementation.",
			// winName, "Condition");

			String classPath = String.format("%s%s%s", "com.syntacticsugar.vooga.gameplayer.conditions.implementation.",
					winName, "Condition");

			try {
				winCond = (IGameCondition) Reflection.createInstance(classPath, winParam.get(0).intValue());
			} catch (Exception e) {
				winCond = (IGameCondition) Reflection.createInstance(classPath);
			}
			String loseName = loseClass.replace(" ", "");
			String losePath = String.format("%s%s%s", "com.syntacticsugar.vooga.gameplayer.conditions.implementation.",
					loseName, "Condition");
			try {
				lossCond = (IGameCondition) Reflection.createInstance(losePath,loseParam.get(0).intValue());

			} catch (Exception e) {
				lossCond = (IGameCondition) Reflection.createInstance(losePath);
			}
		}
	}
	
	public int getSpawnRate() {
		return mySpawnRate;
	}

	public void setSpawnRate(int rate) {
		mySpawnRate = rate;
	}

	public int getScoreThreshold() {
		return scoreThreshold;
	}

	public void setScoreThreshold(int scoreThreshold) {
		this.scoreThreshold = scoreThreshold;
	}
	
}
