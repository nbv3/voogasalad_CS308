package authoring.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;

import javafx.geometry.Point2D;

public class ObjectData extends AbstractData {

	private GameObjectType myType;
	private String myName;
	private Point2D mySpawnPoint;
	private String myImagePath;
	private Collection<IAttribute> myAttributes;
	private Map<GameObjectType, Collection<IGameEvent>> myCollisionMap;
	
	public ObjectData() {
		mySpawnPoint = new Point2D(0, 0);
		myAttributes = new ArrayList<IAttribute>();
		myCollisionMap = new HashMap<GameObjectType, Collection<IGameEvent>>();
	}
	
	public GameObjectType getType() {
		return this.myType;
	}
	
	public Point2D getSpawnPoint() {
		return this.mySpawnPoint;
	}
	
	public String getImagePath() {
		return this.myImagePath;
	}
	
	public String getObjectName(){
		return this.myName;
	}
	
	public Collection<IAttribute> getAttributes() {
		return this.myAttributes;
	}
	
	public Map<GameObjectType, Collection<IGameEvent>> getCollisionMap() {
		return this.myCollisionMap;
	}
	
	public void setType(GameObjectType type) {
		this.myType = type;
	}
	
	public void setSpawnPoint(double x, double y) {
		this.mySpawnPoint = new Point2D(x, y);
	}
	
	public void setImagePath(String myImagePath) {
		this.myImagePath = myImagePath;
	}
	
	public void setObjectName(String name) {
		this.myName = name;
	}

	public void setAttributes(Collection<IAttribute> attributes) {
		this.myAttributes.clear();
		this.myAttributes.addAll(attributes);
	}

	public void setCollisionMap(Map<GameObjectType, Collection<IGameEvent>> collisionMap) {
		this.myCollisionMap.clear();
		this.myCollisionMap.putAll(collisionMap);
	}
	
}
