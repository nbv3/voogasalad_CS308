package com.syntacticsugar.vooga.xml.data;

import java.util.List;

import com.syntacticsugar.vooga.gameplayer.conditions.IGameCondition;
import com.syntacticsugar.vooga.util.reflection.Reflection;

public class LevelSettings {

	private IGameCondition gameWin;
	private IGameCondition gameLose;
	private int spawnRate;
	
	private int scoreThreshold;

	public LevelSettings(String winClass, List<Double> winParam, String loseClass, List<Double> loseParam, int spawn) {
		spawnRate = spawn;
		{
			String winName = winClass.replace(" ", "");

			String classPath = String.format("%s%s%s", "com.syntacticsugar.vooga.gameplayer.conditions.implementation.",
					winName, "Condition");

			try {
				gameWin = (IGameCondition) Reflection.createInstance(classPath, winParam.get(0).intValue());
			} catch (Exception e) {
				gameWin = (IGameCondition) Reflection.createInstance(classPath);
			}
			String loseName = loseClass.replace(" ", "");
			String losePath = String.format("%s%s%s", "com.syntacticsugar.vooga.gameplayer.conditions.implementation.",
					loseName, "Condition");
			try {
				gameLose = (IGameCondition) Reflection.createInstance(losePath, loseParam.get(0).intValue());

			} catch (Exception e) {
				gameLose = (IGameCondition) Reflection.createInstance(losePath);
			}
		}
	}

	public LevelSettings(int scoreThreshold2) {
		scoreThreshold = scoreThreshold2;
	}

	public int getScoreThreshold() {
		return this.scoreThreshold;
	}

	public int getSpawnRate() {
		return spawnRate;
	}

}
