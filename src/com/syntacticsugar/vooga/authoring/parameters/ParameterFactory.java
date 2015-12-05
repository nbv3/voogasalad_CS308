package com.syntacticsugar.vooga.authoring.parameters;

import java.lang.reflect.Constructor;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Observable;
import java.util.ResourceBundle;

import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.AIMovementAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.MovementControlAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.weapon.BasicWeaponAttribute;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ParameterFactory extends Observable{
	private static final ResourceBundle paramResource = ResourceBundle.getBundle("com/syntacticsugar/vooga/resources/Parameters");
	private static Map<Class<?>, String> paramaterMap;
	private TextField myGUIObject;
	
	public ParameterFactory()
	{
		//paramaterMap = buildParameterMap();
	}
	/*private static Map<Class<?>, String> buildParameterMap() {
		Enumeration<String> myClassNames = paramResource.getKeys();
		Map<Class<?>, String> myMap = new HashMap<Class<?>, String>();
		while(myClassNames.hasMoreElements()) {
			try {
				String next = myClassNames.nextElement();
				myMap.put(Class.forName(next), paramResource.getString(next));
			} catch (ClassNotFoundException e) { 
				
			}
		}
		return myMap;
	}
	
	public Node loadNode(IAttribute attribute){
		Constructor<?>[] constructors = attribute.getClass().getDeclaredConstructors();
		if(constructors.length>1) throw new IllegalArgumentException("This attribute has more than 1 constructor. Please check.");
		Class<?>[] paramTypes = constructors[0].getParameterTypes();
		ArrayList<Class<?>> myParams = new ArrayList<Class<?>>(); 
		for(Class<?> classType: paramTypes){
			createGUIElement(classType, attribute);
		}

	}
	
	private void createGUIElement(Class<?> c, IAttribute attribute)
	{	
		for(Class<?> classCast : myGUIObjects)
		{
			for(int i = 0; i < myList.size(); i ++)
			{
				Class<?> temp = myList.get(i);
				String guiClassName = paramaterMap.get(temp);
				Class<?> guiClass = Class.forName(guiClassName);
				Object guiObj = guiClass.newInstance();
				if(classCast != null)
				{
					try{
						createNode((classCast)guiObj, attribute);
					}
					catch (InstantiationException | IllegalAccessException e){
						
					}
				}
				
			}
		}
		
		/*try {
			
			if(!attribute.getClass().getName().equals("com.syntacticsugar.vooga.gameplayer.attribute.movement.MovementControlAttribute"))
			{
				guiClass = Class.forName(guiClassName);
			}
			else
			{
				guiClass = Class.forName("javafx.scene.control.ComboBox");
				
			}
			
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
		}*/
		
	//
	//private void createNode(TextField obj, IAttribute attribute)
	//{
		/*switch(obj.getClass().getName())
		{
			case "javafx.stage.FileChooser":
				FileChooser chooser = (FileChooser) obj;
				if(attribute.getClass().getName().equals("WeaponAttribute"))
				{
					chooser.setInitialFileName(((WeaponAttribute)attribute).getImagePath());
				}
				Node temp = (Node) chooser;
			case "javafx.scene.control.TextField":
				TextField textField = (TextField) obj;
				VBox myBox = new VBox();
				if(attribute.getClass().getName().equals("com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute"))
				{
					Label myLabel = new Label("Health:");
					myBox.getChildren().clear();
					myBox.getChildren().addAll(myLabel, (Node)textField);
				}
				else if(attribute.getClass().getName().equals("com.syntacticsugar.vooga.gameplayer.attribute.movement.AIMovementAttribute"))
				{
					Label myLabel = new Label("AI Speed: ");
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
					HBox hBox = new HBox();
					for(KeyCode key: ((MovementControlAttribute)attribute).getKeyCodes().keySet())
					{
						myList.add(key.toString() + "  =  " + ((MovementControlAttribute)attribute).getKeyCodes().get(key).toString());
					}
					ComboBox<String> comboBox = new ComboBox<String>(myList);
					Label label = new Label("Key Controls: ");
					hBox.getChildren().clear();
					hBox.getChildren().addAll(label, (Node)comboBox);
					HBox box = new HBox();
					box.getChildren().clear();
					Label speedLabel = new Label("Speed: ");
					box.getChildren().addAll(speedLabel, new TextField());
					Node node = (Node) hBox;
					Node secondNode = (Node) box;
					VBox outerBox = new VBox();
					outerBox.getChildren().clear();
					outerBox.getChildren().addAll(node, secondNode);
					setChanged();
					notifyObservers((Node) outerBox);
					break;
				}*/
				
	/*}
	
	private void creatNode(ComboBox<String> box, IAttribute attribute)
	{
		
	}*/
	
	
	public static void main(String[] args){
		
	}
}
