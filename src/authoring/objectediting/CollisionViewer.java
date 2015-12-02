package authoring.objectediting;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;

import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class CollisionViewer implements IUserInterface, 
										IListViewDisplay, 
										IDataDisplay<Map<GameObjectType, Collection<IGameEvent>>> {
	private VBox myView;
	private ListView<HBox> myListView;
	private ObservableList<HBox> myCollisionDisplays;
	private ObservableMap<GameObjectType, Collection<IGameEvent>> myCollisions;
	private Map<GameObjectType, HBox> myDisplayMap;

	public CollisionViewer() {
		myView = new VBox();
		myDisplayMap = new HashMap<>();
		myCollisionDisplays = FXCollections.observableArrayList();
		myCollisions = FXCollections.observableHashMap();
		myCollisions.addListener(new MapChangeListener<GameObjectType, Collection<IGameEvent>>() {
			@Override
			public void onChanged(Change<? extends GameObjectType, ? extends Collection<IGameEvent>> change) {
				if (change.wasAdded()) {
					HBox newListElement = makeHBoxDisplay(change.getKey(), change.getValueAdded());
					myDisplayMap.put(change.getKey(), newListElement);
					myCollisionDisplays.add(newListElement);
				}
				if (change.wasRemoved()) {
					myCollisionDisplays.remove(myDisplayMap.remove(change.getKey()));
				}
			}
		});
		myListView = new ListView<HBox>(myCollisionDisplays);
		myView.getChildren().addAll(myListView);
	}

	private HBox makeHBoxDisplay(GameObjectType type, Collection<IGameEvent> events) {
		HBox element = new HBox();
		element.setAlignment(Pos.BASELINE_CENTER);
		Text text = new Text(ResourceManager.getString(type.toString()));
		ComboBox<String> dropdown = makeEventDropdown(events);
		element.setSpacing(100);
		element.getChildren().add(text);
		element.getChildren().add(dropdown);
		System.out.println("Made an hbox");
		return element;
	}

	private ComboBox<String> makeEventDropdown(Collection<IGameEvent> eventList){
		ComboBox<String> eventDropdown = new ComboBox<String>();
		for (IGameEvent event : eventList) {
			System.out.println(event.getClass().getSimpleName());
			eventDropdown.getItems().add(ResourceManager.getString(event.getClass().getSimpleName()));
		}
		return eventDropdown;
	}

	public Node getView() {
		return this.myView;
	}

	@Override
	public void displayData(Map<GameObjectType, Collection<IGameEvent>> data) {
		myCollisions.clear();
		myCollisions.putAll(data);
	}

	@Override
	public void clearDisplay() {
		myCollisions.clear();
		myListView.getItems().clear();
	}

	@Override
	public Map<GameObjectType, Collection<IGameEvent>> getData() {
		return myCollisions;
	}

	@Override
	public void removeSelectedItem() {
		if (!myCollisionDisplays.isEmpty()) {
			int selectedIdx = myListView.getSelectionModel().getSelectedIndex();
			if (selectedIdx == -1) {
				AlertBoxFactory.createObject(ResourceManager.getString("invalid-selection"));
				return;
			}
			myCollisionDisplays.remove(selectedIdx);
		}
		else {
			AlertBoxFactory.createObject(ResourceManager.getString("empty-remove"));
		}
	}

}
