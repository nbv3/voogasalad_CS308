package objects.player;

import engine.EventPoster;
import engine.environment.GameEnvironment;
import javafx.geometry.Point2D;
import objects.AbstractGameObject;
import objects.IChild;
import objects.attributes.IPlayer;
import objects.attributes.PlayerControlAttribute;
import view.ObjectView;
import view.BoundingBox;

public class Player extends AbstractGameObject {

	public Player(Point2D p, double w, double h, EventPoster poster) {
		super(p, w, h, poster);
		IChild player = new PlayerControlAttribute(this);
		this.getChildren().add(player);
	}

	//where should this go
	@Override
	public void registerObserver(ObjectView o) {
		// TODO Auto-generated method stub
		
	}

}
