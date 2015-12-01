package authoring.objectediting;

import java.util.List;

import authoring.data.ObjectData;

import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.gui.factory.MsgInputBoxFactory;
import com.syntacticsugar.vooga.util.reflection.Reflection;
import com.syntacticsugar.vooga.util.reflection.ReflectionException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AttributeMakerWizard {

	private Stage myStage;
	private Scene myScene;
	//private VBox myStageContent;
	private AttributeViewer myAttributeViewer;
	private GameObjectType typeChosen;
	private List<IAttribute> myAttributes;
	private IAttribute attributeToAdd;
	private String selectedAttribute;
	private final double SCENE_DIMENSION = 300;

	public AttributeMakerWizard(AttributeViewer attributeViewer, GameObjectType type, List<IAttribute> attributes){
		myAttributeViewer = attributeViewer;
		typeChosen = type;
		myAttributes = attributes;
		myStage = new Stage();
		myScene = new Scene(buildAttributes(typeChosen),SCENE_DIMENSION,SCENE_DIMENSION);
		myStage = new Stage();
		myStage.setScene(myScene);
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
		MsgInputBoxFactory msgBox = new MsgInputBoxFactory(ResourceManager.getString(String.format("%s%s", "double_", selectedAttribute)));
		if (msgBox.getValue() != 0) {
			String className = ResourceManager.getString(String.format("%s_%s", selectedAttribute, "name"));
			try {
				attributeToAdd = (IAttribute) Reflection.createInstance(className, msgBox.getValue());
			}
			catch (ReflectionException ex) {
				attributeToAdd = (IAttribute) Reflection.createInstance(className);
			}
			myAttributeViewer.addAttributeToList(attributeToAdd);
		}
	}
	
}
