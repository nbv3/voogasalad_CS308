package objects.enemy;

import java.awt.Point;
import java.util.List;

import objects.IGameObject;

public interface IEnemy extends IGameObject{
	
	public Point getPoint();
	
	/**
	 * find path upon spawn
	 */
	public List<Point> findPath(); 
}
