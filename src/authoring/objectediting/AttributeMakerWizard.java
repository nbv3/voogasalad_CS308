package authoring.objectediting;

import com.syntacticsugar.vooga.authoring.objecteditor.ObjectData;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AttributeMakerWizard {

	private Stage myStage;
	private VBox myStageContent;
	private ObjectData myData;
	private GameObjectType myTypeChosen;
	private final int MIN_STAGE_DIMENSION = 100;

	public AttributeMakerWizard(){
		//myData = new ObjectData();
		myStage = new Stage();
		setMinStageDimension(MIN_STAGE_DIMENSION);
		myStageContent = new VBox();
	}
	
	private void setMinStageDimension(int minDimension){
		myStage.setMinWidth(minDimension);
		myStage.setMinHeight(minDimension);
	}
	
}
