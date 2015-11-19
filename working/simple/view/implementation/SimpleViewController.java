package simple.view.implementation;

import java.util.HashMap;
import java.util.Map;

import simple.obj.IViewableObject;

public class SimpleViewController {

	private Map<Integer, ObjectView> myViewMap;
	private GameView myGameView;

	public SimpleViewController(double size) {
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

}
