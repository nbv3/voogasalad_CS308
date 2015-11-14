package view;

import javafx.scene.layout.Pane;

public class GameView extends Pane{
		
	private double mySize;
	
	public GameView(double size){
		mySize = size;
	}
	
	/**
	 * TODO: talk to backend to figure out this scaling situation
	 */
	
	public double getScalingFactor(){
		return (1/1000)*mySize;
	}

}
