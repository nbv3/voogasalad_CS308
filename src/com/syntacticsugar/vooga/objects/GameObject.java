package com.syntacticsugar.vooga.objects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.attribute.IAttribute;
import com.syntacticsugar.vooga.event.IGameEvent;
import com.syntacticsugar.vooga.universe.IGameUniverse;

import javafx.geometry.Point2D;

public class GameObject extends AbstractViewableObject implements IGameObject {

	private GameObjectType myType;
	private Collection<IAttribute> myAttributes;
	private Map<GameObjectType, Collection<IGameEvent>> myCollisionEventMap;

	public GameObject(GameObjectType type, Point2D point, double width, double height, String path, int id) {
		super(point, width, height, path, id);
		myType = type;
		myAttributes = new ArrayList<IAttribute>();
		myCollisionEventMap = new HashMap<GameObjectType, Collection<IGameEvent>>();
	}

	@Override
	public void updateSelf(IGameUniverse universe) {
		for (IAttribute attribute : myAttributes) {
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
	public Collection<IAttribute> getAttributes() {
		return myAttributes;
	}

	@Override
	public void addAttribute(IAttribute attribute) {
		myAttributes.add(attribute);
	}

}
