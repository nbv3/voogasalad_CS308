package objects.enemy;

import java.util.List;

import javafx.geometry.Point2D;
import objects.EObjectType;
import objects.attributes.IAttribute;
import objects.events.IEvent;

public abstract class AbstractEnemy implements IEnemy{
	
	private Point2D myPoint;
	private List<IAttribute> myComponents;
	
	public AbstractEnemy(Point2D p) {
		/*
		 * TODO: expand constructor
		 */
		myPoint = p;
	}
	
	public Point2D getPoint() {
		/**
		 * It's repetitive???
		 */
		return myPoint;
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
	public Point2D getLocation() {
		return myPoint;
	}

	@Override
	public EObjectType getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendEventToChildren(IEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setToDestroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
}
