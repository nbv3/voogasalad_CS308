package com.syntacticsugar.vooga.util.gui.factory;

import java.lang.reflect.Constructor;

import com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.WeaponAttribute;

import javafx.scene.Node;

public class ParameterFactory {
	public ParameterFactory(){
			
	}
	
	public Node createNode(IAttribute attribute){
		Constructor<?>[] constructors = attribute.getClass().getDeclaredConstructors();
		if(constructors.length>1) throw new IllegalArgumentException("This attribute has more than 1 constructor. Please check.");
		Class[] paramTypes = constructors[0].getParameterTypes();
		return null;
	}
	
//	public static void main(String[] args){
//		ParameterFactory paramFactory = new ParameterFactory();
//		//paramFactory.createNode(new HealthAttribute(100));
//		paramFactory.createNode(new WeaponAttribute(null, 0, null));
//	}
}
