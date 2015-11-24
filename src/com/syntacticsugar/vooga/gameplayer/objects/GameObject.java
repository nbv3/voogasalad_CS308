package com.syntacticsugar.vooga.gameplayer.objects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.util.ResourceManager;

import javafx.geometry.Point2D;

public class GameObject extends AbstractViewableObject implements IGameObject {

	private GameObjectType myType;
	private Map<String, IAttribute> myAttributeMap;
	private Map<GameObjectType, Collection<IGameEvent>> myCollisionEventMap;

	public GameObject(GameObjectType type, Point2D point, double width, double height, String path) {
		super(point, width, height, path);
		myType = type;
		myAttributeMap = new HashMap<String, IAttribute>();
		myCollisionEventMap = new HashMap<GameObjectType, Collection<IGameEvent>>();
	}

	@Override
	public void updateSelf(IGameUniverse universe) {
		for (IAttribute attribute : myAttributeMap.values()) {
			attribute.updateSelf(universe);
		}
	}

	@Override
	public Collection<IGameEvent> getEventsFromCollision(GameObjectType type) {
		return myCollisionEventMap.get(type);
	}

	@Override
	public void addCollisionBinding(GameObjectType type, IGameEvent event) {
		if (myCollisionEventMap.containsKey(type)) {
			getEventsFromCollision(type).add(event);
		} else {
			Collection<IGameEvent> onCollisionEvents = new ArrayList<IGameEvent>();
			onCollisionEvents.add(event);
			myCollisionEventMap.put(type, onCollisionEvents);
		}
	}

	@Override
	public GameObjectType getType() {
		return myType;
	}

	@Override
	public Map<String, IAttribute> getAttributes() {
		return Collections.unmodifiableMap(myAttributeMap);
	}

	@Override
	public void addAttribute(IAttribute attribute) {
		String key = ResourceManager.getString(attribute.getClass().getSimpleName());
		myAttributeMap.put(key, attribute);
	}

}
