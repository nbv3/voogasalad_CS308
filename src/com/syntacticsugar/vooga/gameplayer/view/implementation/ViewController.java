package com.syntacticsugar.vooga.gameplayer.view.implementation;

import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.objects.GameObject;
import com.syntacticsugar.vooga.gameplayer.objects.IViewableObject;

public class ViewController {

	private Map<IViewableObject, ObjectView> myViewMap;
	private GameView myGameView;

	public ViewController(double width, double height) {
		myViewMap = new HashMap<IViewableObject, ObjectView>();
		myGameView = new GameView(width, height);
	}

	public void addViewObject(IViewableObject obj) {
		ObjectView newView = new ObjectView(obj.getPath(), obj.getBoundingBox(), myGameView);
		myViewMap.put(obj, newView);
	}

	public Map<IViewableObject, ObjectView> getViewMap() {
		return myViewMap;
	}
	
	public GameView getGameView() {
		return myGameView;
	}
	
	public void removeViewObject(IViewableObject obj){
		ObjectView object = myViewMap.get(obj);
		myGameView.getChildren().remove(object.getImageView());
		myViewMap.remove(obj);
	}

}
