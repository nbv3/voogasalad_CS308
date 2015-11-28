package authoring.objectediting;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class AttributeViewer {

	private Button myAddButton;
	private Button myRemoveButton;
	private ListView<HBox> myListView;

	public AttributeViewer(double width, double height) {
		myListView = new ListView<HBox>();
	}

	public void addAttributeToList(IAttribute attribute) {

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
	
	 private void selectedNewParameter(String t1, Text attributeValue, IAttribute attribute) {                
         attribute.getClass();
		 attributeValue.setText("");              
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

}
