package reflection;

import javafx.geometry.Point2D;
import simple.obj.SimpleObjectType;

public class ReflectionTest {
	
	public static void main(String args[]){
		
		SimpleObjectType type = SimpleObjectType.PLAYER;
		Integer width = 100;
		Integer length = 100;
		Point2D point = new Point2D(10, 10);
		String path = "enemy_dragon.png";
		String classname = "SimpleObject";
		
		System.out.println("HERER");
		
		Object myObject = Reflection.createInstance(classname, type, point, width, length, path);
		
		System.out.println("HERE");
		
		
		
	}

}
