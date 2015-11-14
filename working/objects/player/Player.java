package objects.player;

import java.awt.Point;

import environment.GameEnvironment;
import objects.AbstractGameObject;
import objects.IChild;
import objects.attributes.IPlayer;
import objects.attributes.PlayerControlAttribute;
import view.ObjectView;
import view.ObservableBoundingBox;

public class Player extends AbstractGameObject {

	public Player(Point p, GameEnvironment g) {
		super(p, g);
		
		IChild player = new PlayerControlAttribute(this);
		this.getChildren().add(player);
	}

	@Override
	public void setID(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void registerObserver(ObjectView o) {
		// TODO Auto-generated method stub
		
	}

}
