package com.syntacticsugar.vooga.gameplayer.view.implementation;

import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.objects.IViewableObject;

public class ViewController {

	private Map<Integer, ObjectView> myViewMap;
	private GameView myGameView;

	public ViewController(double size) {
		myViewMap = new HashMap<Integer, ObjectView>();
		myGameView = new GameView(size);
	}

	public void addViewObject(IViewableObject obj) {
		ObjectView newView = new ObjectView(obj.getPath(), obj.getBoundingBox(), myGameView);
		myViewMap.put(obj.returnID(), newView);
	}

	public GameView getGameView() {
		return myGameView;
	}
	
	public void removeViewObject(IViewableObject obj){
		ObjectView object = myViewMap.get(obj.returnID());
		myGameView.getChildren().remove(object.getImageView());
		myViewMap.remove(obj.returnID());
	}

}
