package objects.player;

import java.awt.Point;

import environment.GameEnvironment;
import objects.AbstractGameObject;
import objects.IChild;
import objects.attributes.IPlayer;
import objects.attributes.PlayerControlAttribute;

public class Player extends AbstractGameObject {

	public Player(Point p, GameEnvironment g) {
		super(p, g);
		
		IChild player = new PlayerControlAttribute(this);
		this.getChildren().add(player);
	}

}
