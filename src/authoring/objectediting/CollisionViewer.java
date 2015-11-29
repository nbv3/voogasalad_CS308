package authoring.objectediting;

import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class CollisionViewer extends EditingViewer {

	public CollisionViewer() {
		super(ResourceManager.getString("collision_menu_title"));
		// TODO Auto-generated constructor stub
	}
	
	private HBox makeListElement(GameObjectType objectType, IGameEvent gameEvent){
		HBox element = new HBox();
		return element;
	}
	

}
