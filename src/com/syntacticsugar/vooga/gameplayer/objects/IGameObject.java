package com.syntacticsugar.vooga.gameplayer.objects;

import java.util.Collection;
import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

public interface IGameObject extends IAttributeCollection, ICollidable, IViewableObject {

	/**
	 * Update this object within the context of the whole universe.
	 * @param universe
	 */
	public void updateSelf(IGameUniverse universe);
	
	/**
	 * Returns the Type of this object as specified by the SimpleObjectType enum.
	 * @return
	 */
	public GameObjectType getType();
	
	public BoundingBox getBoundingBox();

	
	// ISimpleAttributeContainer methods
	
	@Override
	public Map<String, IAttribute> getAttributes();

	@Override
	public void addAttribute(IAttribute attribute);
	
	
	// ISimpleCollidable methods
	
	@Override
	public Collection<IGameEvent> getEventsFromCollision(GameObjectType type);
	
	@Override
	public void addCollisionBinding(GameObjectType type, IGameEvent event);
	
}