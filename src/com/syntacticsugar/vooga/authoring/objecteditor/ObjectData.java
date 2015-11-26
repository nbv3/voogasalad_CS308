package com.syntacticsugar.vooga.authoring.objecteditor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;

public class ObjectData {

	private GameObjectType myType;
	private String myImagePath;
	private Collection<IAttribute> myAttributes;
	private Map<GameObjectType, Collection<IGameEvent>> myCollisionMap;
	
	public ObjectData() {
		myAttributes = new ArrayList<IAttribute>();
		myCollisionMap = new HashMap<GameObjectType, Collection<IGameEvent>>();
	}
	
	public GameObjectType getType() {
		return this.myType;
	}
	
	public String getImagePath() {
		return this.myImagePath;
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
	
	public void setImagePath(String myImagePath) {
		this.myImagePath = myImagePath;
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
