package simple.eng;

import simple.obj.ISimpleObject;
import simple.universe.ISimpleUniverse;

public class SimpleKiller {
	
	public static void removeGraveYard(ISimpleUniverse universe){
		for(ISimpleObject toRemove: universe.getGraveYard()){
			universe.removeGameObject(toRemove);
		}
	}

}
