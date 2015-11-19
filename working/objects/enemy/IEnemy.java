package objects.enemy;

import java.awt.Point;
import java.util.List;

import environment.GameMap;
import objects.IGameObject;
import tools.PathFinder;

public interface IEnemy extends IGameObject{
	public Point getDestination();
	
	public List<Point> findPath(GameMap gm);
}
