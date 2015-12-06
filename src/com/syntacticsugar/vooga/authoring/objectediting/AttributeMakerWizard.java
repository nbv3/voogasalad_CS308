package com.syntacticsugar.vooga.authoring.objectediting;

import java.util.Collection;
import java.util.ListIterator;
import java.util.Observable;
import java.util.Observer;

import com.syntacticsugar.vooga.authoring.parameters.AbstractParameter;
import com.syntacticsugar.vooga.authoring.parameters.IEditableParameter;

import com.syntacticsugar.vooga.gameplayer.attribute.AbstractAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.AIMovementAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.MovementControlAttribute;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.reflection.Reflection;
import com.syntacticsugar.vooga.util.reflection.ReflectionException;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

	public AttributeMakerWizard(GameObjectType type, Collection<IAttribute> attributes){
		myAttributes = attributes;
		myStage = new Stage();
		setType(type);
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
			String className = ResourceManager.getString(String.format("%s_%s", selectedAttribute, "name"));
			try {
				attributeToAdd = (IAttribute) Reflection.createInstance(className);
			}
			catch (ReflectionException ex) {
			}
			((AbstractAttribute)attributeToAdd).addObserver(this);
			updateGUI(attributeToAdd);
	}
	
	private void updateGUI(IAttribute attribute)
	{
		Stage tempStage = new Stage();
		BorderPane tempPane = new BorderPane();
		Scene tempScene = new Scene(tempPane);
		tempStage.setScene(tempScene);
		tempStage.show();
		Collection<IEditableParameter<?>> myParameters = ((AbstractAttribute)attribute).getParams();
		for(IEditableParameter<?> parameter: myParameters)
		{
			TextField myText = new TextField();
			myText.setOnKeyPressed(e->updateAttribute(tempStage, e.getCode(), myText.getText(), (AbstractAttribute)attribute));
			HBox temp = new HBox();
			temp.getChildren().addAll(parameter.getLabel(), myText);
			tempPane.setCenter(temp);
		}
	}
	
	private void updateAttribute(Stage s, KeyCode code, String userInput, AbstractAttribute att)
	{
		if(!userInput.equals(null))
		{
			if(code.equals(KeyCode.ENTER))
			{
				if(!userInput.equals(""))
				{
					att.setValue(Double.parseDouble(userInput));
					myAttributes.add((IAttribute) att);
					s.close();
				}
			}
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		if(!(myAttributes.contains((IAttribute)arg)))
		{
			myAttributes.add((IAttribute)arg);
		}

	}

	
}
