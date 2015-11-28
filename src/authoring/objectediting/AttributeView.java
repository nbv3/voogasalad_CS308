package authoring.objectediting;

import java.util.ArrayList;
import java.util.List;

import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class AttributeView {

	private Button myAddButton;
	private Button myRemoveButton;
	private ListView<HBox> myListView;
	
	public AttributeView(double width, double height){
		myListView = new ListView<HBox>();
	}
	
	public void addAttributeToList(IAttribute attribute){
		
	}
	
	private HBox makeListElement(IAttribute attribute){
		HBox listElement = new HBox();
		
		Text attributeName = new Text(attribute.getClass().getSimpleName());
		listElement.getChildren().add(attributeName);
		
		ComboBox<String> attributeParameter = new ComboBox<String>();
		attributeParameter.getItems().addAll(makeParametersList(attribute));
		
		return listElement;
	
	}
	
	private List<String> makeParametersList(IAttribute attribute){
		ArrayList<String> parameters = new ArrayList<String>();
		Object object = attribute.getClass();
		
		return parameters;
	}
	
}
