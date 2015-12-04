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
import java.util.Observable;
import java.util.Properties;
import java.util.ResourceBundle;

import com.syntacticsugar.vooga.resources.*;

import com.sun.deploy.uitoolkit.impl.fx.ui.resources.ResourceManager;
import com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.WeaponAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.AIMovementAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.MovementControlAttribute;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;

public class ParameterFactory extends Observable{
	private static final ResourceBundle paramResource = ResourceBundle.getBundle("com/syntacticsugar/vooga/resources/Parameters");
	private static Map<Class<?>, String> paramaterMap;
	
	public ParameterFactory()
	{
		paramaterMap = buildParameterMap();
	}
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
	
	
	public Node loadNode(IAttribute attribute){
		Constructor<?>[] constructors = attribute.getClass().getDeclaredConstructors();
		if(constructors.length>1) throw new IllegalArgumentException("This attribute has more than 1 constructor. Please check.");
		Class<?>[] paramTypes = constructors[0].getParameterTypes();
		for(Class<?> classType: paramTypes){
			createGUIElement(classType, attribute);
		}
		return null;
	}
	
	private void createGUIElement(Class<?> c, IAttribute attribute)
	{	
		String guiClassName = paramaterMap.get(c);
		Class<?> guiClass; 
		Object guiObj;
		try {
			guiClass = Class.forName(guiClassName);
			try {
				guiObj = guiClass.newInstance();
				createNode(guiObj, attribute);
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void createNode(Object obj, IAttribute attribute)
	{
		switch(obj.getClass().getName())
		{
			/*case "javafx.stage.FileChooser":
				FileChooser chooser = (FileChooser) obj;
				if(attribute.getClass().getName().equals("WeaponAttribute"))
				{
					chooser.setInitialFileName(((WeaponAttribute)attribute).getImagePath());
				}
				Node temp = (Node) chooser;*/
			case "javafx.scene.control.TextField":
				TextField textField = (TextField) obj;
				HBox myBox = new HBox();
				if(attribute.getClass().getName().equals("com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute"))
				{
					Label myLabel = new Label("Health:");
					myBox.getChildren().clear();
					myBox.getChildren().addAll(myLabel, (Node)textField);
				}
				else if(attribute.getClass().getName().equals("com.syntacticsugar.vooga.gameplayer.attribute.movement.AIMovementAttribute"))
				{
					Label myLabel = new Label("AIMovement: ");
					myBox.getChildren().clear();
					myBox.getChildren().addAll(myLabel, (Node)textField);
					
				}
				Node n = (Node) myBox;
				setChanged();
				notifyObservers(n);
				break;
			case "javafx.scene.control.ComboBox":

				if(attribute.getClass().getName().equals("com.syntacticsugar.vooga.gameplayer.attribute.movement.MovementControlAttribute"))
				{
					ObservableList<String> myList = FXCollections.observableArrayList();
					for(KeyCode key: ((MovementControlAttribute)attribute).getKeyCodes().keySet())
					{
						myList.add(key.toString() + " = " + ((MovementControlAttribute)attribute).getKeyCodes().get(key).toString());
					}
					ComboBox<String> comboBox = new ComboBox<String>(myList);
					Node node = (Node) comboBox;
					setChanged();
					notifyObservers(node);
					break;
				}
				
		}
	}
	
	
	public static void main(String[] args){
		
	}
}
