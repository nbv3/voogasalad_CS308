package simple.view.implementation;

import java.util.HashMap;

public class SimpleViewController {
	
	private Map<Integer, ObjectView> myViewMap;
	private GameView myGameView;
	
	public ViewController(double size) {
		myViewMap = new HashMap<Integer, ObjectView>();
		myGameView = new GameView(size);
	}
	
	public void addViewObject(int id, IViewable obj, String path) {
		ObjectView newView = new ObjectView(path, obj.getBoundingBox(), myGameView);
		obj.registerObserver(newView);
		myViewMap.put(id, newView);
	}
	
	public GameView getGameView(){
		return myGameView;
	}

}
