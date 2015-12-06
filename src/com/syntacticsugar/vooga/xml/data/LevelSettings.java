package com.syntacticsugar.vooga.xml.data;

import java.util.List;

import com.syntacticsugar.vooga.gameplayer.conditions.IGameCondition;
import com.syntacticsugar.vooga.util.reflection.Reflection;

import javafx.geometry.Point2D;

public class LevelSettings {

	private IGameCondition winCond;
	private IGameCondition lossCond;

	private int scoreThreshold;
	private int startingMoney;
	
	private Point2D playerSpawn;

	public LevelSettings(int score) {
		setScoreThreshold(score);
		startingMoney = 0;
		playerSpawn = new Point2D(0.0, 0.0);
	}

	public LevelSettings(int score, int money) {
		setScoreThreshold(score);
		startingMoney = money;
		playerSpawn = new Point2D(0.0, 0.0);
	}
	
	public LevelSettings(int score, int money, Point2D spawn) {
		setScoreThreshold(score);
		startingMoney = money;
		setPlayerSpawn(spawn);
	}

	public LevelSettings(String winClass, List<Double> winParam, String loseClass, List<Double> loseParam, int spawn,
			int money) {
		startingMoney = money;
		{
			String winName = winClass.replace(" ", "");

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
				lossCond = (IGameCondition) Reflection.createInstance(losePath, loseParam.get(0).intValue());

			} catch (Exception e) {
				lossCond = (IGameCondition) Reflection.createInstance(losePath);
			}
		}
	}

	public int getScoreThreshold() {
		return scoreThreshold;
	}

	public void setScoreThreshold(int scoreThreshold) {
		this.scoreThreshold = scoreThreshold;
	}

	public int getStartingMoney() {
		return startingMoney;
	}

	public void setStartingMoney(int startingMoney) {
		this.startingMoney = startingMoney;
	}

	public Point2D getPlayerSpawn() {
		return playerSpawn;
	}

	public void setPlayerSpawn(Point2D playerSpawn) {
		this.playerSpawn = playerSpawn;
	}

}
