package authoring.objectediting;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class AttributeViewer extends EditingViewer {

	public AttributeViewer() {
		super(ResourceManager.getString("Attributes Added"));
		
	}

	public void addAttributeToList(IAttribute attribute) {
		addElementToList(makeListElement(attribute));
	}
	
	protected HBox makeListElement(IAttribute attribute){
		String attributeName = ResourceManager.getString(attribute.getClass().getSimpleName());
		HBox element = new HBox();
		element.getChildren().add(new Text(attributeName));
		element.getChildren().add(new Text(ResourceManager.getString("doubleclick_edit")));
		return element;
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
