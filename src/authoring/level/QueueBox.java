package authoring.level;

import com.syntacticsugar.vooga.authoring.objecteditor.ObjectData;
import com.syntacticsugar.vooga.gameplayer.objects.GameObject;

import authoring.icons.panes.ImageIconPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class QueueBox {
	private VBox myEnemy;
	private ImageView myImage;
	private HBox mySpawnCount;
	private HBox myHealth;

	public QueueBox(ObjectData data) {
		myEnemy = new VBox();
		myImage = new ImageView(data.getImagePath());
		myEnemy.getChildren().add(myImage);
	}

	public VBox getContent() {
		return myEnemy;
	}

}
