package objects.enemy;

import java.awt.Point;
import java.util.List;

import objects.EObjectType;
import objects.attributes.IAttribute;
import objects.events.IEvent;

public abstract class AbstractEnemy implements IEnemy{
	
	private Point myPoint;
	private List<IAttribute> myComponents;
	
	public AbstractEnemy(Point p) {
		/*
		 * TODO: expand constructor
		 */
		myPoint = p;
	}
	
	public Point getPoint() {
		/**
		 * It's repetitive???
		 */
		return myPoint;
	}

	@Override
	public List<Point> findPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Point getLocation() {
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
