package authoring.level;

import java.util.ArrayList;
import java.util.Map;

import authoring.data.TileData;
import javafx.scene.image.ImageView;

@FunctionalInterface
public interface IChangeTileImage {

	public void changeImage(ArrayList<TileData> selection, Map<TileData, ImageView> imageMap);
	
}
