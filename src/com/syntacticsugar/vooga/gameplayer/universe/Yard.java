package com.syntacticsugar.vooga.gameplayer.universe;

import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;

public abstract class Yard implements IYard{
	

	private Collection<IGameObject> objectsInYard;
	
	public Yard(){
		
	}
	
	@Override
	public boolean containsType(GameObjectType type) {
		boolean ret = false;
		for(IGameObject obj : objectsInYard){
			if(obj.getType().equals(type));
			ret = true;
			break;
		}
		return ret;
	}

}
