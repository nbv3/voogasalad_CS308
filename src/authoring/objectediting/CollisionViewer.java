package authoring.objectediting;

import java.util.List;

import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class CollisionViewer extends EditingViewer {

	public CollisionViewer() {
		super(ResourceManager.getString("collision_menu_title"));
	}
	
	private HBox makeListElement(GameObjectType objectType, List<IGameEvent> gameEvents){
		HBox element = new HBox();
		element.getChildren().add(new Text(ResourceManager.getString(objectType.toString())));
		element.getChildren().add(makeEventDropdown(gameEvents));
		return element;
	}
	
	private ComboBox<String> makeEventDropdown(List<IGameEvent> gameEvents){
		ComboBox<String> eventDropdown = new ComboBox<String>();
		for (IGameEvent gameEvent: gameEvents){
			String eventName = ResourceManager.getString(gameEvent.getClass().getSimpleName());
			eventDropdown.getItems().add(eventName);
		}
		return eventDropdown;
	}
	

}
