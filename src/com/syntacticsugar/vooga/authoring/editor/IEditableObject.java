package com.syntacticsugar.vooga.authoring.editor;

import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;

public interface IEditableObject {
	
	public void setObjectType(GameObjectType type);
	
	public void addCollisionEvent(GameObjectType type, IGameEvent e);
	
}
