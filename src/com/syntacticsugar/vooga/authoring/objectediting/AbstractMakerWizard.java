//This entire file is part of my masterpiece
//Arthur Schweitzer

package com.syntacticsugar.vooga.authoring.objectediting;

import java.util.Collection;
import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public abstract class AbstractMakerWizard<T> {
	
	/*This is the abstract class used to generate a new stage and window, which is opened when the user selects the option to 
	 either add a new attribute or collision-pair event via the '+' button in the attributeViewer or collisionViewer subsection
	 of the objectEditor display.*/
	
	private Stage myStage;
	private Scene myScene;
	protected Collection<T> myObjects;
	private T objectToAdd;
	protected GameObjectType selectedObject;
	protected String selectedObjectString;
	private final double SCENE_DIMENSION = 300;	
	private Button addObjectButton;
	private Map<GameObjectType, Collection<T>> myMap;
	
	public AbstractMakerWizard(GameObjectType type, Map<GameObjectType, Collection<T>> myCollection)
	{
		myMap = myCollection;
		myObjects = myCollection.get(type);
		myStage = new Stage();
		setType(type);
	}

	
	public Map<GameObjectType, Collection<T>> getMap()
	{
		return myMap;
	}
	
	private void setType(GameObjectType type) {
		if (buildObjects(type).getChildren().size() == 0) 
			return;
		myScene = new Scene(buildObjects(type), SCENE_DIMENSION, SCENE_DIMENSION);
		myStage.setScene(myScene);
		myStage.initModality(Modality.APPLICATION_MODAL);
		myStage.showAndWait();
	}
	
	private VBox buildObjects(GameObjectType type) {
		VBox ret = new VBox();
		ListView<String> eventView = createEventListView();
		ListView<String> objectView = createObjectListView(type);
		HBox listViewsBox = new HBox();
		if (objectView.getItems().size() == 0) 
			return new VBox(); 
		
		Button addObject = creatAddObjectButton();
		if(eventView != null)
		{
			listViewsBox.getChildren().addAll(objectView, eventView);
			ret.getChildren().addAll(listViewsBox, addObject);
		}
		else
		{
			ret.getChildren().addAll(objectView, addObject);
		}
		ret.setAlignment(Pos.CENTER_LEFT);
		ret.setSpacing(10);
		ret.setPrefSize(400, 100);
		return ret;
	}
	
	abstract ListView<String> createObjectListView(GameObjectType type);
	abstract ListView<String> createEventListView();
	abstract void createObject();
	
	protected Object getObjectToAdd()
	{
		return objectToAdd;
	}
	
	protected void setObjectToAdd(T o)
	{
		objectToAdd = o;
	}

	private Button creatAddObjectButton() {
		addObjectButton = new Button("Add");
				addObjectButton.setOnMouseClicked(e -> {
			createObject();
		});
		return addObjectButton;
	}
	


}
