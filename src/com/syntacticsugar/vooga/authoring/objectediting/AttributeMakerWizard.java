package com.syntacticsugar.vooga.authoring.objectediting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ListIterator;
import java.util.Observable;
import java.util.Observer;


import com.syntacticsugar.vooga.authoring.parameters.ParameterFactory;
import com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.AIMovementAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.MovementControlAttribute;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.gui.factory.MsgInputBoxFactory;
import com.syntacticsugar.vooga.util.reflection.Reflection;
import com.syntacticsugar.vooga.util.reflection.ReflectionException;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AttributeMakerWizard implements Observer{

	private Stage myStage;
	private Scene myScene;
	private Collection<IAttribute> myAttributes;
	private IAttribute attributeToAdd;
	private String selectedAttribute;
	private final double SCENE_DIMENSION = 300;
	private ParameterFactory myFactory;
	private String selectedKeyCombo;

	public AttributeMakerWizard(GameObjectType type, Collection<IAttribute> attributes){
		myAttributes = attributes;
		myStage = new Stage();
		setType(type);
		myFactory = new ParameterFactory();
		myFactory.addObserver(this);
	}
	
	private void setParameters(IAttribute attribute)
	{
		if(myFactory == null)
		{
			myFactory = new ParameterFactory();
			myFactory.addObserver(this);
		}
		myFactory.loadNode(attribute);
	}
	
	public ParameterFactory getParameterFactory()
	{
		return myFactory;
	}
	
	public void setType(GameObjectType type) {
		myScene = new Scene(buildAttributes(type),SCENE_DIMENSION,SCENE_DIMENSION);
		myStage.setScene(myScene);
		myStage.initModality(Modality.APPLICATION_MODAL);
		myStage.showAndWait();
	}
	
	private VBox buildAttributes(GameObjectType type) {
		VBox ret = new VBox();
		ListView<String> attributeView = createAttributeListView(type);
		Button addAttribute = createAddAttributeBtn();
		ret.getChildren().addAll(attributeView, addAttribute);
		ret.setAlignment(Pos.CENTER_LEFT);
		ret.setSpacing(10);
		ret.setPrefSize(400, 100);
		return ret;
	}

	private ListView<String> createAttributeListView(GameObjectType type) {
		ListView<String> attributeView = new ListView<String>();
		String[] attributeNames = ResourceManager.getString(String.format("%s%s", type.name().toLowerCase(), "_attributes")).split(",");
		attributeView.getItems().addAll(attributeNames);
		attributeView.setOnMouseClicked(e -> {
			selectedAttribute =  attributeView.getSelectionModel().getSelectedItem();
		});
		return attributeView;
	}
	
	private Button createAddAttributeBtn() {
		Button addAttribute = new Button("Add Attribute");
		addAttribute.setOnMouseClicked(e -> {
        	createAttribute();
        });
		return addAttribute;
	}

	private void createAttribute() {
		if (selectedAttribute == null) {
			AlertBoxFactory.createObject("Please select an attribute first");
			return;
		}
		for (IAttribute i: myAttributes) {
			if (selectedAttribute.equals(i.getClass().getSimpleName())) {
				AlertBoxFactory.createObject(String.format("Cannot add more than one %s", selectedAttribute));
				return;
			}
		}	
		addAttributeToList();
	}

	private void addAttributeToList() {
			//MsgInputBoxFactory msgBox = new MsgInputBoxFactory(ResourceManager.getString(String.format("%s%s", "double_", selectedAttribute)));
			String className = ResourceManager.getString(String.format("%s_%s", selectedAttribute, "name"));
			try {
				attributeToAdd = (IAttribute) Reflection.createInstance(className, 0.0);
			}
			catch (ReflectionException ex) {
				attributeToAdd = (IAttribute) Reflection.createInstance(className);
			}
			setParameters(attributeToAdd);
	}

	@Override
	public void update(Observable o, Object arg) {
		Stage tempStage = new Stage();
		BorderPane tempPane = new BorderPane();
		Scene tempScene = new Scene(tempPane);
		tempStage.setScene(tempScene);
		tempPane.setCenter((Node) arg);
		tempStage.show();
		ListIterator<Node> myNodes = ((VBox) arg).getChildren().listIterator();
		while(myNodes.hasNext())
		{
			Node n = myNodes.next();
			if(n.getClass().getName().equals("javafx.scene.control.TextField"))
			{
				TextField textField = (TextField) n;	
				textField.setOnKeyPressed(e->updateParameters(tempStage, e.getCode(), textField.getText()));
			}
			else if(n.getClass().getName().equals("javafx.scene.layout.HBox"))
			{
				HBox box = (HBox) n;
				ListIterator<Node> children = box.getChildren().listIterator();
				while(children.hasNext())
				{
					Node child = children.next();
					if(child.getClass().getName().equals("javafx.scene.control.TextField"))
					{
						TextField text = (TextField) child;
						text.setOnKeyPressed(e->updateParameters(tempStage, e.getCode(), text.getText()));
					}
					else if(child.getClass().getName().equals("javafx.scene.control.ComboBox"))
					{
						ComboBox<String> comboBox = (ComboBox<String>) child;
					}
				}
				
				
			}
		}
		
	}
	
	private void updateParameters(Stage s, KeyCode code, String userInput)
	{
		if(code.equals(KeyCode.ENTER))
		{
			if(userInput != "")
			{
					if(attributeToAdd.getClass().getName().equals("com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute"))
					{
						HealthAttribute health = (HealthAttribute) attributeToAdd;
						health.setHealth(Double.parseDouble(userInput));
						myAttributes.add(health);
					}
					else if(attributeToAdd.getClass().getName().equals("com.syntacticsugar.vooga.gameplayer.attribute.movement.AIMovementAttribute"))
					{
						AIMovementAttribute move = (AIMovementAttribute) attributeToAdd;
						move.setSpeed(Double.parseDouble(userInput));
						myAttributes.add(move);
						
					}
					else if(attributeToAdd.getClass().getName().equals("com.syntacticsugar.vooga.gameplayer.attribute.movement.MovementControlAttribute"))
					{
						MovementControlAttribute userMove = (MovementControlAttribute) attributeToAdd;
						userMove.setSpeed(Double.parseDouble(userInput));
						myAttributes.add(userMove);
					}
					s.close();
			}

		}

	}

	
}
