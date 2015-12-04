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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.FileChooser;

public class ParameterFactory {
	
	private static final ResourceBundle paramResource = ResourceBundle.getBundle("Parameters");
	private static final Map<Class<?>, String> paramaterMap = buildParameterMap();
	

	private static Map<Class<?>, String> buildParameterMap() {
		Enumeration<String> myClassNames = paramResource.getKeys();
		Map<Class<?>, String> myMap = new HashMap<Class<?>, String>();
		while(myClassNames.nextElement() != null)
		{
			try {
				myMap.put(Class.forName(myClassNames.nextElement()), paramResource.getString(myClassNames.nextElement()));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return myMap;
	}
	
	
	public Node loadNode(IAttribute attribute){
		Constructor<?>[] constructors = attribute.getClass().getDeclaredConstructors();
		if(constructors.length>1) throw new IllegalArgumentException("This attribute has more than 1 constructor. Please check.");
		Class[] paramTypes = constructors[0].getParameterTypes();
		for(Class<?> classType: paramTypes){
			creatGUIElement(classType);
			//createNode(classType, "hi");
		}
		return null;
	}
	
	private void creatGUIElement(Class <?> c)
	{
		String guiClassName = paramaterMap.get(c);
		Class guiClass; 
		Object guiObj;
		try {
			guiClass = Class.forName(guiClassName);
			try {
				guiObj = guiClass.newInstance();
				Node n = createNode(guiObj, null);
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Node createNode(FileChooser choooser, String attributeName){
		choooser.setTitle("Select Image");
		String label = "imagePath"+"_"+attributeName;
		return null;
	}
	
	public Node createNode(ComboBox<KeyCode> comboBox, String attributeName){
		String label = "String"+"_"+attributeName;
		return null;
	}
	
	public Node createNode(TextField textField, String attributeName){
		String label = "KeyCode"+"_"+attributeName;
		return null;
	}	
	public static void main(String[] args){
		ParameterFactory paramFactory = new ParameterFactory();
		//paramFactory.createNode(new HealthAttribute(100));
		//paramFactory.createNode(1.0, new HealthAttribute(1.0).getClass().getSimpleName());
	}
}
