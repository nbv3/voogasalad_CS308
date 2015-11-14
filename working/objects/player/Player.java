package objects.player;

import environment.GameEnvironment;
import javafx.geometry.Point2D;
import objects.AbstractGameObject;
import objects.IChild;
import objects.attributes.IPlayer;
import objects.attributes.PlayerControlAttribute;

public class Player extends AbstractGameObject {

	public Player(Point2D p, GameEnvironment g) {
		super(p, g);
		
		IChild player = new PlayerControlAttribute(this);
		this.getChildren().add(player);
	}

}
