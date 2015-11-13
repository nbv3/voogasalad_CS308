package view;

import java.util.HashMap;
import java.util.Map;

public class ViewController {

	private Map<Integer, ObjectView> myViewMap;
	private ITransform currentTransform;
	
	public ViewController() {
		myViewMap = new HashMap<Integer, ObjectView>();
		currentTransform = null;
	}
	
	public void addViewObject(int id, IViewable obj, String path) {
		ObjectView newView = new ObjectView(path, currentTransform);
		obj.registerObserver(newView);
		myViewMap.put(id, newView);
	}
	
}
