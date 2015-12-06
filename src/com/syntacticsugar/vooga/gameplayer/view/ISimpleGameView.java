package com.syntacticsugar.vooga.gameplayer.view;

import javafx.scene.layout.Pane;

public interface ISimpleGameView {
	
	public void addObjectView(Pane obj);
	
	public void removeObjectView(Pane obj);
	
	public double getScalingFactor();

}
