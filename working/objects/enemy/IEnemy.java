package objects.enemy;

import java.util.List;

<<<<<<< HEAD
import javafx.geometry.Point2D;
=======
import environment.GameMap;
>>>>>>> 3ac8a181ea26f81bf2f885525a7b824fd41f6282
import objects.IGameObject;
import tools.PathFinder;

public interface IEnemy extends IGameObject{
	public Point getDestination();
	
<<<<<<< HEAD
	public Point2D getPoint();
	
	/**
	 * find path upon spawn
	 */
	public List<Point2D> findPath(); 
=======
	public List<Point> findPath(GameMap gm);
>>>>>>> 3ac8a181ea26f81bf2f885525a7b824fd41f6282
}
