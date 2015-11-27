package com.syntacticsugar.vooga.gameplayer.view.implementation;

import javafx.scene.layout.Pane;

public class GameView extends Pane{
	
	private double myWidth;
	private double myHeight;
	
	public GameView(double width, double height){
		myWidth = width;
		myHeight = height;
		this.setWidth(width);
		this.setHeight(height);
	}
	
	/**
	 * TODO: talk to backend to figure out this scaling situation
	 */
	
	public double[] getScalingFactor(){
		double[] ret = {(1.0/1000) * myWidth, (1.0/1000)*myHeight};
		return ret;
	}


}
