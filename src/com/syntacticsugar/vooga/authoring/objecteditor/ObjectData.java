package com.syntacticsugar.vooga.authoring.objecteditor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;

public class ObjectData {

	private GameObjectType myType;
	private String myImagePath;
	private List<IAttribute> myAttributes;
	private Map<GameObjectType, Collection<IGameEvent>> myCollisionMap;
	
	public ObjectData() {
		myAttributes = new ArrayList<IAttribute>();
		myCollisionMap = new HashMap<GameObjectType, Collection<IGameEvent>>();
	}
	
	public GameObjectType getType() {
		return this.myType;
	}
	
	public void setType(GameObjectType type) {
		this.myType = type;
	}
	
	public String getImagePath() {
		return myImagePath;
	}

	public void setImagePath(String myImagePath) {
		this.myImagePath = myImagePath;
	}

	public void setAttributes(List<IAttribute> myAttributes) {
		this.myAttributes = myAttributes;
	}

	public void setCollisionMap(Map<GameObjectType, Collection<IGameEvent>> myCollisionMap) {
		this.myCollisionMap = myCollisionMap;
	}

	public List<IAttribute> getMyAttributes() {
		return myAttributes;
	}
	
	public void setMyAttributes(List<IAttribute> myAttributes) {
		this.myAttributes = myAttributes;
	}

	public Map<GameObjectType, Collection<IGameEvent>> getMyCollisionMap() {
		return myCollisionMap;
	}

	public void setMyCollisionMap(
			Map<GameObjectType, Collection<IGameEvent>> myCollisionMap) {
		this.myCollisionMap = myCollisionMap;
	}
	
}
