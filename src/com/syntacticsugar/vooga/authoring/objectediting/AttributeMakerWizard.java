//This entire file is part of my masterpiece
//Arthur Schweitzer

package com.syntacticsugar.vooga.authoring.objectediting;

import java.util.Collection;
import java.util.Map;

import com.syntacticsugar.vooga.authoring.parameters.ParameterInputFactory;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.reflection.Reflection;
import com.syntacticsugar.vooga.util.reflection.ReflectionException;

import javafx.scene.control.ListView;


public class AttributeMakerWizard extends AbstractMakerWizard{

	
	/*This subclass of AbstractMakerWizard is called when the user selects the option to add an attribute. This works in tandem with the 
	ParameterInputFactory in order to generate the appropriate labels, TextFields, and buttons for each specific attribute,
	and then populates the newly generated stage/scene with these components. Whenever new attribute created, it is added to the
	list of displayed attributes within the AttributeViewer.*/
	 
	
	public AttributeMakerWizard(GameObjectType type, Map<GameObjectType, Collection<IAttribute>> attributeMap) {
		super(type, attributeMap);
	}

	@Override ListView<String> createObjectListView(GameObjectType type) {
		ListView<String> attributeView = new ListView<String>();
		if (type == null) return new ListView<String>();
		String[] attributeNames = ResourceManager
				.getString(String.format("%s%s", type.name().toLowerCase(), "_attributes")).split(",");
		attributeView.getItems().addAll(attributeNames);
		attributeView.setOnMouseClicked(e -> {
			selectedObjectString = attributeView.getSelectionModel().getSelectedItem();
		});
		return attributeView;
	}
	
	private void addAttributeToList() {
			String className = ResourceManager.getString(String.format("%s_%s", selectedObjectString, "name"));
			try {
				setObjectToAdd((IAttribute) Reflection.createInstance(className));
				ParameterInputFactory.createInputFields(getObjectToAdd());
				myObjects.add((IAttribute) getObjectToAdd());
			}
			catch (ReflectionException ex) {
				System.out.println(className);
			}
	}

	@Override
	void createObject() {
		if (selectedObjectString == null) {
			AlertBoxFactory.createObject(ResourceManager.getString("select_attribute"));
			return;
		}
		for (Object o : myObjects) 
		{				
			if (selectedObjectString.equals(o.getClass().getSimpleName())) {
				AlertBoxFactory.createObject(String.format("Cannot add more than one %s", selectedObjectString));
				return;
			}
		}
			addAttributeToList();
	}

	@Override
	ListView createEventListView() {
		return null;
	}
	
}
