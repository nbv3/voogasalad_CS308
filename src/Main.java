import com.syntacticsugar.vooga.authoring.objectediting.sizing.ObjectResizer;
import com.syntacticsugar.vooga.authoring.parameters.ParameterInputFactory;
import com.syntacticsugar.vooga.gameplayer.attribute.*;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.*;
import com.syntacticsugar.vooga.gameplayer.attribute.status.SlowAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.status.StunAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.weapon.BasicWeaponAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.weapon.SlowWeaponAttribute;
import com.syntacticsugar.vooga.menu.MainMenu;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import xml.data.ObjectData;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage astage) {
		//new AllTests();
		//new ObjectEditor();
		new MainMenu();
		//new SceneManager(stage);
		/*ObjectData data = new ObjectData();
		data.setImagePath("scenery_gray.png");
		String tileImagePath = "scenery_grass_2.png";*/
		
		AbstractAttribute health = new SlowWeaponAttribute();

		ParameterInputFactory.createInputFields(health);
		
		
		
		
	}
}
	
