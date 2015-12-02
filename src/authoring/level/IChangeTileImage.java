package authoring.level;

import java.util.ArrayList;
import java.util.Map;

import javafx.scene.image.ImageView;
import xml.data.TileData;

@FunctionalInterface
public interface IChangeTileImage {

	public void changeImage(ArrayList<TileData> selection, Map<TileData, ImageView> imageMap);
	
}
