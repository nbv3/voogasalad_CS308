package player;

import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.objects.IViewableObject;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.IGameTile;
import com.syntacticsugar.vooga.gameplayer.view.GameView;
import com.syntacticsugar.vooga.gameplayer.view.IViewAdder;
import com.syntacticsugar.vooga.gameplayer.view.IViewRemover;
import com.syntacticsugar.vooga.gameplayer.view.ObjectView;

public class GameViewController implements IViewAdder, IViewRemover {

	private Map<IViewableObject, ObjectView> myViewMap;
	private GameView myGameView;
	
	public GameViewController(){
		myViewMap = new HashMap<IViewableObject, ObjectView>();
		myGameView = new GameView(600);
	}
	
	public void displayLevel(IGameUniverse level) {
		myViewMap.clear();
		myGameView.getChildren().clear();
		for(IGameTile tile : level.getMap().getTiles()){
			// Add the tile objects to the view
			addViewObject(tile);
		}
		for(IGameObject object : level.getGameObjects()){
			addViewObject(object);
		}
	}

	@Override
	public void removeViewObject(IViewableObject obj) {
		ObjectView object = myViewMap.remove(obj);
		myGameView.getChildren().remove(object);
	}

	@Override
	public void addViewObject(IViewableObject obj) {
		myViewMap.put(obj, new ObjectView(obj.getPath(), obj.getBoundingBox(), myGameView.getScalingFactor()));
	}
	
}
