package com.syntacticsugar.vooga.util.gui.factory;

import java.lang.reflect.Constructor;

import com.sun.deploy.uitoolkit.impl.fx.ui.resources.ResourceManager;
import com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.WeaponAttribute;

import javafx.scene.Node;
import javafx.scene.input.KeyCode;

public class ParameterFactory {
	public ParameterFactory(){
		
	}
	
	public Node loadNode(IAttribute attribute){
	
		Constructor<?>[] constructors = attribute.getClass().getDeclaredConstructors();
		if(constructors.length>1) throw new IllegalArgumentException("This attribute has more than 1 constructor. Please check.");
		Class[] paramTypes = constructors[0].getParameterTypes();
		for(Class<?> classType:paramTypes){
			createNode(classType, "hi");
		}
		return null;
	}
	
	public Node createNode(Class<?> cs, String attributeName){
		String label = "double"+"_"+attributeName;
		return null;
	}
	
	public Node createNode(String string, String attributeName){
		String label = "String"+"_"+attributeName;

		return null;
	}
	
	public Node createNode(KeyCode keycode, String attributeName){
		String label = "KeyCode"+"_"+attributeName;

		return null;
	}	
	public static void main(String[] args){
		ParameterFactory paramFactory = new ParameterFactory();
		//paramFactory.createNode(new HealthAttribute(100));
		//paramFactory.createNode(1.0, new HealthAttribute(1.0).getClass().getSimpleName());
	}
}
