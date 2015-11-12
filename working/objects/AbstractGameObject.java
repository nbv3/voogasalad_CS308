package objects;

import java.awt.Point;
import java.util.Observable;

import environment.GameEnvironment;

public abstract class AbstractGameObject extends Observable implements IGameObject{

	Point myLocation;

	public AbstractGameObject(Point p, GameEnvironment g) {
		myLocation = p;
		this.addObserver(g);
	}

}
