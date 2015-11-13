package objects.enemy;

import java.awt.Point;
import java.util.List;

import objects.EObjectType;
import objects.components.IComponent;
import objects.events.IEvent;

public class AbstractEnemy implements IEnemy{
	
	private Point myPoint;
	private List<IComponent> myComponents;
	
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
	public void move(Point loc) {
		// TODO Auto-generated method stub
		
	}
	
}
