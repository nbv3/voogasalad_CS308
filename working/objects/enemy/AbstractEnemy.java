package objects.enemy;

import java.util.List;

import engine.EventPoster;
import javafx.geometry.Point2D;
import objects.AbstractGameObject;
import objects.EObjectType;
import objects.attributes.IAttribute;
import objects.events.IEvent;

public abstract class AbstractEnemy extends AbstractGameObject implements IEnemy{
	
	private List<IAttribute> myAttributes;
	
	public AbstractEnemy(Point2D p, double w, double h, EventPoster poster) {
		super(p, w, h, poster);
	}

	@Override
	public List<Point2D> findPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
}
