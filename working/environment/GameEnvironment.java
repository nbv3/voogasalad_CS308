package environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javafx.geometry.Point2D;
import objects.AbstractGameObject;
import tiles.DecoratorTile;
import view.ViewController;

public class GameEnvironment implements Observer, IEnvironment {

	private ViewController myViewController;
	private int currentViewID;
	private IGameMap myGameMap;
	private List<AbstractGameObject> environmentObjects;
	private List<AbstractGameObject> haveMoved;

	public GameEnvironment(int numCellsWide, int numCellsHigh) {
		currentViewID = 0;
		myViewController = new ViewController();
		environmentObjects = new ArrayList<AbstractGameObject>();
		buildGameMap(numCellsWide, numCellsHigh);
	}
	
	private void buildGameMap(int w, int h) {
		myGameMap = new GameMap(w, h);
		double tileWidth = 1000.0/((double) w);
		double tileHeight = 1000.0/((double) h);

		for (int i=0; i<w; i++) {
			for (int j=0;j<h; j++) {
				Point2D p = new Point2D((tileWidth*i + tileWidth/2.0), (tileHeight*j + tileHeight/2.0));
				DecoratorTile dt = new DecoratorTile(currentViewID++, p, tileWidth, tileHeight);
				myGameMap.setTile(p, dt);
				}
		}
	}
	
	@Override
	public void addToEnvironment(AbstractGameObject g) {
		environmentObjects.add(g);
	}


	@Override
	public void removeFromEnvironment(AbstractGameObject g) {
		environmentObjects.remove(g);

	}

	@Override
	public void updateObjects() {
		for(AbstractGameObject g: environmentObjects){
			g.update();
		}
		
	}


	@Override
	public List<AbstractGameObject> getEnvironmentObjects() {
		return environmentObjects;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> validate() {
		// TODO Auto-generated method stub
		return null;
	}

}
