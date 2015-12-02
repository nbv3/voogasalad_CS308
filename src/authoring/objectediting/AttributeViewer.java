package authoring.objectediting;

import java.util.List;

import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class AttributeViewer extends EditingViewer {

	private GameObjectType typeChosen;
	private List<IAttribute> myAttributes;
	
	public AttributeViewer(GameObjectType type, List<IAttribute> attributes) {
		super(ResourceManager.getString("attributes_added"));
		typeChosen = type;
		myAttributes = attributes;
		myAddButton.setOnAction(e ->openAttributeMakerWizard());
		myRemoveButton.setOnAction(e -> removeAttributeFromList());
	}

	private void openAttributeMakerWizard() {
		new AttributeMakerWizard(this,typeChosen,myAttributes);
	}

	public void addAttributeToList(IAttribute attribute) {
		myAttributes.add(attribute);
		addElementToList(makeListElement(attribute));
		
		System.out.println("*****add attribute******");
		System.out.println(typeChosen);
		for (IAttribute i: myAttributes) {
			System.out.println(i.getClass().getSimpleName());
		}
	}
	
	protected HBox makeListElement(IAttribute attribute){
		String attributeName = ResourceManager.getString(attribute.getClass().getSimpleName());
		HBox element = new HBox();
		element.getChildren().add(new Text(attributeName));
		return element;
	}
	
	public void removeAttributeFromList() {
		if (!myAttributes.isEmpty()) {
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
		
		System.out.println("*****remove attribute******");
		System.out.println(typeChosen);
		for (IAttribute i: myAttributes) {
			System.out.println(i.getClass().getSimpleName());
		}
	}

	private void removeAttribute(int selectedIdx) {
		myAttributes.remove(selectedIdx);
		myListView.getItems().remove(selectedIdx);
	}
	
	public void setTypeChosen(GameObjectType type) {
		typeChosen = type;
	}
	
	public GameObjectType getTypeChosen() {
		return typeChosen;
	}

}
