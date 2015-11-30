package authoring.objectediting;

import java.util.ArrayList;
import authoring.data.ObjectData;

import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class AttributeViewer extends EditingViewer {

	private ObjectData myData;
	
	public AttributeViewer(ObjectData data) {
		super(ResourceManager.getString("attributes_added"));
		myData = data;
		myAddButton.setOnAction(e -> {
			new AttributeMakerWizard(this,myData);
		});
		myRemoveButton.setOnAction(e -> removeAttributeFromList());
	}

	public void addAttributeToList(IAttribute attribute) {
		myData.getAttributes().add(attribute);
		addElementToList(makeListElement(attribute));
		System.out.println("The attribute number is " + myData.getAttributes().size());
		for (IAttribute i: myData.getAttributes()) {
			System.out.println(i.getClass().getSimpleName());
		}
	}
	
	protected HBox makeListElement(IAttribute attribute){
		String attributeName = ResourceManager.getString(attribute.getClass().getSimpleName());
		HBox element = new HBox();
		element.getChildren().add(new Text(attributeName));
		element.getChildren().add(new Text(ResourceManager.getString("doubleclick_edit")));
		return element;
	}
	
	public void removeAttributeFromList() {
		if (!myData.getAttributes().isEmpty()) {
			int selectedIdx = myListView.getSelectionModel().getSelectedIndex();
			if (selectedIdx == -1) {
				AlertBoxFactory.createObject("Please first select an attribute from the list, then double click to remove");
				return;
			}
			removeAttribute(selectedIdx);
		}
		else {
			AlertBoxFactory.createObject("Attribute list empty, nothing to remove");
		}
		System.out.println(myData.getAttributes().size());
	}

	private void removeAttribute(int selectedIdx) {
		((ArrayList<IAttribute>) myData.getAttributes()).remove(selectedIdx);
		myListView.getItems().remove(selectedIdx);
	}
	
	/*
	 private void selectedNewParameter(String t1, Text attributeValue, IAttribute attribute) {                
         attribute.getClass();
		 attributeValue.setText("");              
     }    

	private HBox makeListElement(IAttribute attribute) {
		HBox listElement = new HBox();

		Text attributeName = new Text(attribute.getClass().getSimpleName());
		listElement.getChildren().add(attributeName);
		
		Text attributeValue = new Text();
		
		ComboBox<String> attributeParameter = new ComboBox<String>();
		attributeParameter.valueProperty().addListener((ov, t, t1) -> {
			selectedNewParameter(t1, attributeValue, attribute);
		});
        
		attributeParameter.getItems().addAll(makeParametersList(attribute));

	
		
		return listElement;

	}
	
	private List<String> makeParametersList(IAttribute attribute) {
		ArrayList<String> parameters = new ArrayList<String>();

		Constructor[] constructors = attribute.getClass().getDeclaredConstructors();
		for (int i = 0; i < constructors.length; i++) {
			Constructor c = constructors[i];
			Class[] paramTypes = c.getParameterTypes();

			for (int j = 0; j < paramTypes.length; j++) {
				if (j > 0)
					parameters.add(paramTypes[j].getCanonicalName());
			}
		}

		return parameters;
	}
	*/

}
