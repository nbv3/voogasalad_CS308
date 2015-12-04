package com.syntacticsugar.vooga.authoring.parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import com.syntacticsugar.vooga.resources.*;

import com.sun.deploy.uitoolkit.impl.fx.ui.resources.ResourceManager;
import com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.WeaponAttribute;

import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.FileChooser;

public class ParameterFactory {
	
	private static final ResourceBundle paramResource = ResourceBundle.getBundle("com/syntacticsugar/vooga/resources/Parameters");
	private static final Map<Class<?>, String> paramaterMap = buildParameterMap();
	

	private static Map<Class<?>, String> buildParameterMap() {
		Enumeration<String> myClassNames = paramResource.getKeys();
		Map<Class<?>, String> myMap = new HashMap<Class<?>, String>();
		while(myClassNames.hasMoreElements()) {
			try {
				String next = myClassNames.nextElement();
				myMap.put(Class.forName(next), paramResource.getString(next));
			} catch (ClassNotFoundException e) { }
		}
		return myMap;
	}
	
	
	public static Node loadNode(IAttribute attribute){
		Constructor<?>[] constructors = attribute.getClass().getDeclaredConstructors();
		if(constructors.length>1) throw new IllegalArgumentException("This attribute has more than 1 constructor. Please check.");
		Class<?>[] paramTypes = constructors[0].getParameterTypes();
		for(Class<?> classType: paramTypes){
			creatGUIElement(classType);
			//createNode(classType, "hi");
		}
		return null;
	}
	
	private static void creatGUIElement(Class<?> c)
	{	System.out.println(c.getTypeName());
		String guiClassName = paramaterMap.get(c);
		System.out.println(guiClassName);
		Class guiClass; 
		Object guiObj;
		try {
			guiClass = Class.forName(guiClassName);
			System.out.println(guiClass.getTypeParameters());
			try {
				guiObj = guiClass.newInstance();
				Node n = createNode(guiObj.getClass());
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void createNode(FileChooser chooser)
	{
		
	}
	
	public static void main(String[] args){
		IAttribute att = new WeaponAttribute("gray.png", 10, KeyCode.A);
		loadNode(att);
	}
}
