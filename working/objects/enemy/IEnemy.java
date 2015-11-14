package objects.enemy;

import java.util.List;

import javafx.geometry.Point2D;
import objects.IGameObject;

public interface IEnemy extends IGameObject{
	
	public Point2D getPoint();
	
	/**
	 * find path upon spawn
	 */
	public List<Point2D> findPath(); 
}
